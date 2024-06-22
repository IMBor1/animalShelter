package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.entity.animal.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
}
