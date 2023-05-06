package com.wingliberty.authorization.application.service.impl;

import com.wingliberty.authorization.application.service.AccountService;
import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import com.wingliberty.authorization.domain.aggregateauth.factory.AccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aiLun
 * @date 2023/5/6-11:16
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFactory accountFactory;

    @Override
    public void createAccount(AccountEntity accountEntity) {
        AccountEntity accountEntity1 = accountFactory.createAccountEntity();
        accountEntity1.setPhone(accountEntity.getPhone());
        accountEntity1.setUserName(accountEntity.getUserName());
        accountEntity1.setPassword(accountEntity.getPassword());
        accountEntity1.register();

    }
}
