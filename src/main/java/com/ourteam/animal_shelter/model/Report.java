package com.ourteam.animal_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.File;

/**
 * Сущность - ежедневные отчеты о животном
 * {@code animalPhoto} - фотография животного; <br>
 * {@code ration} - рацион животного; <br>
 * {@code healthAndChanges} - состояние и изменение поведения животного; <br>
 * Содержит стандартные методы геттеры и сеттеры. Конструктор по умолнчанию.
 */
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;
    private File animalPhoto;
    private String ration;

    private String healthAndChanges;

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public File getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(File animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    public String getRation() {
        return ration;
    }

    public void setRation(String ration) {
        this.ration = ration;
    }

    public String getHealthAndChanges() {
        return healthAndChanges;
    }

    public void setHealthAndChanges(String healthAndChanges) {
        this.healthAndChanges = healthAndChanges;
    }
}
