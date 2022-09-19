package org.xdz.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xdz.interceptor.CorsInterceptor;
import org.xdz.interceptor.JWTInterceptor;

import javax.annotation.Resource;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Resource
    private CorsInterceptor corsInterceptor;
    @Resource
    private JWTInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/face");
    }
}