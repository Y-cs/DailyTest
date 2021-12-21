package timer.main.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/20 13:37
 * @Description: 本地的限流器信息缓存
 **/
public class LimitingCacheNotExpire<T> implements LimitingCache<T> {

    private final Map<String, T> limitingCache = new ConcurrentHashMap<>();

    @Override
    public void cache(String key, T t) {
        limitingCache.put(key, t);
    }

    @Override
    public T get(String key) {
        return limitingCache.get(key);
    }

}
