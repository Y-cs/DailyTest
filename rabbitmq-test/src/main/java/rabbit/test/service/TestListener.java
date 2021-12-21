package rabbit.test.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 10:02
 * @Description:
 **/
@Component
public class TestListener {

    @RabbitHandler
    @RabbitListener(queues = "${application.queue}",ackMode = "AUTO")
    protected void handle1(Message message, Channel channel) throws Exception {
        System.out.println("回复消息"+message.getMessageProperties().getDeliveryTag());
    }

    @RabbitHandler
    @RabbitListener(queues = "${application.queue}",ackMode = "AUTO")
    protected void handle2(Message message, Channel channel) throws Exception {
        System.out.println("回复消息"+message.getMessageProperties().getDeliveryTag());
    }

    @RabbitHandler
    @RabbitListener(queues = "${application.queue}",ackMode = "AUTO")
    protected void handle3(Message message, Channel channel) throws Exception {
        System.out.println("回复消息"+message.getMessageProperties().getDeliveryTag());
    }

    @RabbitHandler
    @RabbitListener(queues = "${application.queue}",ackMode = "AUTO")
    protected void handle4(Message message, Channel channel) throws Exception {
        System.out.println("回复消息"+message.getMessageProperties().getDeliveryTag());
    }

    @RabbitHandler
    @RabbitListener(queues = "${application.queue}",ackMode = "AUTO")
    protected void handle5(Message message, Channel channel) throws Exception {
        System.out.println("回复消息"+message.getMessageProperties().getDeliveryTag());
    }

}
