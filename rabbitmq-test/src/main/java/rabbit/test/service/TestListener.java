package rabbit.test.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rabbit.test.model.ModelB;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 10:02
 * @Description:
 **/
@Component
@RabbitListener(queues = "${application.queue}")
public class TestListener extends SimpleDirectRabbitQueue {

    public TestListener(RabbitTemplate rabbitTemplate, @Value("${application.queue}") String queue) throws IOException {
        super(rabbitTemplate, queue);
    }

    @Override
    protected void handle(Message message, Channel channel) throws Exception {
//        String s = new String(message.getBody(), StandardCharsets.UTF_8);
//        int delayCount = message.getMessageProperties().getHeader("DELAY_COUNT");
//        System.out.println(delayCount + "-----" + s + "----" + LocalTime.now());
//        throw new RuntimeException("这是一个错误");
        byte[] body = message.getBody();
        ByteArrayInputStream bais = new ByteArrayInputStream(body);
        ObjectInputStream ois = new ObjectInputStream(bais);
        ModelB o = (ModelB) ois.readObject();
        System.out.println(o.getBf());
    }

}
