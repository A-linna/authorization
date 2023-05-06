package com.wingliberty.authorization.domain.aggregateauth.repository;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;

/**
 * @author aiLun
 * @date 2023/5/6-14:55
 */
public interface AccountRepository {


    void save(AccountEntity accountEntity);
}
