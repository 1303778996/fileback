package org.xdz.service;



import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.xdz.config.JWTTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SystemServiceImpl implements SystemService {

    @Override
    public Boolean isSafeByJWT(HttpServletRequest request) {
        String str = request.getHeader("Authorization");
        if(!StringUtils.hasText(str)) return false;
        if(!str.startsWith("Bearer ")) return false;
        return true;
    }
    @Override
    public <T> T getObjectByJwt(HttpServletRequest request, Class<T> clazz) {
        String str = request.getHeader("Authorization");
        String jwtStr = str.substring("Bearer ".length());
        return new JWTTool<T>().parseToken(jwtStr, clazz);
    }
    @Override
    public <T> Boolean saveObjectByJWT(HttpServletResponse response, T t) {
        String jwtStr = new JWTTool<T>().createToken(t);
        response.setHeader("Authorization", "Bearer " + jwtStr);
        return true;
    }
}