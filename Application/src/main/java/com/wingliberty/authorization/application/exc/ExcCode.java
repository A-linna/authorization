package com.wingliberty.authorization.application.exc;

/**
 * @author aiLun
 * @date 2023/5/10-15:43
 */
public enum ExcCode {

    TOKEN_INVALID("token失效",40001)
    ;

    final String desc;
    final int code;

    ExcCode(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
