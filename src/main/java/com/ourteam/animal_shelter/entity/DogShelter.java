package com.ourteam.animal_shelter.entity;

import com.ourteam.animal_shelter.entity.animal.Dog;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
@DiscriminatorValue("DSH")
public class DogShelter extends AnimalShelter {
    @OneToMany(mappedBy = "dogShelter")
    private List<Dog> dogs;

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
