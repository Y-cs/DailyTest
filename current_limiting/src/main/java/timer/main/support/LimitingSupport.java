package timer.main.support;

import timer.main.context.LimitingGroupObject;
import timer.main.exception.LimitingCreateException;

import java.util.concurrent.TimeUnit;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/15 10:22
 * @Description:
 **/
public interface LimitingSupport {

    default boolean tryAcquire(String key, long flow) throws LimitingCreateException {
        return tryAcquire(key, flow, 1);
    }

    default boolean tryAcquire(String key, long flow,long time) throws LimitingCreateException {
        return tryAcquire(key, flow, time,TimeUnit.SECONDS);
    }

    /**
     * 尝试获取
     *
     * @param flow
     */
    public boolean tryAcquire(String key, long flow,long time, TimeUnit timeUnit) throws LimitingCreateException;

    /**
     * 获取
     *
     * @param flow
     */
    void acquire(String key, long flow) throws LimitingCreateException;

    LimitingGroupObject getLimitingGroupObject();
}
