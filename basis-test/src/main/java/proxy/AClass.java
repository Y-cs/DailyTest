package proxy;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/2/8 16:00
 * @Description:
 **/
public class AClass implements AInterface {
    @Override
    public String methodA() {
        System.out.println("aclass");
        return "aclass";
    }

    public void methodB(){
        System.out.println("bclass");
    }
}
