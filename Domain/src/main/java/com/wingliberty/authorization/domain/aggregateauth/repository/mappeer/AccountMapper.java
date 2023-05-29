package com.wingliberty.authorization.domain.aggregateauth.repository.mappeer;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author aiLun
 * @date 2023/5/6-18:45
 */
public interface AccountMapper {

    void insertSelective(AccountEntity accountEntity);

    AccountEntity findByUserName(@Param("userName") String userName);
}
