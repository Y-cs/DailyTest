package monitor.base;

import monitor.base.Event;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/22 11:04
 * @Description:
 **/
@FunctionalInterface
public interface EventHandle<T extends Event> {

    /**
     * 处理
     * @param event
     */
    void handle(T event);

}
