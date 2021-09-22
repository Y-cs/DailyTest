package singleton;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:05
 * @Description:
 **/
public class LazyMode {

    private LazyMode() {
    }

    private static volatile LazyMode instance = null;

    public static LazyMode getInstance() {
        if (instance == null) {
            synchronized (LazyMode.class) {
                if (instance == null) {
                    instance = new LazyMode();
                }
            }
        }
        return instance;
    }
}
