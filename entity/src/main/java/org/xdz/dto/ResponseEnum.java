package org.xdz.dto;

/**
 * @author gain
 * @title 响应消息枚举
 */
public enum ResponseEnum {
    // 可以根据自己的实际需要增加状态码
    SUCCESS("0", "ok"),
    SERVER_ERR("10086","系统致命故障，请联系管理员..."),
    SERVER_INNER_ERR("500","系统繁忙"),
    PARAM_LACK("100" , "非法参数"),
    OPERATION_FAILED("101" ,"操作失败"),
    LOGIN_SUCCESS("0", "登录成功，即将跳转首页..."),
    LOGIN_ERR("100","账户密码错误"),
    REG_SUCCESS("0", "注册成功,请前往邮箱激活..."),
    REG_ERR("100", "注册失败,改用户已存在..."),
    ;

    private String code;
    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
