package m1116;

import java.util.function.IntConsumer;

/**
 * @author yuanchangshuai
 * @date 2022/7/14-15:15
 * @description
 */
public class Test {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(9);
        new Thread(() -> {
            try {
                for (; ; )
                    zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                for (; ; )
                    zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                for (; ; )
                    zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
