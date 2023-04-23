package com.wingliberty.authorization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author aiLun
 * @date 2023/4/21-19:30
 */

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.wingliberty.authorization.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class);
    }
}
