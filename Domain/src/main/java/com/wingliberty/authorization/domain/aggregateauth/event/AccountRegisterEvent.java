package com.wingliberty.authorization.domain.aggregateauth.event;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;

/**
 * @author aiLun
 * @date 2023/5/6-22:45
 */
public class AccountRegisterEvent {

    private AccountEntity accountEntity;


    public AccountRegisterEvent(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
