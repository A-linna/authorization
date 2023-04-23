package com.wingliberty.authorization.service;

import com.wingliberty.authorization.dto.PhoneVerificationCodeDTO;
import com.wingliberty.authorization.dto.UserDTO;

/**
 * @author aiLun
 * @date 2023/4/22-19:02
 */
public interface UserService {

    /**
     * 根据手机号创建账户
     *
     * @param phoneVerificationCodeDTO
     * @return
     */
    UserDTO createAccountByPhone(PhoneVerificationCodeDTO phoneVerificationCodeDTO);
}
