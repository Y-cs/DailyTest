package rabbit.test.simple;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanchangshuai
 * @date 2022/6/30-14:29
 * @description
 */
public class SimpleApplication {


    @SneakyThrows
    public static void main(String[] args) {
        CreateSimpleQueue createSimpleQueue = new CreateSimpleQueue();
        createSimpleQueue.createQueue();
        createSimpleQueue.monitorQueue();

        Pusher pusher = new Pusher(createSimpleQueue);

        new CountDownLatch(1).await();
    }


}
