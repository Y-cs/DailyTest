package m1116;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.IntConsumer;

/**
 * @author yuanchangshuai
 * @date 2022/7/14-15:06
 * @description
 */
public class ZeroEvenOdd {
    private int n;
    private volatile boolean START=true;
    public Queue<Integer> evenQueue=new ConcurrentLinkedDeque<>();
    public Queue<Integer> oddQueue=new LinkedBlockingQueue<>(10);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (START){
            printNumber.accept(evenQueue.peek());
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (START){

        }
    }

}
