package monitor.enhanced;

import monitor.base.Event;
import monitor.base.EventSource;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/22 13:10
 * @Description:
 **/
public class TargetedEventSource<T extends Event> extends EventSource<T> {

    private final Class<T> eventClazz;

    private TargetedEventSource(Class<T> eventClazz) {
        super();
        this.eventClazz = eventClazz;
        EventSourceManager.addEventSource(eventClazz, this);
    }

    public static synchronized <F extends Event>  TargetedEventSource<F> getInstance(Class<F> eventClazz) {
        TargetedEventSource<F> eventSource = EventSourceManager.getEventSource(eventClazz);
        return eventSource == null ? new TargetedEventSource<F>(eventClazz) : eventSource;
    }

    @Override
    public void doHandle(T event) {
        if (!eventClazz.equals(event.getClass())) {
            throw new RuntimeException("事件类型不匹配");
        }
        super.doHandle(event);
    }

    public void del() {
        //通知管理集检查删除自己
        EventSourceManager.checkDelEventSource(this.eventClazz, this);
    }
}
