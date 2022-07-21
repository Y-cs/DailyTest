package wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/15 17:28
 * @Description:
 **/
@ConfigurationPropertiesScan("wx.config")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
