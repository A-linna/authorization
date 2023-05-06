package com.wingliberty.authorization.infrastructure.util.exc;

/**
 * @author aiLun
 * @date 2023/5/6-11:44
 */
public class AuthException extends RuntimeException{
    private int code;

    public AuthException(int code, String message) {
        super(message);
    }
}
