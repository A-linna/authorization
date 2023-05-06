package com.wingliberty.authorization.interfaces.dto;

import lombok.Data;

/**
 * 账号DTO
 *
 * @author aiLun
 * @date 2023/5/6-10:52
 */
@Data
public class AccountDTO {

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
}
