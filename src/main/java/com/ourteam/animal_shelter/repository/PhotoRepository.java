package com.ourteam.animal_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourteam.animal_shelter.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
