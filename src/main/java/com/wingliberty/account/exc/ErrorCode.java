package com.wingliberty.account.exc;

/**
 * @author aiLun
 * @date 2023/4/22-20:32
 */
public enum ErrorCode {

    USER_EXIST(40001,"用户存在"),

    ;
    final int code;
    final String desc;

    ErrorCode(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }
}
