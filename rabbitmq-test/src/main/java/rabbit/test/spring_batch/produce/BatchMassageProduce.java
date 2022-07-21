package rabbit.test.spring_batch.produce;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbit.test.spring_batch.QueueInfo;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuanchangshuai
 * @date 2022/7/1-13:28
 * @description
 */
@RestController
@RequiredArgsConstructor
public class BatchMassageProduce {

    private final RabbitTemplate rabbit;

    @GetMapping("/pushMessage")
    public void produceMessage() {
        String message=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        System.out.println("push message :"+message);
        rabbit.send(QueueInfo.EXCHANGE, "", new Message(message.getBytes(StandardCharsets.UTF_8)));
    }

    @GetMapping("/pushMessageDefault")
    public void pushMessageDefault() {
        for (int i = 0; i < 100; i++) {
            System.out.println("push message :"+i);
            rabbit.send(QueueInfo.EXCHANGE, "", new Message(String.valueOf(i).getBytes(StandardCharsets.UTF_8)));
        }
    }
    @GetMapping("/pushMessageDefault1")
    public void produceMessage1() {
        for (int i = 0; i < 100; i++) {
            rabbit.send(QueueInfo.EXCHANGE+1, "", new Message(String.valueOf(i).getBytes(StandardCharsets.UTF_8)));
        }
    }

}
