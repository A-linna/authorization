package com.wingliberty.authorization.interfaces.facade;

import com.wingliberty.authorization.application.service.UserService;
import com.wingliberty.authorization.domain.aggregateauth.constant.TokenType;
import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import com.wingliberty.authorization.domain.aggregateauth.vo.Token;
import com.wingliberty.authorization.interfaces.assembler.AccountAssembler;
import com.wingliberty.authorization.interfaces.assembler.UserAssembler;
import com.wingliberty.authorization.interfaces.dto.AuthDTO;
import com.wingliberty.authorization.interfaces.dto.TokenDTO;
import com.wingliberty.authorization.interfaces.dto.UserDTO;
import com.wingliberty.common.dto.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author aiLun
 * @date 2023/5/6-11:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 创建用户
     *
     * @param authDTO
     * @return
     */
    @PostMapping("/creation")
    public Result createAccount(@RequestBody AuthDTO authDTO) {
        AuthEntity auth = AccountAssembler.assembler(authDTO);
        userService.createAccount(auth);
        return Result.success();
    }

    /**
     * 密码登录
     *
     * @param authDTO
     * @return
     */
    @PostMapping("/login")
    public Result<Token> loginByPassword(@RequestBody AuthDTO authDTO) {
        AuthEntity auth = AccountAssembler.assembler(authDTO);
        Token token = userService.loginByPassword(auth);
        return Result.success(token);
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    @PostMapping("/check_toke")
    public Result<UserDTO> checkToken(@RequestBody Token token) {
        AuthEntity authEntity = userService.checkToken(token.getAccessToken(), TokenType.ACCESS_TOKEN);
        UserDTO userDTO = UserAssembler.assembler(authEntity);
        return Result.success(userDTO);
    }


    /**
     * 刷新token
     *
     * @param token
     * @return
     */
    @PostMapping("/refresh")
    public Result<TokenDTO> refreshToken(@RequestBody Token token) {
        Token token1= userService.refreshToken(token.getRefreshToken());
        return null;
    }
}
