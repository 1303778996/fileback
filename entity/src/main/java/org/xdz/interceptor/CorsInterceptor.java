package org.xdz.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器】】】】】】");
        String origin = request.getHeader("Origin");  // http://localhost:8080
        // 1.允许所有的url跨域请求
        response.setHeader("Access-Control-Allow-Origin", origin);
        // 2.允许所有的请求方式跨域
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        // 3.允许保存数据，最大时间1800秒
        response.setHeader("Access-Control-Max-Age", "1800");
        // 4.允许携带在header头部的参数信息，这些以外的参数都不允许携带
        //  设置  受支持请求标头（自定义  可以访问的请求头  例如：Token）
//        // 告知系统，如果是跨域，请求头只允许使用"content-type"参数
        response.setHeader("Access-Control-Allow-Headers","authorization, content-type,token,identify");
//
//        // 告知系统，返回的数据类型中允许携带这两种数据信息在头部
//        response.setHeader("Access-Control-Expose-Headers", "content-type,x-requested-with,Authorization,token,Origin,Content-Type,Accept,tokenStr");
        // 告知系统，返回的数据类型中允许携带这两种数据信息在头部
//        response.setHeader("Access-Control-Expose-Headers", "content-type, Authorization");
        // 指示的请求的响应是否可以暴露于该页面。当true值返回时它可以被暴露
        // 5.允许保存session信息
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 告知系统，返回的数据类型中允许携带这两种数据信息在头部
        response.setHeader("Access-Control-Expose-Headers", "content-type,x-requested-with,Authorization,");
//        response.addHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));

        //如果是OPTIONS请求，让其响应一个 200状态码，说明可以正常访问

        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }

        return true;
    }
}