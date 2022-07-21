package rabbit.test.spring_batch.comsume;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-13:41
 * @description
 */
@Configuration
public class BatchRabbitTemplateConfig {


    @Bean("SimpleRabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        // configures a BatchMessageListenerAdapter
        factory.setBatchListener(true);
        factory.setBatchSize(20);
        factory.setReceiveTimeout(10*1000L);
        factory.setConsumerBatchEnabled(true);
        return factory;
    }


}
