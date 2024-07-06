package com.ourteam.animal_shelter.entity.animal;

import com.ourteam.animal_shelter.entity.DogShelter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class Dog extends Animal {
    @ManyToOne(fetch = FetchType.LAZY)
    private DogShelter dogShelter;
    public Dog(String name, Integer age, Boolean isHealthy, Boolean isAdopted) {
        setName(name);

        setAge(age);

        setHealthy(isHealthy);

        setAdopted(isAdopted);
    }
}
