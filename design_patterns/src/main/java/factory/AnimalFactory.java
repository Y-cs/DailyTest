package factory;

import factory.domain.Animal;
import factory.domain.Cat;
import factory.domain.Dog;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/18 17:29
 * @Description:
 **/
public interface AnimalFactory {
    /**
     * 获取动物的抽象方法
     * @return
     */
    Animal newAnimal();
}

class DogFactory implements AnimalFactory {

    @Override
    public Animal newAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {

    @Override
    public Animal newAnimal() {
        return new Cat();
    }
}

