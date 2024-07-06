package com.ourteam.animal_shelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
/**
 * Сущность - питомник для собак
 * {@code MEET} - приветствие пользователя; <br>
 * {@code INFO_SHELTER} - информация о приюте; <br>
 * {@code SHEDULE} - расписание работы приюта; <br>
 * {@code GUARD_CONTACTS} - как связаться с охраной и их контактные данные; <br>
 * {@code RULES} - список рекомендаций по транспортировке животного, список рекомендаций по обустройству дома
 * для щенка, список рекомендаций по обустройству дома для взрослого животного, список рекомендаций по
 * обустройству дома для животного с ограниченными возможностями (зрение, передвижение); <br>
 * Содержит стандартные методы геттеры и сеттеры. Конструктор по умолнчанию.
 */

@Entity
@Data
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String MEET;
    private String INFO_SHELTER;
    private String SHEDULE;
    private String GUARD_CONTACTS;
    private String RULES;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMEET() {
        return MEET;
    }

    public void setMEET(String MEET) {
        this.MEET = MEET;
    }

    public String getINFO_SHELTER() {
        return INFO_SHELTER;
    }

    public void setINFO_SHELTER(String INFO_SHELTER) {
        this.INFO_SHELTER = INFO_SHELTER;
    }

    public String getSHEDULE() {
        return SHEDULE;
    }

    public void setSHEDULE(String SHEDULE) {
        this.SHEDULE = SHEDULE;
    }

    public String getGUARD_CONTACTS() {
        return GUARD_CONTACTS;
    }

    public void setGUARD_CONTACTS(String GUARD_CONTACTS) {
        this.GUARD_CONTACTS = GUARD_CONTACTS;
    }

    public String getRULES() {
        return RULES;
    }

    public void setRULES(String RULES) {
        this.RULES = RULES;
    }

    public Shelter(Long id, String MEET, String INFO_SHELTER, String SHEDULE, String GUARD_CONTACTS, String RULES) {
        this.id = id;
        this.MEET = MEET;
        this.INFO_SHELTER = INFO_SHELTER;
        this.SHEDULE = SHEDULE;
        this.GUARD_CONTACTS = GUARD_CONTACTS;
        this.RULES = RULES;

    }
}
