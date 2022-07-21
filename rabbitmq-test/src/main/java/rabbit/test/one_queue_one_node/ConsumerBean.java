package rabbit.test.one_queue_one_node;

import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rabbit.test.spring_batch.QueueInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanchangshuai
 * @date 2022/7/21-10:30
 * @description
 */
@Component
public class ConsumerBean {

    private final static BlockingQueue<Integer> signal = new LinkedBlockingQueue<>();

    private volatile boolean isDoOperation = false;
    private final List<Message> batchMessages = new LinkedList<>();

    public ConsumerBean() {
        ForkJoinPool.commonPool().execute(() -> {
            try {
                while (true) {
                    Integer signalNum = signal.poll(30, TimeUnit.SECONDS);
                    if (signalNum == null) {
                        doOperation();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @RabbitListener(queues = QueueInfo.QUEUE,
            ackMode = "MANUAL", containerFactory = "SimpleRabbitListenerContainerFactory")
    public void consume(List<Message> messages, Channel channel) {

        batchMessages.addAll(messages);

        if (batchMessages.size() >= 5000) {
            doOperation();
        }
    }

    @SneakyThrows
    private void doOperation() {
        if (isDoOperation) {
            return;
        }
        isDoOperation = true;
        for (Message batchMessage : batchMessages) {
            //ig
        }
        isDoOperation = false;
        signal.put(1);
    }


}
