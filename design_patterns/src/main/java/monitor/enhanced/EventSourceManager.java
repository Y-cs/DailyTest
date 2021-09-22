package monitor.enhanced;

import monitor.base.Event;

import java.util.*;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/22 11:25
 * @Description:
 **/
public final class EventSourceManager {
    private EventSourceManager() {
    }

    private static final Map<Class<? extends Event>, TargetedEventSource<? extends Event>> MAP = new HashMap<>();

    static <T extends Event> void addEventSource(Class<T> clazz, TargetedEventSource<? extends Event> targetedEventSource) {
        MAP.put(clazz, targetedEventSource);
    }

    static <T extends Event> void checkDelEventSource(Class<T> clazz, TargetedEventSource<? extends Event> targetedEventSource) {
        MAP.remove(clazz);
    }

    static <T extends Event> TargetedEventSource<T> getEventSource(Class<T> clazz) {
        TargetedEventSource<? extends Event> targetedEventSource = MAP.get(clazz);
        return (TargetedEventSource<T>) targetedEventSource;
    }

    static <T extends Event> void speak(T event) {
        TargetedEventSource<? extends Event> targetedEventSource = MAP.get(event.getClass());
        if (targetedEventSource != null) {
            ((TargetedEventSource<T>) targetedEventSource).doHandle(event);
        }
    }

}
