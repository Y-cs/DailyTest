package start;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/16 10:58
 * @Description:
 **/
public class Children extends Father{

    public Children(){
        System.out.println("children");
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("children end");
    }
}
