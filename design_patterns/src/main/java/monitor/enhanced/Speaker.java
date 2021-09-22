package monitor.enhanced;

import monitor.base.Event;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/22 13:29
 * @Description:
 **/
public class Speaker {

    private Speaker() {
    }

    public static void speak(Event event) {
        EventSourceManager.speak(event);
    }

}
