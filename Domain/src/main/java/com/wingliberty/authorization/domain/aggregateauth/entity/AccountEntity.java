package com.wingliberty.authorization.domain.aggregateauth.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wingliberty.authorization.domain.aggregateauth.repository.AccountRepository;
import com.wingliberty.authorization.domain.aggregateauth.vo.Token;
import com.wingliberty.authorization.domain.utils.SpringBeanUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/5/6-11:09
 */
@Data
@Accessors(chain = true)
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
        this.accountRepository = SpringBeanUtil.getBean(AccountRepository.class);
    }

    /**
     * 用户注册
     */
    public void register() {
        if (StringUtils.isBlank(this.userName)
                || StringUtils.isBlank(this.password)
                || StringUtils.isBlank(this.phone)) {
            throw new IllegalArgumentException("Invalid Param");
        }
        accountRepository.save(this);
    }

    public Token loginByPassword() {
        AccountEntity accountEntity= accountRepository.findByUserName(this.userName);
        if (Objects.isNull(accountEntity)) {
            throw new IllegalArgumentException("not find userName");
        }
        if (!accountEntity.getPassword().equals(this.password)) {
            throw new IllegalArgumentException("invalid password");
        }
        return null;
    }

    private Token generateToken() {
        String sign = JWT.create()
                .withClaim("userId", this.id)
                .withClaim("userName", this.userName)
                .sign(Algorithm.HMAC256(""));
        return null;
    }

}
