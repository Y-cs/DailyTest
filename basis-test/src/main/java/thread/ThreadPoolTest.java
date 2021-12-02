package thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/10/11 14:48
 * @Description:
 **/
public class ThreadPoolTest {

    /**
     * 测试表明 线程池使用 threadlocal 不会被主动清理
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                String s = threadLocal.get();
                if (s != null) {
                    System.out.println(s);
                } else {
                    threadLocal.set(String.valueOf(finalI));
                    System.out.println(threadLocal.get());
                }
            });
        }

    }


}
