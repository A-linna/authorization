package com.wingliberty.authorization.dto;

import com.wingliberty.authorization.constant.UserStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author aiLun
 * @date 2023/4/22-20:52
 */
@Data
@Accessors(chain = true)
public class UserDTO {
    private Long id;

    private String userName;

    private String headImage;

    private String phone;

    private String nickName;

    private UserStatusEnum status;

}
