package com.wingliberty.authorization.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author aiLun
 * @date 2023/4/22-19:00
 */
@Data
public class PhoneVerificationCodeDTO {
    @NotBlank(message = "手机号不能为空")
    private String phone;
    //验证码
    private String code;

}
