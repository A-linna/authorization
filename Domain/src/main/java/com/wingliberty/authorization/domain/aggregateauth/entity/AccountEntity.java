package com.wingliberty.authorization.domain.aggregateauth.entity;

import com.wingliberty.authorization.domain.aggregateauth.repository.AccountRepository;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author aiLun
 * @date 2023/5/6-11:09
 */
@Data
public class AccountEntity {

    private AccountRepository accountRepository;

    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //手机
    private String phone;
    //头像
    private String headImage;
    //昵称
    private String nickName;
    private String status;
    private Date createTime;
    private Date updateTime;

    public AccountEntity() {
    }

    public AccountEntity(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void register() {
        if (StringUtils.isBlank(this.userName)
                || StringUtils.isBlank(this.password)
                || StringUtils.isBlank(this.phone)) {
            throw new IllegalArgumentException("Invalid Param");
        }
        accountRepository.save(this);

    }
}
