package monitor.base;

import monitor.base.Event;
import monitor.base.EventHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/22 11:05
 * @Description:
 **/
public class EventSource<T extends Event> {

    private final List<EventHandle<T>> listens;

    public EventSource() {
        listens = new ArrayList<>(8);
    }

    public void addListener(EventHandle<T> eventHandle) {
        this.listens.add(eventHandle);
    }

    public void delListener(EventHandle<T> eventHandle) {
        listens.remove(eventHandle);
    }

    public void doHandle(T event) {
        for (EventHandle<T> listen : listens) {
            listen.handle(event);
        }
    }

}
