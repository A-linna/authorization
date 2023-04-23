package com.wingliberty.authorization.exc;

/**
 * @author aiLun
 * @date 2023/4/22-20:32
 */
public enum ErrorCode {
    INNER_ERROR(5000,"服务异常"),

    USER_EXIST(40001,"用户存在"),
    CODE_ERROR(4002, "验证码错误"),

    ;
    final int code;
    final String desc;

    ErrorCode(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }
}
