package timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import timer.spring.ano.LimitingScanner;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/16 18:29
 * @Description:
 **/
@SpringBootApplication
@LimitingScanner("timer")
public class SpringAopTimer {


    public static void main(String[] args) {
        SpringApplication.run(SpringAopTimer.class,args);
    }


}
