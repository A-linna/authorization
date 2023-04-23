package com.wingliberty.authorization.db;

import com.wingliberty.authorization.constant.UserStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDO {
    private Long id;

    private String userName;

    private String headImage;

    private String password;

    private String phone;

    private String nickName;

    private UserStatusEnum status;

    private Date createTime;

    private Date updateTime;

}