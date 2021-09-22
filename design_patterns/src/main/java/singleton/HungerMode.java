package singleton;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 16:59
 * @Description:
 **/
public class HungerMode {

    private static final HungerMode INSTANCE = new HungerMode();

    private HungerMode() {
    }

    public static HungerMode getInstance() {
        return INSTANCE;
    }


}
