package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.ReportPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportPhotoRepository extends JpaRepository<ReportPhoto, Long> {

}
