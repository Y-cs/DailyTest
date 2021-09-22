package monitor;

import monitor.base.Event;
import monitor.enhanced.Speaker;
import monitor.enhanced.TargetedEventSource;
import org.junit.jupiter.api.Test;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:47
 * @Description:
 **/
public class MonitorTest {

    static class PushEven implements Event {
        String msg;
    }

    @Test
    public void test1() {
        TargetedEventSource<PushEven> instance = TargetedEventSource.getInstance(PushEven.class);
        instance.addListener((event) -> {
            System.out.println(event.msg);
        });
        instance.addListener((event) -> {
            System.out.println(event.msg);
        });
    }

    @Test
    public void test2(){
        PushEven event = new PushEven();
        event.msg="aaaaa";
        Speaker.speak(event);
    }


}
