package com.ourteam.animal_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ourteam.animal_shelter.model.Shelter;


@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
