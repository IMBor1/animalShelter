package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllById(Long id); // Поиск cобак по Id
    @Query(value = "Select * from dog WHERE is_adopted IS FALSE", nativeQuery = true)
    List<Dog> findAllIsAdopted();
}