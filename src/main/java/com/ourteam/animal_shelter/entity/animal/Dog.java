package com.ourteam.animal_shelter.entity.animal;

import com.ourteam.animal_shelter.entity.DogShelter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class Dog extends Animal {
    @JoinColumn(name = "DOG_SHELTER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DogShelter dogShelter;
    public Dog(String name, Integer age, Boolean isHealthy) {
        setName(name);

        setAge(age);

        setHealthy(isHealthy);
    }
    public DogShelter getDogShelter() {
        return dogShelter;
    }

    public void setDogShelter(DogShelter dogShelter) {
        this.dogShelter = dogShelter;
    }
}