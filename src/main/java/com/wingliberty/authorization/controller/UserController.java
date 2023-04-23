package com.wingliberty.authorization.controller;

import com.wingliberty.authorization.config.ValueConfig;
import com.wingliberty.authorization.dto.PhoneVerificationCodeDTO;
import com.wingliberty.authorization.dto.UserDTO;
import com.wingliberty.authorization.service.UserService;
import com.wingliberty.authorization.util.JwtUtil;
import com.wingliberty.common.dto.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    private ValueConfig valueConfig;
    @Autowired
    private UserService userService;


    /**
     * 根据手机号创建账号
     *
     * @param phoneVerificationCodeDTO
     * @return
     */
    @PostMapping("/account/phone")
    public Result<UserDTO> createAccountByPhone(@RequestBody @Validated PhoneVerificationCodeDTO phoneVerificationCodeDTO) {
        UserDTO userDTO = userService.createAccountByPhone(phoneVerificationCodeDTO);
        return Result.success(userDTO);
    }


    @GetMapping("/test")
    public String get() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "19");
       return JwtUtil.generationToken(map);
    }

}
