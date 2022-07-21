package rabbit.test.spring_batch.comsume;

import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-15:05
 * @description
 */
@RestController
@RequiredArgsConstructor
public class ConsumeAckController {

    private final RabbitTemplate rabbitTemplate;

    @RequestMapping("/ackone")
    public void ackone(Long tag) throws IOException {
        //Channel channel = rabbitTemplate.getConnectionFactory().createConnection().createChannel(false);
        BatchMessageConsume.channel.basicAck(tag,false);
    }
    @RequestMapping("/ackmore")
    public void ackmore(Long tag) throws IOException {
        //Channel channel = rabbitTemplate.getConnectionFactory().createConnection().createChannel(false);
        BatchMessageConsume.channel.basicAck(tag,true);
    }


}
