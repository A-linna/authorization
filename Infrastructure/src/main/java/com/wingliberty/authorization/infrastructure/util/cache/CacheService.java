package com.wingliberty.authorization.infrastructure.util.cache;

/**
 * @author aiLun
 * @date 2023/5/7-13:47
 */
public interface CacheService {


    void set(String key, String value, Long duration);

    String get(String key);
}
