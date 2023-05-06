package com.wingliberty.authorization.domain.aggregateauth.factory;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import com.wingliberty.authorization.domain.aggregateauth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author aiLun
 * @date 2023/5/6-18:41
 */
@Component
public class AccountFactory {
    private AccountRepository accountRepository;

    @Autowired
    public AccountFactory( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity createAccountEntity() {
        return new AccountEntity(accountRepository);
    }
}
