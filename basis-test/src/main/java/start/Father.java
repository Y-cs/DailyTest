package start;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/16 10:58
 * @Description:
 **/
public abstract class Father extends Base{

    public Father(){
        System.out.println("father");
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("father end");
    }

}
