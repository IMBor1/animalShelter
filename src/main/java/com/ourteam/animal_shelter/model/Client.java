package com.ourteam.animal_shelter.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс клиента, включает поля id,chat_Id,name,has_pet,phone
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "chat_Id")
    private long chatId;
    @Column(name = "name")
    private String name;
    @Column(name = "has_pet")
    private boolean hasPet;

    @Column(name = "phone")
    private String phone;
    @Column(name = "timer")
    private LocalDateTime timer;
    @Column(name = "probationary_period")
    private LocalDateTime probationaryPeriod;

    public Client() {

    }

    public Client(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;

    }

    public Client(long chatId, String name, boolean hasPet, LocalDateTime timer) {
        this.chatId = chatId;
        this.name = name;
        this.hasPet = hasPet;
        this.timer = timer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasPet() {
        return hasPet;
    }

    public void setHasPet(boolean hasPet) {
        this.hasPet = hasPet;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getTimer() {
        return timer;
    }

    public void setTimer(LocalDateTime timer) {
        this.timer = timer;
    }

    public LocalDateTime getProbationaryPeriod() {
        return probationaryPeriod;
    }

    public void setProbationaryPeriod(LocalDateTime probationaryPeriod) {
        this.probationaryPeriod = probationaryPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && chatId == client.chatId && hasPet == client.hasPet && probationaryPeriod == client.probationaryPeriod && Objects.equals(name, client.name) && Objects.equals(phone, client.phone) && Objects.equals(timer, client.timer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, name, hasPet, phone, timer, probationaryPeriod);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", name='" + name + '\'' +
                ", hasPet=" + hasPet +
                ", phone='" + phone + '\'' +
                ", timer=" + timer +
                ", probationaryPeriod=" + probationaryPeriod +
                '}';
    }
}
