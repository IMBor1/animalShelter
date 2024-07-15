package com.ourteam.animal_shelter.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

/**
 * Сущность - собака
 * {@code name} - кличка животного; <br>
 * {@code age} - возраст животного; <br>
 * {@code isHealthy} - состояние здоровья животного; <br>
 * Содержит стандартные методы геттеры и сеттеры. Конструктор по умолнчанию и с параметрами.
 */


@Data
@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private boolean isHealthy;
    private boolean isAdopted;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    public Dog(long id, String name, int age, boolean isHealthy, boolean isAdopted, Client client) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isHealthy = isHealthy;
        this.isAdopted = isAdopted;
        this.client = client;
    }
    public Dog(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && age == dog.age && isHealthy == dog.isHealthy && isAdopted == dog.isAdopted && Objects.equals(name, dog.name) && Objects.equals(client, dog.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, isHealthy, isAdopted, client);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isHealthy=" + isHealthy +
                ", isAdopted=" + isAdopted +
                ", client=" + client +
                '}';
    }
}


