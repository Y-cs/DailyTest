package rabbit.test.spring_batch.comsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-13:24
 * @description
 */
@SpringBootApplication
public class SpringBatchConsumeApplication {

    public static void main(String[] args) {
        args = new String[]{"--server.port=9091"};
        new SpringApplication(SpringBatchConsumeApplication.class).run(args);
    }

}
