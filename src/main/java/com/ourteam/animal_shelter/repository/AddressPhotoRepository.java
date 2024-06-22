package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.AddressPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressPhotoRepository extends JpaRepository<AddressPhoto, Long> {
}
