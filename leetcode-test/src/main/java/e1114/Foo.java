package e1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanchangshuai
 * @date 2022/7/14-14:28
 * @description
 */
public class Foo {

    private final  CountDownLatch DOWN_LATCH_1;
    private final  CountDownLatch DOWN_LATCH_2;

    public Foo() {
        DOWN_LATCH_1=new CountDownLatch(1);
        DOWN_LATCH_2=new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        DOWN_LATCH_1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        DOWN_LATCH_1.await();
        printSecond.run();
        DOWN_LATCH_2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        DOWN_LATCH_2.await();
        printThird.run();
    }

}
