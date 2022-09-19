package org.xdz.handler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xdz.dto.Response;
import org.xdz.exception.WebException;

@RestControllerAdvice // 这个类是用来编写异常的！
public class WebExceptionHandler {
    @ExceptionHandler(WebException.class) // 当出现此异常的时候执行以下方法
    public Response<String> userExp(WebException ex) {
        return Response.rspMsg("101", ex.getMessage());
    }

//    @ExceptionHandler(Exception.class) // 当出现此异常的时候执行以下方法
//    public Response<UserInfo>  sysExp(Exception ex) {
//        return Response.rspMsg(ResponseEnum.SERVER_ERR);
//    }
}