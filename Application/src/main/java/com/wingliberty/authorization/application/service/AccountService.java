package com.wingliberty.authorization.application.service;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;

/**
 * @author aiLun
 * @date 2023/5/6-11:15
 */
public interface AccountService {

    /**
     * 创建用户
     *
     * @param accountEntity
     */
    void createAccount(AccountEntity accountEntity);
}
