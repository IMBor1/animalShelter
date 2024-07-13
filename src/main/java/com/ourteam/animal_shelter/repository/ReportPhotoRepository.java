package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.ReportPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportPhotoRepository extends JpaRepository<ReportPhoto, Long> {
    Optional<ReportPhoto> findReportPhotoByReportId(Long reportId);
}
