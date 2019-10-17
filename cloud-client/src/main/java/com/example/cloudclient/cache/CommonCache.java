package com.example.cloudclient.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Repository;

/**
 * @ClassName CommonCache
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/10/16 15:04
 * @Version 1.0
 */
@Repository("commonSimpleCache")
public class CommonCache{

    @Autowired
    private CacheManager cacheManager;

    public void putString(CacheKey cacheKey, String key, String value) {
        cacheManager.getCache("common_simple_cache").put(cacheKey.name() + "-" + key, value);
    }

    public String getString(CacheKey cacheKey, String key) {
        final Cache.ValueWrapper common_simple_cache = ((RedisCache) cacheManager.getCache("common_simple_cache")).get(cacheKey.name() + "-" + key);
        return common_simple_cache.toString();
    }

    public void removeString(CacheKey cacheKey, String key) {
        cacheManager.getCache("common_simple_cache").evict(cacheKey.name() + "-" + key);
    }

    public void putObj(CacheKey cacheKey, String key, Object obj) {
        cacheManager.getCache("common_simple_cache").put(cacheKey.name() + "-" + key, obj);
    }

    public Object getObj(CacheKey cacheKey, String key) {
        if (((RedisCache) cacheManager.getCache("common_simple_cache")).get(cacheKey.name() + "-" + key) == null) {
            return null;
        }
        return ((RedisCache)cacheManager.getCache("common_simple_cache")).get(cacheKey.name() + "-" + key).get();
    }

    public void removeObj(CacheKey cacheKey, String key) {
        cacheManager.getCache("common_simple_cache").evict(cacheKey.name() + "-" + key);
    }


}
