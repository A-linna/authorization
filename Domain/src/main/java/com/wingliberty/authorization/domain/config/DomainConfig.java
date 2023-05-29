package com.wingliberty.authorization.domain.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author aiLun
 * @date 2023/5/6-15:39
 */
@Configuration
@MapperScan(value = {"com.wingliberty.authorization.domain.aggregateauth.repository.mappeer"})

@ComponentScan({"com.wingliberty.authorization.domain"})
public class DomainConfig {
}
