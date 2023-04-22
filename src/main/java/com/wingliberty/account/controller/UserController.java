package com.wingliberty.account.controller;

import com.wingliberty.account.dto.PhoneDTO;
import com.wingliberty.account.dto.UserDTO;
import com.wingliberty.account.service.UserService;
import com.wingliberty.common.dto.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @author aiLun
 * @date 2023/4/22-17:31
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 根据手机号创建账号
     *
     * @param phoneDTO
     * @return
     */
    @PostMapping("/account/phone")
    public Result<UserDTO> createAccountByPhone(@RequestBody @Validated PhoneDTO phoneDTO) {
        UserDTO userDTO = userService.createAccountByPhone(phoneDTO.getPhone());
        return Result.success(userDTO);
    }

}
