package wx.holder;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/15 16:07
 * @Description:
 **/
class AccessTokenHolderTest {

    @org.junit.jupiter.api.Test
    void refreshToken() throws InterruptedException {
        AccessTokenHolder accessTokenHolder = new AccessTokenHolder();
        Runnable runnable = accessTokenHolder::refreshToken;

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();



    }
}