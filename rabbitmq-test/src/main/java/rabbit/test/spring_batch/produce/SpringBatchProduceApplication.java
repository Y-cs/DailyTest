package rabbit.test.spring_batch.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rabbit.test.spring_batch.comsume.SpringBatchConsumeApplication;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-13:24
 * @description
 */
@SpringBootApplication
public class SpringBatchProduceApplication {

    public static void main(String[] args) {
        args = new String[]{"--server.port=9092"};
        new SpringApplication(SpringBatchProduceApplication.class).run(args);
    }

}
