package rabbit.test.simple;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import rabbit.test.ConnectionSupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author yuanchangshuai
 * @date 2022/6/30-14:33
 * @description
 */
@Component
public class CreateSimpleQueue extends ConnectionSupport {


    @SneakyThrows
    public void createQueue() {
        Channel channel = getChannel();
        if (!checkQueueExist(channel, QueueInfo.SIMPLE_QUEUE)) {
            try (Channel createChannel = getChannel()) {
                AMQP.Queue.DeclareOk declareOk = createChannel.queueDeclare(QueueInfo.SIMPLE_QUEUE, true, true, false, new HashMap<>());
                if (declareOk.getQueue().equals(QueueInfo.SIMPLE_QUEUE)) {
                    System.out.println("队列创建成功");
                }
            }
        } else {
            channel.close();
        }
    }


    @SneakyThrows
    public void monitorQueue() {
        Channel channel = getChannel();
        channel.basicConsume(QueueInfo.SIMPLE_QUEUE, (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        }, (consumerTag, sig) -> {
            System.out.println("链接已断开");
        });
    }

}
