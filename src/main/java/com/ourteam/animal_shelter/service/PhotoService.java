package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.model.Photo;
import com.ourteam.animal_shelter.repository.DogRepository;
import com.ourteam.animal_shelter.repository.PhotoRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendPhoto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Сервис для работы с фотографиями собак
 */
@Service
@Transactional
public class PhotoService {
    @Value("${path.to.dog-photo.folder}")
    private String photoDir;

    private final PhotoRepository photoRepository;

    private final DogRepository dogRepository;

    private final TelegramBot telegramBot;

    public PhotoService(PhotoRepository photoRepository, DogRepository dogRepository, TelegramBot telegramBot) {
        this.photoRepository = photoRepository;
        this.dogRepository = dogRepository;
        this.telegramBot = telegramBot;
    }

    /**
     * Метод реализует загрузку фотографий собак.
     * @param dogId айди собаки
     * @param file файл фотографии
     * @throws IOException
     */
    public void uploadPhoto(Long dogId, MultipartFile file) throws IOException {
        Dog dog = dogRepository.getReferenceById(dogId);
        Path filePath = Path.of(photoDir, dogId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = file.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024)
        ) {
            bis.transferTo(bos);
        }
        Photo photo = findDogPhoto(dogId);
        photo.setDog(dog);
        photo.setPath(filePath.toString());
        photo.setFileSize(file.getSize());
        photo.setMediaType(file.getContentType());
        photo.setData(file.getBytes());
        dog.setPhoto(photo);
        photoRepository.save(photo);
    }

    /**
     * Берет расширение от имени файла
     * @param fileName - имя файла
     * @return - возращаяет расширение файла в формате строки
     */
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Поиск фотографии по айди собаки
     * @param dogId айди собаки
     * @return фотография собаки, объект класса {@link Photo}
     */
    public Photo findDogPhoto(Long dogId) {
        return photoRepository.findByDogId(dogId).orElse(new Photo());
    }

    /**
     * Выводит все фотографии собак, которые есть в базе
     * @param pageNumber номер страницы
     * @param pageSize количество фотографий на странице
     * @return заданное количество фотграфий
     */
    public List<Photo> findAllDogsPhoto(Integer pageNumber, Integer pageSize) {
        return photoRepository
                .findAll(PageRequest.of(pageNumber - 1, pageSize))
                .getContent();
    }

    /**
     * Создает объект класса {@link SendPhoto} для отправки фотографии в чат
     * @param chatId айди чата
     * @param photo фото собаки, объект класса {@link Photo}
     * @return объект класса {@link SendPhoto}
     */
    public SendPhoto createSendPhoto(Long chatId, Photo photo) {
        byte[] filePhoto = photo.getData();
        return new SendPhoto(chatId, filePhoto);
    }

    /**
     * Отправляет фотографию собаки в чат в ответ на команду /g из callbackQuery.data
     * @param update объект класса {@link Update}
     */
    public void sendDogPhoto(Update update) {
        String callback = update.callbackQuery().data();
        if (callback.startsWith("/g")) {
            Long idDog = Long.parseLong(callback.replace("/g", ""));
            telegramBot.execute(createSendPhoto(
                    update.callbackQuery().message().chat().id(),
                    photoRepository.findByDogId(idDog).get()));
        }
    }
}
