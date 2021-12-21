package timer.spring.factory;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import timer.main.context.LimitingContext;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/21 10:49
 * @Description:
 **/
@Configuration
public class SpringFactory {

    @Bean
    public RedissonClient getRedisson(Environment environment) {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + environment.getProperty("spring.redis.host")
                + ":" + environment.getProperty("spring.redis.port"));
        singleServerConfig.setPassword(environment.getProperty("spring.redis.password"));
        singleServerConfig.setDatabase(4);
        return Redisson.create(config);
    }

    @Bean
    @ConditionalOnClass(RedissonClient.class)
    public LimitingContext getLimitingContext(RedissonClient redisson) {
        LimitingContext limitingContext = new LimitingContext();
        limitingContext.setRedisson(redisson);
        return limitingContext;
    }

}
