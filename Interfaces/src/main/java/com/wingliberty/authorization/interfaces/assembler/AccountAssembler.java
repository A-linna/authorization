package com.wingliberty.authorization.interfaces.assembler;

import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.interfaces.dto.AuthDTO;

import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/5/6-11:13
 */
public class AccountAssembler {

    public static AuthEntity assembler(AuthDTO authDTO) {
        if (Objects.isNull(authDTO)) {
            return null;
        }
        AuthEntity authEntity = new AuthEntity();
        authEntity.setUserName(authDTO.getUserName())
                .setPassword(authDTO.getPassword());
        return authEntity;
    }
}
