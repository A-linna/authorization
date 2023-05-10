package com.wingliberty.authorization.application.service;

import com.wingliberty.authorization.domain.aggregateauth.constant.TokenType;
import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.domain.aggregateauth.vo.Token;

/**
 * @author aiLun
 * @date 2023/5/6-11:15
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param authEntity
     */
    void createAccount(AuthEntity authEntity);

    Token loginByPassword(AuthEntity authEntity);

    /**
     * token校验
     *
     * @param token
     * @return
     */
    AuthEntity checkToken(String token, TokenType  tokenType);

    Token refreshToken(String refreshToken);
}
