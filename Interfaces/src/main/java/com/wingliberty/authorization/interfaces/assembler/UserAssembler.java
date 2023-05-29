package com.wingliberty.authorization.interfaces.assembler;

import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.interfaces.dto.UserDTO;

/**
 * @author aiLun
 * @date 2023/5/8-16:07
 */
public class UserAssembler {

    public static UserDTO assembler(AuthEntity authEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(authEntity.getUserName())
                .setUserId(authEntity.getId())
                .setPhone(authEntity.getPhone());
        return userDTO;
    }
}
