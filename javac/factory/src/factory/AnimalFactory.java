package factory;

import animal.Animal;
import animal.Cat;
import animal.Dog;

public class AnimalFactory {
    public static Animal create(String name) {
        if(name.equals("개")) {
            return new Dog();
        } else if (name.equals("고양이")) {
            return new Cat();
        } else {
            return null;
        }
    }
}
