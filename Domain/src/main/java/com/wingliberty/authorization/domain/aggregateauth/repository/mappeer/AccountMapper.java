package com.wingliberty.authorization.domain.aggregateauth.repository.mappeer;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;

/**
 * @author aiLun
 * @date 2023/5/6-18:45
 */
public interface AccountMapper {

    void insertSelective(AccountEntity accountEntity);
}
