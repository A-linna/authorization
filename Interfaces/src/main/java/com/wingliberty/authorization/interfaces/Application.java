package com.wingliberty.authorization.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author aiLun
 * @date 2023/5/5-12:10
 */
@SpringBootApplication
@ImportResource({"classpath*:exports.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
