package singleton;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:08
 * @Description:
 **/
public class InnerClass {

    private InnerClass() {
    }

    private static class InnerClassInstance {
        public static final InnerClass INSTANCE = new InnerClass();
    }

    public static InnerClass getInstance() {
        return InnerClassInstance.INSTANCE;
    }


}
