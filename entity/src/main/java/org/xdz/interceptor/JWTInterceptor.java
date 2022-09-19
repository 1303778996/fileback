package org.xdz.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.xdz.pojo.AdminInfo;
import org.xdz.service.SystemService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Resource
    private SystemService systemService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Boolean isSafe = systemService.isSafeByJWT(request);
        // 如果合法我们将更替超时时间信息
        if(isSafe) {
            AdminInfo adminInfo = systemService.getObjectByJwt(request, AdminInfo.class);
            systemService.saveObjectByJWT(response, adminInfo);
        }
        return true;
    }
}