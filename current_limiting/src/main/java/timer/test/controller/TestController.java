package timer.test.controller;

import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import timer.main.ano.Limiting;
import timer.main.ano.LimitingGroup;
import timer.main.context.LimitingGroupObject;
import timer.main.enums.LimitingPartitionEnum;

import java.util.concurrent.TimeUnit;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/15 10:22
 * @Description:
 **/
@RestController
public class TestController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("/test")
    @Limiting(permits = 1, group = {@LimitingGroup(group = "limiting", permitsPerTime = 1L, time = 10, partitionEnum = LimitingPartitionEnum.IP)})
    public void tset() {
        System.out.println("1111111111111");
    }


    @GetMapping("/test2")
    @Limiting(permits = 1, groupName = "limiting")
    public void test2() {
        System.out.println("1111");
    }

    @Bean
    public LimitingGroupObject groupObject() {
        return new LimitingGroupObject();
    }

}
