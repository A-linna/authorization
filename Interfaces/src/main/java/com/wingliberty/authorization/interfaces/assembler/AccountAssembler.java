package com.wingliberty.authorization.interfaces.assembler;

import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import com.wingliberty.authorization.interfaces.dto.AccountDTO;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/5/6-11:13
 */
public class AccountAssembler {

    public static AccountEntity assembler(AccountDTO accountDTO) {
        if (Objects.isNull(accountDTO)) {
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, accountEntity);
        return accountEntity;
    }
}
