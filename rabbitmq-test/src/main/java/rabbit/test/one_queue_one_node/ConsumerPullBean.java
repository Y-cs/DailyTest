package rabbit.test.one_queue_one_node;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuanchangshuai
 * @date 2022/7/21-14:24
 * @description
 */
public class ConsumerPullBean {

    private final Channel channel;
    private final Connection connection;
    private RabbitTemplate template;

    private final String queue = "";


    public ConsumerPullBean(RabbitTemplate template) {
        this.template = template;
        connection = template.getConnectionFactory().createConnection();
        channel = connection.createChannel(false);

    }

    @SneakyThrows
    public void doOperation() {
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(queue);
        int consumerCount = declareOk.getConsumerCount();

        List<String> message = new ArrayList<>(consumerCount);
        long deliveryTag = 0;
        for (int i = 0; i < consumerCount; i++) {
            GetResponse getResponse = channel.basicGet(queue, false);
            byte[] body = getResponse.getBody();
            message.add(new String(body, StandardCharsets.UTF_8));
            deliveryTag = getResponse.getEnvelope().getDeliveryTag();
        }
        
        channel.basicAck(deliveryTag, true);
    }


}
