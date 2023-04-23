package com.wingliberty.authorization.exc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aiLun
 * @date 2023/4/22-20:32
 */
@Getter
@Setter
public class AuthorizationException extends RuntimeException{
    private int code;
    private String message;

    public AuthorizationException(ErrorCode errorCode) {
        this.code = errorCode.code;
        this.message = errorCode.desc;
    }
}
