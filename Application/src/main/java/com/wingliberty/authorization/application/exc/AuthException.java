package com.wingliberty.authorization.application.exc;

/**
 * @author aiLun
 * @date 2023/5/10-15:42
 */
public class AuthException extends RuntimeException{

    private int code;

    public AuthException(ExcCode excCode) {
        super(excCode.getDesc());
        this.code = excCode.getCode();
    }

}
