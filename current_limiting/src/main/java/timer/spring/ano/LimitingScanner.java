package timer.spring.ano;

import org.springframework.context.annotation.Import;
import timer.spring.aop.LimitingAop;
import timer.spring.factory.LimitingBeanFactory;
import timer.spring.factory.LimitingGroupInitializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/22 10:54
 * @Description:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({LimitingGroupInitializer.class, LimitingBeanFactory.class, LimitingAop.class})
public @interface LimitingScanner {

    /**
     * 限流组所在的包路径
     * @return
     */
    String[] value() default {};

}
