package org.xdz.handler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdz.dto.Response;
import org.xdz.pojo.MenuInfo;
import org.xdz.service.MenuinfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MenuHandler {
    @Resource
    private MenuinfoService menuinfoService;
    @PostMapping("/getMenu")
    public Response menu( HttpSession session){
        String admin = (String) session.getAttribute("admin");
        System.out.println("管理员"+admin);
        List<MenuInfo>  menuInfos = menuinfoService.select(1);
        return Response.rspData("0",menuInfos);
    };
}
