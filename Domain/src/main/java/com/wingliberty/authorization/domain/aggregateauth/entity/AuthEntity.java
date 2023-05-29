package com.wingliberty.authorization.domain.aggregateauth.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wingliberty.authorization.domain.aggregateauth.repository.AuthRepository;
import com.wingliberty.authorization.domain.aggregateauth.vo.Token;
import com.wingliberty.authorization.domain.utils.SpringBeanUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class AuthEntity {

    private String ACCESS_SALT = "g-3DP_Kjm@=j#E9m";
    private String REFRESH_SALT = "PAEC0LD__u#BQkF*";

    private AuthRepository authRepository;

    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String status;

    private String accessToken;

    private String refreshToken;

    private Date createTime;

    private Date updateTime;

    public AuthEntity() {
        this.authRepository = SpringBeanUtil.getBean(AuthRepository.class);
    }

    public AuthEntity(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    /**
     * 校验账号存
     * true 存在
     * false 不存在
     *
     * @return
     */
    public boolean checkExist() {
        AuthEntity authEntity = authRepository.findByUserName(userName);
        return Objects.nonNull(authEntity);
    }

    public void checkUserNameAndPassword() {
        AuthEntity authEntity = authRepository.findByUserName(userName);
        if (Objects.isNull(authEntity)) {
            throw new IllegalArgumentException("invalid userName");
        }
        if (!password.equals(authEntity.getPassword())) {
            throw new IllegalArgumentException("invalid password");
        }
        this.id = authEntity.getId();
    }

    /**
     * 用户注册
     */
    public void register() {
        authRepository.save(this);
    }

    public Token generateToken() {
        String accessToken = JWT.create().withClaim("userId", id)
                .withClaim("userName", userName)
                .sign(Algorithm.HMAC256(ACCESS_SALT));

        String refreshToken = JWT.create().withClaim("userId", id)
                .withClaim("userName", userName)
                .sign(Algorithm.HMAC256(REFRESH_SALT));
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        authRepository.update(this);
        return new Token().setAccessToken(accessToken)
                .setRefreshToken(refreshToken);

    }

    public void parseToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Long userId = decodedJWT.getClaim("userId").asLong();
        String userName = decodedJWT.getClaim("userName").asString();
        this.id = userId;
        this.userName = userName;
    }


}