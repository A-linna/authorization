package com.wingliberty.authorization.feign;

import com.wingliberty.authorization.dto.PhoneVerificationCodeDTO;
import com.wingliberty.common.dto.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author aiLun
 * @date 2023/4/23-16:59
 */
@FeignClient(name = "message")
public interface MessageFeignClient {


    @PostMapping("/sms/verify")
    Result<Boolean> verifyCode(@RequestBody PhoneVerificationCodeDTO createAccountDTO);

}
