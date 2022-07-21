package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/2/8 16:01
 * @Description:
 **/
public class Testmain {

    public static void main(String[] args) {
        AClass proxy = getProxy();
        proxy.methodA();
        proxy.methodB();
    }

    public static AClass getProxy() {
//        return (AInterface) Proxy.newProxyInstance(AClass.class.getClassLoader(), new Class[]{AInterface.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("proxy");
//                return "";
//            }
//        });

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AClass.class);
        enhancer.setCallback((InvocationHandler) (o, method, objects) -> {
            System.out.println("aaa");
            return null;
        });
        enhancer.setInterceptDuringConstruction(false);
        Object o = enhancer.create();

        return (AClass) o;

    }

}
