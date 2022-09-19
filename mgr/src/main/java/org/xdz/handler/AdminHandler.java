package org.xdz.handler;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdz.dto.Response;
import org.xdz.dto.ResponseEnum;
import org.xdz.exception.WebException;
import org.xdz.mapper.MgrLogMapper;
import org.xdz.pojo.AdminInfo;
import org.xdz.qo.AdminQo;
import org.xdz.service.AdminInfoService;
import org.xdz.service.AdminInfoServiceImpl;
import org.xdz.service.MgrLogMapperService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminHandler {
    @Resource
    private AdminInfoService adminInfoService;
    @Resource
    private MgrLogMapperService mgrLogMapperService;

    @PostMapping("/doLogin")
    public Response login(String name, String pwd, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        AdminInfo adminInfo = adminInfoService.login(name);
        if (adminInfo == null) {
            throw new WebException("账号不存在");
        }
        if (adminInfo.getAdminState() != 1) {
            throw new WebException("该账号被禁用");
        }
        System.out.println("前端密码" + pwd);
        if (!adminInfo.getAdminPwd().equals(pwd)) {
            throw new WebException("密码错误");
        }
        HttpSession session1 = request.getSession();
        session.setAttribute("admin", adminInfo.getAdminName());
        session1.setAttribute("adminId",adminInfo.getAdminId());
        return Response.rspData(ResponseEnum.LOGIN_SUCCESS, adminInfo);
    }

    @PostMapping("/initAdmin")
    public Response initAdmin(String adminName, int state, int limit, int offset,HttpSession session) {
       /* adminName: this.adminName,
                state: this.state,
                roleName: this.roleName,
                limit: this.limit,
                offset: this.offset*/
        System.out.println(session.getAttribute("admin"));
        AdminQo adminQo = new AdminQo();
        adminQo.setLim(limit);
        adminQo.setOff(offset);
        adminQo.setAdminState(state);
        adminQo.setAdminName(adminName);
        adminQo.setRoleId(-1);
        int count = adminInfoService.count(adminQo);
        List<AdminInfo> adminInfos = adminInfoService.selectAll(adminQo);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("records", adminInfos);
        return Response.rspData("0", map);
    }

    @PostMapping("addAdmin")
    public Response addAdmin(String adminName, String addAdminPwd,HttpSession session,HttpServletRequest request) {
        AdminQo adminQo = new AdminQo();
        adminQo.setAdminName(adminName);
        adminQo.setAdminPwd(addAdminPwd);
        System.out.println(addAdminPwd);
        System.out.println(adminName);
        int i = adminInfoService.insert(adminQo);
        if (i <= 0) {
            throw new WebException("添加失败");

        }

        String uri = String.valueOf(request.getRequestURL());
        System.out.println(uri);
        String  adminId = (String) session.getAttribute("admin");
       int adminId1 = (int) session.getAttribute("adminId");
        System.out.println("插入id"+adminId1);
        //System.out.println(adminId);
        mgrLogMapperService.insert(adminId1,uri);
        return Response.rspData(ResponseEnum.REG_SUCCESS);
    }
    @PostMapping("/upState")
    public Response upState(HttpSession session,int adminId,HttpServletRequest request){
        int i = adminInfoService.updateState(adminId);
        if(i<=0){
            throw new WebException("修改失败");
        }
        String uri = String.valueOf(request.getRequestURL());
        System.out.println(uri);
        int adminId1 = (int) session.getAttribute("adminId");
        System.out.println("状态id"+adminId1);
        mgrLogMapperService.insert(adminId1,uri);
        return Response.rspData("0",ResponseEnum.SUCCESS);
    }

    @PostMapping("/upPwd")
    public Response upPwd(HttpSession session, int adminId, HttpServletRequest request) {
        int i = adminInfoService.upPwd(adminId);
        if (i <= 0) {
            throw new WebException("重置失败");
        }
        String uri = String.valueOf(request.getRequestURL());
        System.out.println(uri);
        int adminId1 = (int) session.getAttribute("adminId");
        System.out.println("状态id" + adminId1);
        mgrLogMapperService.insert(adminId1, uri);
        return Response.rspData("0", ResponseEnum.SUCCESS);
    }
}
