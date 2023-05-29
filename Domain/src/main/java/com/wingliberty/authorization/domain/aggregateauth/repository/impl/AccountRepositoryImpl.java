package com.wingliberty.authorization.domain.aggregateauth.repository.impl;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import com.wingliberty.authorization.domain.aggregateauth.repository.AccountRepository;
import com.wingliberty.authorization.domain.aggregateauth.repository.mappeer.AccountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author aiLun
 * @date 2023/5/6-14:57
 */
@Repository
public class AccountRepositoryImpl  implements AccountRepository {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public void save(AccountEntity accountEntity) {
        accountMapper.insertSelective(accountEntity);
    }

    @Override
    public AccountEntity findByUserName(String userName) {
        return   accountMapper.findByUserName(userName);
    }
}
