package com.wingliberty.authorization.domain.aggregateauth.repository;

import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;

/**
 * @author aiLun
 * @date 2023/5/7-12:49
 */
public interface AuthRepository {

    AuthEntity findByUserName(String userName);

    void save(AuthEntity authEntity);

    void update(AuthEntity authEntity);
}
