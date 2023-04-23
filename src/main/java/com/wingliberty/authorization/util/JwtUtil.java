package com.wingliberty.authorization.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wingliberty.authorization.config.SpringBeanUtils;
import com.wingliberty.authorization.config.ValueConfig;

import java.util.Map;

/**
 * @author aiLun
 * @date 2023/4/23-10:44
 */
public class JwtUtil {


    private JwtUtil() {
    }

    public static String generationToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        //过期时间
        //builder.withExpiresAt()
        ValueConfig bean = SpringBeanUtils.getBean(ValueConfig.class);
        String sign = bean.getJwtSlat();
        return builder.sign(Algorithm.HMAC256(sign));
    }

    public static Map parseToken(String token) {
        ValueConfig bean = SpringBeanUtils.getBean(ValueConfig.class);
        String sign = bean.getJwtSlat();
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
        Claim claim = decodedJWT.getClaim("");
        claim.toString();
        return null;
    }

}
