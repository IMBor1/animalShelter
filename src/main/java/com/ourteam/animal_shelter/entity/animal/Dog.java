package com.ourteam.animal_shelter.entity.animal;
public class Dog extends Animal {
    public Dog(String name, Integer age, Boolean isHealthy) {
        setName(name);

        setAge(age);

        setHealthy(isHealthy);
    }
}