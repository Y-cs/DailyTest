package m1117;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/8 14:03
 * @Description:
 **/
public class H2O {
    public H2O() {

    }

    final Object lock = new Object();
    private volatile int state = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized (lock) {
            while (state == 2) {
                lock.wait();
            }
            state++;
            releaseHydrogen.run();
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        synchronized (lock) {
            while (state != 2) {
                lock.wait();
            }
            state = 0;
            releaseOxygen.run();
            lock.notifyAll();
        }
    }
}
