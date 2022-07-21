package rabbit.test;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import rabbit.test.simple.QueueInfo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yuanchangshuai
 * @date 2022/6/30-14:36
 * @description
 */
public class ConnectionSupport {

    private final ConnectionFactory connectionFactory;

    private final Connection connection;

    @SneakyThrows
    public ConnectionSupport() {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.102.117.127");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connection = connectionFactory.newConnection();
    }

    public Connection getConnection() {
        try {
            return connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Channel getChannel() {
        return connection.openChannel().orElseThrow(Exception::new);
    }

    protected boolean checkQueueExist(Channel channel, String queueName) {
        try {
            AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(queueName);
            if (declareOk.getQueue().equals(queueName)) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

}
