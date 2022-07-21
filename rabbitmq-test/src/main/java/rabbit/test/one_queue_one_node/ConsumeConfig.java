package rabbit.test.one_queue_one_node;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanchangshuai
 * @date 2022/7/20-17:40
 * @description
 */
@Configuration
public class ConsumeConfig {

    @Bean("SimpleRabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory getBatchRabbitContainerFactory(ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setBatchListener(true);
        simpleRabbitListenerContainerFactory.setBatchSize(5000);
        simpleRabbitListenerContainerFactory.setConsumerBatchEnabled(true);
        simpleRabbitListenerContainerFactory.setReceiveTimeout(10 * 1000L);

        return simpleRabbitListenerContainerFactory;
    }


}
