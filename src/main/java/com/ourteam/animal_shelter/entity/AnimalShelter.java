package com.ourteam.animal_shelter.entity;

import com.ourteam.animal_shelter.exception.ValidationException;
import com.ourteam.animal_shelter.service.Validation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AnimalShelter extends NamedEntity{
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "WORK_SCHEDULE")
    private String workSchedule;
    @Column(name = "CONTACTS")
    private String contacts;

    public AnimalShelter() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!Validation.validateBaseStr(address)) {
            throw new ValidationException(address);
        }
        this.address = address;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        if (!Validation.validateBaseStr(workSchedule)) {
            throw new ValidationException(workSchedule);
        }
        this.workSchedule = workSchedule;
    }
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        if (!Validation.findValidatePhone(contacts)) {
            throw new ValidationException("Не обнаружен номер телефона в контактах");
        }
        this.contacts = contacts;
    }
}
