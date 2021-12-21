package timer.main.context;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import timer.main.cache.CacheFactory;
import timer.main.cache.LimitingCache;
import timer.main.exception.LimitingCreateException;
import timer.main.support.LimitingSupport;
import timer.main.support.LimitingSupportByRedisImpl;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/20 14:40
 * @Description:
 **/
public class LimitingContext {

    private RedissonClient redisson;
    /**
     * 组缓存对象
     */
    private final LimitingCache<LimitingSupport> limitingGroupCache;

    public LimitingContext() {
        /**
         * 不需要过期的缓存
         */
        this.limitingGroupCache = CacheFactory.createCache(false);
    }

    /**
     * 注册一个限流器
     */
    public LimitingSupport register(LimitingGroupObject limitingGroupObject) throws LimitingCreateException {
        if (limitingGroupObject != null && limitingGroupObject.getGroup() != null && limitingGroupObject.getGroup().length() > 0) {
            LimitingSupportByRedisImpl limitingSupportByRedis = new LimitingSupportByRedisImpl(this, limitingGroupObject);
            limitingGroupCache.cache(limitingGroupObject.getGroup(), limitingSupportByRedis);
            return limitingSupportByRedis;
        }
        throw new LimitingCreateException("注册限流组,组名不能为空");
    }

    public LimitingSupport getLimitingSupport(String group) {
        return limitingGroupCache.get(group);
    }

    public RedissonClient getRedisson() {
        return redisson;
    }

    public void setRedisson(RedissonClient redisson) {
        this.redisson = redisson;
    }
}
