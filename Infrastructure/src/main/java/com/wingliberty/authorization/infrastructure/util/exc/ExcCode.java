package com.wingliberty.authorization.infrastructure.util.exc;

/**
 * @author aiLun
 * @date 2023/5/6-11:45
 */
public enum ExcCode {

    INVALID_PARAM(40001, "Invalid Param"),
    ;

    final int code;
    final String message;

    ExcCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
