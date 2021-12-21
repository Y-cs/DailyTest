package timer.main.context;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;
import timer.main.adapter.LimitingGroupAdapter;
import timer.main.ano.Limiting;
import timer.main.ano.LimitingGroup;
import timer.main.exception.LimitingCreateException;
import timer.main.support.LimitingSupport;
import timer.main.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/21 11:54
 * @Description:
 **/
@Slf4j
public class OperationLimiting {

    private final LimitingContext limitingContext;

    public OperationLimiting(LimitingContext limitingContext) {
        this.limitingContext = limitingContext;
    }

    public boolean acquire(Class<?> clazz, MethodSignature methodSignature, Limiting limiting, HttpServletRequest httpServletRequest) throws Exception {
        if (limiting.group() != null && limiting.group().length > 0) {
            LimitingGroup[] group = limiting.group();
            String key = "";
            for (LimitingGroup limitingGroup : group) {
                key = limitingGroup.group() == null || limitingGroup.group().trim().length() == 0 ? this.getDefaultKey(clazz, methodSignature) : limitingGroup.group();
                LimitingSupport limitingSupport = getOrRegister(key, limitingGroup);
                String cacheKey = getCacheKey(key, limitingGroup, httpServletRequest);
                if (limiting.permits() > limitingGroup.permitsPerTime()) {
                    throw new RuntimeException("请求的令牌数不能大于生产速率");
                }
                if (!limitingSupport.tryAcquire(cacheKey, limiting.permits(), limiting.waitTime())) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getCacheKey(String key, LimitingGroup limitingGroup, HttpServletRequest httpServletRequest) {
        switch (limitingGroup.partitionEnum()) {
            case IP:
                String ipAddress = "";
                if (httpServletRequest != null) {
                    ipAddress = ServletUtil.getIpAddress(httpServletRequest);
                }
                if (ipAddress != null && ipAddress.length() > 0) {
                    return key + ":" + ipAddress;
                }
                log.warn("无法获取用户ip");
            case ALL:
                return key;
            case CODE:
                throw new RuntimeException("暂不支持");
            default:
                //不会发生
                throw new RuntimeException("不会发生");
        }
    }

    private LimitingSupport getOrRegister(String key, LimitingGroup limitingGroup) throws LimitingCreateException {
        LimitingSupport limitingSupport = limitingContext.getLimitingSupport(key);
        if (limitingSupport == null) {
            LimitingGroupObject limitingGroupObject = LimitingGroupAdapter.getLimitingGroup(limitingGroup);
            limitingGroupObject.setGroup(key);
            limitingSupport = limitingContext.register(limitingGroupObject);
        }
        return limitingSupport;
    }

    private String getDefaultKey(Class<?> clazz, MethodSignature methodSignature) {
        return clazz.getName() + "#" + methodSignature.getName();
    }


}
