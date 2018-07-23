/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 10:37
 **/
package com.wip.utils;

import javafx.collections.MapChangeListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map 缓存实现
 */
public class MapCache {
    /**
     * 默认存储1024个缓存
     */
    private static final int DEFAULT_CACHES = 1024;

    private static final MapCache INS = new MapCache();

    public static MapCache single() {
        return INS;
    }

    /**
     * 缓存容器
     */
    private Map<String, CacheObject> cachePool;

    public MapCache() {
        this(DEFAULT_CACHES);
    }

    public MapCache(int cacheCount) {
        cachePool = new ConcurrentHashMap<>(cacheCount);
    }


    /**
     * 设置一个缓存并带过期时间
     * @param key       缓存key
     * @param value     绑在value
     * @param expired   过期时间，单位为秒
     */
    public void set(String key, Object value, long expired) {
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        CacheObject cacheObject = new CacheObject(key, value, expired);
        cachePool.put(key,cacheObject);
    }

    /**
     * 设置一个hash缓存
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value) {
        this.hset(key,field,value,-1);
    }


    /**
     * 设置一个hash缓存并带过期时间
     * @param key       缓存key
     * @param field     缓存field
     * @param value     缓存value
     * @param expired   过期时间，单位为秒
     */
    public void hset(String key, String field, Object value, long expired) {
        key = key + ":" + field;
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        CacheObject cacheObject = new CacheObject(key,value,expired);
        cachePool.put(key,cacheObject);
    }

    /**
     * 读取一个hash类型的缓存
     * @param key       缓存key
     * @param field     缓存field
     * @param <T>
     * @return
     */
    public <T> T hget(String key, String field) {
        key = key + ":" + field;
        return this.get(key);
    }

    /**
     * 读取一个缓存
     * @param key   缓存key
     * @param <T>
     * @return
     */
    public <T> T get(String key) {
        CacheObject cacheObject = cachePool.get(key);
        if (null != cacheObject) {
            long cur = System.currentTimeMillis() / 1000;
            if (cacheObject.getExpired() <= 0 || cacheObject.getExpired() > cur) {
                Object result = cacheObject.getValue();
                return (T) result;
            }
        }
        return null;
    }


    /**
     * 缓存对象
     */
    static class CacheObject {
        private String key;
        private Object value;
        private long expired;

        public CacheObject(String key, Object value, long expired) {
            this.key = key;
            this.value = value;
            this.expired = expired;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public long getExpired() {
            return expired;
        }

    }

}
