package singleton;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:11
 * @Description:
 **/
public enum EnumMode {

    /**
     * 这是个单例对象
     */
    INSTANCE {
        public void doSomething() {
            System.out.println("是不是单例!!");
        }
    };


    /**
     * 添加一个个体Instance()方法使得模式更灵活
     * 可以修改返回的是那个实例
     *
     * @return
     */
    public static EnumMode getInstance() {
        return INSTANCE;
    }

}
