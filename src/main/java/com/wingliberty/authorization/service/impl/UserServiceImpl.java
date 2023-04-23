package com.wingliberty.authorization.service.impl;

import com.wingliberty.authorization.db.UserDO;
import com.wingliberty.authorization.dto.PhoneVerificationCodeDTO;
import com.wingliberty.authorization.dto.UserDTO;
import com.wingliberty.authorization.exc.AuthorizationException;
import com.wingliberty.authorization.exc.ErrorCode;
import com.wingliberty.authorization.feign.api.MessageFeignApi;
import com.wingliberty.authorization.mapper.UserMapper;
import com.wingliberty.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/4/22-19:03
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MessageFeignApi messageFeignApi;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO createAccountByPhone(PhoneVerificationCodeDTO param) {
        boolean verifyResult = messageFeignApi.verifyCode(param);
        if (!verifyResult) {
            throw new AuthorizationException(ErrorCode.CODE_ERROR);
        }
        String phone = param.getPhone();
        UserDO userDO = userMapper.selectByPhone(phone);
        if (Objects.nonNull(userDO)) {
            throw new AuthorizationException(ErrorCode.USER_EXIST);
        }
        //todo 分布式id
        UserDO createUser = new UserDO().setPhone(phone)
                .setCreateTime(new Date());
        userMapper.insert(createUser);

        return new UserDTO().setId(createUser.getId());
    }
}
