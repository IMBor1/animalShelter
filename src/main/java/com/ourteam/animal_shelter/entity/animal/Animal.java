package com.ourteam.animal_shelter.entity.animal;

import com.ourteam.animal_shelter.entity.NamedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Animal extends NamedEntity {
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "IS_HEALTHY")
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


