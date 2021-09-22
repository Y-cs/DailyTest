package factory;

import factory.domain.Animal;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:32
 * @Description:
 **/
public class ReflectionFactory {

    public Animal create(Class<? extends Animal> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
