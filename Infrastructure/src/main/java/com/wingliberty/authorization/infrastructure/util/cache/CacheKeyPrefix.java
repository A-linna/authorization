package com.wingliberty.authorization.infrastructure.util.cache;

import java.util.Objects;

/**
 * @author aiLun
 * @date 2023/5/7-19:49
 */
public enum CacheKeyPrefix {

    REFRESH_TOKEN("refresh_token:"),
    ACCESS_TOKEN("access_token:")

    ;

    final String prefix;

    private static final String KEY_PREFIX = "auth:";

    CacheKeyPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static String buildKey(CacheKeyPrefix prefix, Object...arg) {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_PREFIX);
        sb.append(prefix.getPrefix());
        if (Objects.nonNull(arg)) {
            for (Object s : arg) {
                sb.append(s.toString());
            }
        }
        return sb.toString();
    }
}
