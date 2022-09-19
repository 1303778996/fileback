package org.xdz.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SystemService {
    // 判断jwt是否合法
    Boolean isSafeByJWT(HttpServletRequest request);
    // 获取JWT参数信息
    <T>T getObjectByJwt(HttpServletRequest request, Class<T> clazz);
    // 保存JWT参数信息
    <T>Boolean saveObjectByJWT(HttpServletResponse response, T t);
}