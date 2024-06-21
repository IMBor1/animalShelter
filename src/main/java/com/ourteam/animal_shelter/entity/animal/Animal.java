package com.ourteam.animal_shelter.entity.animal;

import com.ourteam.animal_shelter.entity.NamedEntity;
import jakarta.persistence.Entity;

@Entity
public class Animal extends NamedEntity {
    private Integer age;
    private Boolean isHealthy;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getHealthy() {
        return isHealthy;
    }

    public void setHealthy(Boolean healthy) {
        isHealthy = healthy;
    }
}
