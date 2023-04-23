package com.wingliberty.authorization.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author aiLun
 * @date 2023/4/23-10:13
 */

@RefreshScope
@Component
@Data
public class ValueConfig {

    @Value("${jwt.slat}")
    private String jwtSlat;

}
