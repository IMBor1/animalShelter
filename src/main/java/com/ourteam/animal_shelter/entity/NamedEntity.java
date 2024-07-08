package com.ourteam.animal_shelter.entity;

import com.ourteam.animal_shelter.exception.ValidationException;
import com.ourteam.animal_shelter.service.Validation;
import jakarta.persistence.Column;

public class NamedEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validation.validateBaseStr(name)) {
            throw new ValidationException(name);
        }
        this.name = name;
    }
}