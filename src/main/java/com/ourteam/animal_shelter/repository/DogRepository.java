package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.entity.animal.Dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    @Modifying
    @Query(value = "UPDATE Dog SET name = :name, age = :age, isHealthy = :isHealthy")
            Integer updateById(@Param("id") Integer id,
            @Param("name") String name,
            @Param("age") Integer age,
            @Param("isHealthy") Boolean isHealthy);
    @Query(value = "SELECT d FROM Dog d WHERE d.isHealthy = :isHealthy")
    List<Dog> findAllByHealth(@Param("isHealthy") Boolean isHealthy);
}