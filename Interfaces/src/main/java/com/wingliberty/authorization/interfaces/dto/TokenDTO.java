package com.wingliberty.authorization.interfaces.dto;

import lombok.Data;

/**
 * @author aiLun
 * @date 2023/5/6-22:49
 */
@Data
public class TokenDTO {
    private String accessToken;

    private String refreshToken;
}
