package com.wingliberty.authorization.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author aiLun
 * @date 2023/5/8-16:06
 */
@Data
@Accessors(chain = true)
public class UserDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    private String userName;

    private String phone;
}
