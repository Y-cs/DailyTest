package rabbit.test.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 16:17
 * @Description: 简单的直连重试队列  一切为了简单
 **/
@Slf4j
public abstract class SimpleDirectRabbitQueue {
    private final static String DELAY_MARKING = "_DELAY";
    private final static String EXCHANGE_MARKING = "_EXCHANGE";
    private final static String DELAY_COUNT = "DELAY_COUNT";

    private final String queue;
    private final String exchange;
    private final String delayQueue;
    private final String delayExchange;

    private final RabbitTemplate rabbitTemplate;

    public SimpleDirectRabbitQueue(RabbitTemplate rabbitTemplate, String queue) throws IOException {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.exchange = this.queue + EXCHANGE_MARKING;
        this.delayQueue = this.queue + DELAY_MARKING;
        this.delayExchange = this.exchange + DELAY_MARKING;
        init();
    }

    private void init() throws IOException {
        ConnectionFactory connectionFactory = rabbitTemplate.getConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        Channel channel = connection.createChannel(false);
        log.info("get rabbit connection");
        //消费队列
        log.info("create consumption queue of {}", queue);
        channel.queueDeclare(queue, true, false, false, null);
        channel.exchangeDeclare(exchange, "direct", true);
        channel.queueBind(queue, exchange, exchange);
        //重试队列
        log.info("create delay queue of {}", queue);
        HashMap<String, Object> args = new HashMap<>(2);
        args.put("x-dead-letter-exchange", exchange);
        args.put("x-dead-letter-routing-key", exchange);
        channel.queueDeclare(delayQueue, true, false, false, args);
        channel.exchangeDeclare(delayExchange, "direct", true);
        channel.queueBind(delayQueue, delayExchange, delayExchange);
    }

    /**
     * 实际业务
     *
     * @param message
     * @param channel
     */
    protected abstract void handle(Message message, Channel channel) throws Exception;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @RabbitHandler(isDefault = true)
    public void rabbitListenerHandle(Message message, Channel channel) {
        try {
            handle(message, channel);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            int delayCount = (int) Optional.ofNullable(message.getMessageProperties().getHeader(DELAY_COUNT)).orElse(1);
            RabbitDelayEnum level = RabbitDelayEnum.getLevel(delayCount);
            try {
                //先确认掉
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (level == null) {
                //丢弃
                discard(message);
            } else {
                //重试
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setExpiration(level.getTime());
                messageProperties.setHeader(DELAY_COUNT, ++delayCount);
                rabbitTemplate.send(delayExchange, delayExchange, message);
            }
        }

    }

    /**
     * 丢弃策略
     *
     * @param message
     */
    protected void discard(Message message) {
        log.info("丢弃数据->:{}", message);
    }
}
