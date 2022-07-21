package timer.spring.factory;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import timer.main.context.LimitingContext;
import timer.spring.ano.LimitingScanner;
import timer.spring.register.LimitingClassScanner;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/22 14:11
 * @Description:
 **/
public class LimitingGroupInitializer implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //读取扫描BasePackage
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(LimitingScanner.class.getName()));
        String[] basePackage = null;
        if (annoAttrs != null) {
            basePackage = annoAttrs.getStringArray("value");
        }
        if (basePackage == null || basePackage.length == 0) {
            basePackage = new String[]{importingClassMetadata.getClassName()};
        }
        //扫描器
        LimitingClassScanner limitingClassScanner = new LimitingClassScanner(registry);
        limitingClassScanner.scan(basePackage);
        //LimitingContext-bean定义
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(LimitingContext.class);
        builder.addConstructorArgValue(limitingClassScanner.getLimitingGroups());
        builder.addAutowiredProperty("redisson");
        builder.setInitMethodName("init");
        //添加bean定义
        registry.registerBeanDefinition(LimitingContext.class.getName(), builder.getBeanDefinition());
    }

}
