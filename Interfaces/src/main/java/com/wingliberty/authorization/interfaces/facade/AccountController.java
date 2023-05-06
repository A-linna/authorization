package com.wingliberty.authorization.interfaces.facade;

import com.wingliberty.authorization.application.service.AccountService;
import com.wingliberty.authorization.domain.aggregateauth.entity.AccountEntity;
import com.wingliberty.authorization.interfaces.assembler.AccountAssembler;
import com.wingliberty.authorization.interfaces.dto.AccountDTO;
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
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;


    /**
     * 创建用户
     * @param accountDTO
     * @return
     */
    @PostMapping("/creation")
    public Result createAccount(@RequestBody AccountDTO accountDTO) {
        AccountEntity accountEntity = AccountAssembler.assembler(accountDTO);
        accountService.createAccount(accountEntity);

        return Result.success();
    }
}
