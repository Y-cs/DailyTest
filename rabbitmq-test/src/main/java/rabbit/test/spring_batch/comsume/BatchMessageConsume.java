package rabbit.test.spring_batch.comsume;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbit.test.spring_batch.QueueInfo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-13:47
 * @description
 */
@Component
public class BatchMessageConsume {

    public static Channel channel;

    @RabbitListener(queues = QueueInfo.QUEUE,
            ackMode = "MANUAL", containerFactory = "SimpleRabbitListenerContainerFactory")
    public void consume1(List<Message> list, Channel channel) throws IOException {
        System.out.println(LocalDateTime.now());
        for (Message message : list) {
            System.out.println("1|" + message.getMessageProperties().getDeliveryTag() + "|" + new String(message.getBody()));
        }
        //channel.basicAck(list.get(list.size() - 1).getMessageProperties().getDeliveryTag(), true);
        BatchMessageConsume.channel = channel;
    }

    //@RabbitListener(queues = QueueInfo.QUEUE,
    //        ackMode = "MANUAL", containerFactory = "SimpleRabbitListenerContainerFactory")
    //public void consume2(List<Message> list, Channel channel) throws IOException {
    //    for (Message message : list) {
    //        System.out.println("2|" + message.getMessageProperties().getDeliveryTag() + "|" + new String(message.getBody()));
    //    }
    //    channel.basicAck(list.get(list.size() - 1).getMessageProperties().getDeliveryTag(), true);
    //}
    //
    //@RabbitListener(queues = QueueInfo.QUEUE + ".2", containerFactory = "SimpleRabbitListenerContainerFactory")
    //public void consume2(List<Message> list) {
    //    System.out.println("------" + Thread.currentThread().getName());
    //    for (Message message : list) {
    //        System.out.println(Thread.currentThread().getName() + "|" + new String(message.getBody()));
    //    }
    //}
    //
    //@RabbitListener(queues = QueueInfo.QUEUE + ".3",ackMode = "AUTO")
    //public void consume3(Message list) {
    //    System.out.println("------" + Thread.currentThread().getName());
    //    System.out.println(Thread.currentThread().getName() + "|" + new String(list.getBody()));
    //}
}
