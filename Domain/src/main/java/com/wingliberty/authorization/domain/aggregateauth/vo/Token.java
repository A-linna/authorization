package com.wingliberty.authorization.domain.aggregateauth.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * token 值对象
 *
 * @author aiLun
 * @date 2023/5/6-22:48
 */
@Data
@Accessors(chain = true)
public class Token {
    private String accessToken;

    private String refreshToken;

}
