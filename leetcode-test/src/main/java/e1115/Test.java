package e1115;

/**
 * @author yuanchangshuai
 * @date 2022/7/14-14:50
 * @description
 */
public class Test {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        new Thread(()->{
            try {
                fooBar.foo(()->{
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                fooBar.bar(()->{
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
