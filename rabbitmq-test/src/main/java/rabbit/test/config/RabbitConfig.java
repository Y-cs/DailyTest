package rabbit.test.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 9:55
 * @Description:
 **/
@Configuration
public class RabbitConfig {

    public final static String QUEUE = "test-queue";
    public final static String EXCHANGE = "test-exchange";

    public final static String DELAY_QUEUE = QUEUE + "_DELAY";
    public final static String DELAY_EXCHANGE = EXCHANGE + "_DELAY";

    @Bean(DELAY_QUEUE)
    public Queue getDelayQueue() {
        return QueueBuilder.nonDurable(DELAY_QUEUE)
                .deadLetterExchange(EXCHANGE)
                .deadLetterRoutingKey(EXCHANGE).build();
    }

    @Bean(DELAY_EXCHANGE)
    public Exchange getDelayExchange() {
        return ExchangeBuilder.directExchange(DELAY_EXCHANGE).build();
    }

    @Bean
    public Binding getDelayBinding(@Qualifier(DELAY_QUEUE) Queue queue, @Qualifier(DELAY_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_EXCHANGE).noargs();
    }

    @Bean(QUEUE)
    public Queue getQueue() {
        return QueueBuilder.nonDurable(QUEUE)
//                .deadLetterExchange(DELAY_EXCHANGE)
//                .deadLetterRoutingKey(DELAY_EXCHANGE)
                .build();
    }

    @Bean(EXCHANGE)
    public Exchange getExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE).build();
    }

    @Bean
    public Binding getBinding(@Qualifier(QUEUE) Queue queue, @Qualifier(EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(EXCHANGE).noargs();
    }

}
