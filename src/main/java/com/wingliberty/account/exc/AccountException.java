package com.wingliberty.account.exc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aiLun
 * @date 2023/4/22-20:32
 */
@Getter
@Setter
public class AccountException extends RuntimeException{
    private int code;
    private String message;

    public AccountException(ErrorCode errorCode) {
        this.code = errorCode.code;
        this.message = errorCode.desc;
    }
}
