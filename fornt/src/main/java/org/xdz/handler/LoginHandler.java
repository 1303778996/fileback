package org.xdz.handler;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdz.dto.Response;
import org.xdz.dto.ResponseEnum;
import org.xdz.exception.WebException;
import org.xdz.pojo.CareerInfo;
import org.xdz.pojo.EduInfo;
import org.xdz.pojo.UserInfo;
import org.xdz.service.CareerInfoService;
import org.xdz.service.EduInfoService;
import org.xdz.service.UserInfoService;
import org.xdz.util.NoteUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class LoginHandler {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private EduInfoService eduInfoService;
    @Resource
    private CareerInfoService careerInfoService;
    @Resource
    private NoteUtil noteUtil;

    @PostMapping("/doLogin")
    public Response login(String acc, String pwd, String code, HttpSession session) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAccount(acc);
        System.out.println(pwd);
        UserInfo login = userInfoService.login(userInfo);
        System.out.println(login.getUserPwd());
        if (login == null) {
            throw new WebException("账号不存在");
        }
        if (!login.getUserPwd().equals(pwd)) {
            throw new WebException("账号密码错误");
        }
        session.setAttribute("adminId", acc);
        session.setAttribute("adminName", login.getUserName());
        return Response.rspData(ResponseEnum.REG_SUCCESS);

    }
    @PostMapping("/getcar")
    public  Response getcareer(){
        List<CareerInfo> careerInfos = careerInfoService.selList();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("list",careerInfos);
        return Response.rspData("0",map);
    }
    @PostMapping("/code")
    public Response code(String userAcc, HttpServletRequest request) {
        Random random = new Random();
        int ran = random.nextInt(899999) + 100000;
        String code = noteUtil.sendNote(userAcc, "" + ran);
        System.err.println(
                ran + "======================================"
        );
        String cadeString = Integer.toString(ran);
        // 将验证码保存起来
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("code", cadeString);
        return Response.rspMsg("0", code);
    }
    @PostMapping("/getedu")
    public Response getEdu(){
        List<EduInfo> eduInfos = eduInfoService.selList();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("edu",eduInfos);
        return Response.rspData("0",map);

    }


    @PostMapping("reg")
    public Response reg(String acc,String name,String pwd,Integer car ,Integer edu,String  phone,Integer age){
        if (userInfoService.sleByAcc(acc)!=null){
            return Response.rspMsg(ResponseEnum.REG_ERR);
        }
        int sorce=2;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAccount(acc);
        userInfo.setUserTel(phone);
        userInfo.setUserPwd(pwd);
        userInfo.setCareerId(car);
        userInfo.setUserName(name);
        userInfo.setEduId(edu);
        userInfo.setUserScore(sorce);
        int reg = userInfoService.reg(userInfo);
        if(reg<=0){
            return Response.rspMsg(ResponseEnum.REG_ERR);
        }
        return Response.rspMsg(ResponseEnum.REG_SUCCESS);

    }
}
