package rabbit.test.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbit.test.config.RabbitConfig;
import rabbit.test.model.ModelA;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.UUID;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 10:12
 * @Description:
 **/
@RestController
@RequestMapping("send")
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public String send(String str) throws IOException {
        ModelA modelA = new ModelA();
        modelA.setAf("12341234");
        modelA.setBf("zxcvzxcvz");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(modelA);
        rabbitTemplate.send("test-queue_EXCHANGE", "test-queue_EXCHANGE",
                new Message(baos.toByteArray(), new MessageProperties()));
        return "1";
    }


}
