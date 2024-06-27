package com.ourteam.animal_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
/**
 * Сущность - питомник для собак
 * {@code greeting} - приветствие пользователя; <br>
 * {@code info} - информация о приюте; <br>
 * {@code datingRules} - правила знакомства с животным до того, как забрать его из приюта; <br>
 * {@code adoptionDocuments} - список документов, необходимых для того, чтобы взять животное из приюта; <br>
 * {@code transportationRecommendations} - список рекомендаций по транспортировке животного; <br>
 * {@code recommendationsArrangingBaby} - список рекомендаций по обустройству дома для щенка; <br>
 * {@code recommendationsArrangingAdult} - список рекомендаций по обустройству дома для взрослого животного; <br>
 * {@code recommendationsArrangingWithFeatures} - список рекомендаций по обустройству дома для животного
 * с ограниченными возможностями (зрение, передвижение); <br>
 * Содержит стандартные методы геттеры и сеттеры. Конструктор по умолнчанию.
 */

@Entity
@Data
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String greeting;
    private String info;
    private String datingRules;
    private String adoptionDocuments;
    private String transportationRecommendations;
    private String recommendationsArrangingBaby;
    private String recommendationsArrangingAdult;
    private String recommendationsArrangingWithFeatures;

    public Shelter(Long id, String greeting, String info, String datingRules, String adoptionDocuments,
                   String transportationRecommendations, String recommendationsArrangingBaby,
                   String recommendationsArrangingAdult, String recommendationsArrangingWithFeatures) {
        this.id = id;
        this.greeting = greeting;
        this.info = info;
        this.datingRules = datingRules;
        this.adoptionDocuments = adoptionDocuments;
        this.transportationRecommendations = transportationRecommendations;
        this.recommendationsArrangingBaby = recommendationsArrangingBaby;
        this.recommendationsArrangingAdult = recommendationsArrangingAdult;
        this.recommendationsArrangingWithFeatures = recommendationsArrangingWithFeatures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDatingRules() {
        return datingRules;
    }

    public void setDatingRules(String datingRules) {
        this.datingRules = datingRules;
    }

    public String getAdoptionDocuments() {
        return adoptionDocuments;
    }

    public void setAdoptionDocuments(String adoptionDocuments) {
        this.adoptionDocuments = adoptionDocuments;
    }

    public String getTransportationRecommendations() {
        return transportationRecommendations;
    }

    public void setTransportationRecommendations(String transportationRecommendations) {
        this.transportationRecommendations = transportationRecommendations;
    }

    public String getRecommendationsArrangingBaby() {
        return recommendationsArrangingBaby;
    }

    public void setRecommendationsArrangingBaby(String recommendationsArrangingBaby) {
        this.recommendationsArrangingBaby = recommendationsArrangingBaby;
    }

    public String getRecommendationsArrangingAdult() {
        return recommendationsArrangingAdult;
    }

    public void setRecommendationsArrangingAdult(String recommendationsArrangingAdult) {
        this.recommendationsArrangingAdult = recommendationsArrangingAdult;
    }

    public String getRecommendationsArrangingWithFeatures() {
        return recommendationsArrangingWithFeatures;
    }

    public void setRecommendationsArrangingWithFeatures(String recommendationsArrangingWithFeatures) {
        this.recommendationsArrangingWithFeatures = recommendationsArrangingWithFeatures;
    }
}
