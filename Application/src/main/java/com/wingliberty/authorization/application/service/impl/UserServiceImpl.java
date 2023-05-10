package com.wingliberty.authorization.application.service.impl;

import com.wingliberty.authorization.application.exc.AuthException;
import com.wingliberty.authorization.application.exc.ExcCode;
import com.wingliberty.authorization.application.service.UserService;
import com.wingliberty.authorization.domain.aggregateauth.constant.TokenType;
import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.domain.aggregateauth.vo.Token;
import com.wingliberty.authorization.infrastructure.util.cache.CacheKeyPrefix;
import com.wingliberty.authorization.infrastructure.util.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/5/6-11:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CacheService cacheService;

    @Override
    public void createAccount(AuthEntity authEntity) {
        boolean exist = authEntity.checkExist();
        if (exist) {
            throw new IllegalArgumentException("userName exist");
        }
        authEntity.register();
    }

    @Override
    public Token loginByPassword(AuthEntity entity) {
        entity.checkUserNameAndPassword();
        Token token = entity.generateToken();
        cacheToken(entity.getId(), token);
        return token;
    }



    @Override
    public AuthEntity checkToken(String token, TokenType tokenType) {
        AuthEntity entity = new AuthEntity();
        entity.parseToken(token);
        String cacheKey;
        if (TokenType.ACCESS_TOKEN.equals(tokenType)) {
            cacheKey = CacheKeyPrefix.buildKey(CacheKeyPrefix.ACCESS_TOKEN, entity.getId());
        } else {
            cacheKey = CacheKeyPrefix.buildKey(CacheKeyPrefix.REFRESH_TOKEN, entity.getId());
        }
        String cacheToken = cacheService.get(cacheKey);
        if (token.equals(cacheToken)) {
            return entity;
        }
        throw new AuthException(ExcCode.TOKEN_INVALID);
    }

    @Override
    public Token refreshToken(String refreshToken) {
        AuthEntity authEntity = checkToken(refreshToken, TokenType.REFRESH_TOKEN);
        if (Objects.isNull(authEntity)) {
            throw new IllegalArgumentException();
        }
        Token token = authEntity.generateToken();
        cacheToken(authEntity.getId(), token);
        return token;
    }

    private void cacheToken(Long userId, Token token) {
        String refreshKey = CacheKeyPrefix.buildKey(CacheKeyPrefix.REFRESH_TOKEN, userId);
        cacheService.set(refreshKey, token.getRefreshToken(), 60 * 60 * 24 * 7L);
        String accessKey = CacheKeyPrefix.buildKey(CacheKeyPrefix.ACCESS_TOKEN, userId);
        cacheService.set(accessKey, token.getAccessToken(), 60 * 60 * 4L);
    }
}
