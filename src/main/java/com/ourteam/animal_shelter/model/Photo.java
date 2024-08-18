package com.ourteam.animal_shelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
/**
 * Сущность - фотографии собак
 * {@code fileSize} - размер файла; <br>
 * {@code mediaType} - тип файла; <br>
 * {@code path} - содержит путь к файлу фото; <br>
 * Содержит стандартные методы геттеры и сеттеры. Конструктор по умолнчанию.
 */

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fileSize;
    private String mediaType;
    private String path;
    @Lob
    @JsonIgnore
    private byte[] data;
    @OneToOne
    private Dog dog;

    public Photo(Long id, Long fileSize, String mediaType, String path) {
        this.id = id;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.path = path;
    }

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
