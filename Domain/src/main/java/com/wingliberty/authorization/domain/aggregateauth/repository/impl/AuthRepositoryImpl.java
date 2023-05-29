package com.wingliberty.authorization.domain.aggregateauth.repository.impl;

import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.domain.aggregateauth.repository.AuthRepository;
import com.wingliberty.authorization.domain.aggregateauth.repository.mappeer.AuthMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author aiLun
 * @date 2023/5/7-12:49
 */
@Repository
public class AuthRepositoryImpl implements AuthRepository {

    @Resource
    private AuthMapper authMapper;

    @Override
    public AuthEntity findByUserName(String userName) {
        return authMapper.findByUserName(userName);
    }

    @Override
    public void save(AuthEntity authEntity) {
        authMapper.insertSelective(authEntity);
    }

    @Override
    public void update(AuthEntity authEntity) {
        authMapper.updateByPrimaryKeySelective(authEntity);
    }
}
