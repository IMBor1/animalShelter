package com.ourteam.animal_shelter.model;

import jakarta.persistence.*;

import java.util.Objects;

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
    @OneToOne
    private ReportPhoto animalPhoto;

    private String caption;

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public ReportPhoto getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(ReportPhoto animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return reportId == report.reportId && Objects.equals(animalPhoto, report.animalPhoto) && Objects.equals(caption, report.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, animalPhoto, caption);
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", animalPhoto=" + animalPhoto +
                ", caption='" + caption + '\'' +
                '}';
    }
}
