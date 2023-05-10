package com.wingliberty.authorization.domain.aggregateauth.vo;

import com.wingliberty.authorization.domain.aggregateauth.constant.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author aiLun
 * @date 2023/5/8-15:01
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginInfo {
    private Long userId;
    private String userName;
    private TokenType tokenType;
}
