package com.wingliberty.account.service.impl;

import com.wingliberty.account.db.UserDO;
import com.wingliberty.account.dto.UserDTO;
import com.wingliberty.account.exc.AccountException;
import com.wingliberty.account.exc.ErrorCode;
import com.wingliberty.account.mapper.UserMapper;
import com.wingliberty.account.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/4/22-19:03
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO createAccountByPhone(String phone) {
        UserDO userDO= userMapper.selectByPhone(phone);
        if (Objects.nonNull(userDO)) {
            throw new AccountException(ErrorCode.USER_EXIST);
        }
        //todo 分布式id
        UserDO createUser = new UserDO().setPhone(phone)
                .setCreateTime(new Date());
        userMapper.insert(createUser);

        return new UserDTO().setId(createUser.getId());
    }
}
