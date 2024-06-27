package com.ourteam.animal_shelter.model;

import lombok.Data;
import jakarta.persistence.*;
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

    public Photo(Long id, Long fileSize, String mediaType, String path) {
        this.id = id;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.path = path;
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


}
