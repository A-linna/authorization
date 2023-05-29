CREATE TABLE `auth`
(
    `id`            bigint       NOT NULL,
    `user_name`     varchar(45)  NOT NULL COMMENT '用户账号',
    `password`      varchar(150) NOT NULL COMMENT '密码',
    `phone`         varchar(20)  NOT NULL COMMENT '手机号',
    `access_token`  varchar(200) DEFAULT NULL COMMENT '访问token',
    `refresh_token` varchar(200) DEFAULT NULL COMMENT '刷新token',
    `create_time`   datetime     NOT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `phone` (`phone`),
    UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户授权表';
