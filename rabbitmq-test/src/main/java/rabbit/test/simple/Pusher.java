package rabbit.test.simple;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import rabbit.test.ConnectionSupport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanchangshuai
 * @date 2022/6/30-15:42
 * @description
 */
public class Pusher {


    @SneakyThrows
    public Pusher(ConnectionSupport connectionSupport) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(500));
        Channel channel = connectionSupport.getChannel();
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("ack:" + deliveryTag);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("nack:" + deliveryTag);
            }
        });

        channel.addReturnListener(returnMessage -> {
            System.out.println("return:"+new String(returnMessage.getBody()));
        });
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().messageId(String.valueOf(finalI)).build();
                    channel.basicPublish("", QueueInfo.SIMPLE_QUEUE, basicProperties, String.valueOf(finalI).getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }


    }

}
