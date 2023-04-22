package com.wingliberty.account.service;

import com.wingliberty.account.dto.UserDTO;

/**
 * @author aiLun
 * @date 2023/4/22-19:02
 */
public interface UserService {

    /**
     * 根据手机号创建账户
     *
     * @param phone
     * @return
     */
    UserDTO createAccountByPhone(String phone);
}
