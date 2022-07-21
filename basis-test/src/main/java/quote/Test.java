package quote;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/2/16 14:34
 * @Description:
 **/
public class Test {

    public static class Holder{
        private final Object aa;

        public Holder(Object aa) {
            this.aa = aa;
        }
    }

    private static Object aobje=new Object();

    public static void main(String[] args) {
        Holder holder = new Holder(aobje);
        aobje=new Object();
        System.out.println("111");
    }

}
