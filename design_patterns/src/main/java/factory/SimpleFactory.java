package factory;

import factory.domain.Animal;
import factory.domain.Cat;
import factory.domain.Dog;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:20
 * @Description: 简单静态工厂
 **/
public class SimpleFactory {

    public static Animal create(String animal) {
        switch (animal) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            default:
                throw new RuntimeException("干不了!");
        }
    }


}
