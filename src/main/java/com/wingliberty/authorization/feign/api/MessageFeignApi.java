package com.wingliberty.authorization.feign.api;

import com.wingliberty.authorization.dto.PhoneVerificationCodeDTO;
import com.wingliberty.authorization.exc.AuthorizationException;
import com.wingliberty.authorization.exc.ErrorCode;
import com.wingliberty.authorization.feign.MessageFeignClient;
import com.wingliberty.common.dto.response.Result;
import com.wingliberty.common.dto.response.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 消息服务api
 *
 * @author aiLun
 * @date 2023/4/23-16:59
 */
@Component
public class MessageFeignApi {

    @Autowired
    private MessageFeignClient messageFeignClient;

    /**
     * 校验验证码
     *
     * @param phoneVerificationCodeDTO
     * @return
     */
    public boolean verifyCode(PhoneVerificationCodeDTO phoneVerificationCodeDTO) {
        try {
            Result<Boolean> result = messageFeignClient.verifyCode(phoneVerificationCodeDTO);
            if (Objects.isNull(result) || result.getCode() != ResultCode.success.getCode()) {
                return false;
            }
            return Boolean.TRUE.equals(result.getData());
        } catch (Exception e) {
            //todo  日志
            throw new AuthorizationException(ErrorCode.INNER_ERROR);
        }
    }
}
