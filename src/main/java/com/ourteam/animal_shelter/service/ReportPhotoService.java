package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.model.ReportPhoto;
import com.ourteam.animal_shelter.repository.ReportPhotoRepository;
import com.ourteam.animal_shelter.repository.ReportRepository;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Сервис для работы с фотографиями к ежедневному отчету
 *
 *
 */
@Service
public class ReportPhotoService {
    @Value("${path.to.report-photo.folder}")
    private String reportPhotoDir;

    private final ReportPhotoRepository reportPhotoRepository;
    private final ReportRepository reportRepository;

    public ReportPhotoService(ReportPhotoRepository reportPhotoRepository,
                              ReportRepository reportRepository) {
        this.reportPhotoRepository = reportPhotoRepository;
        this.reportRepository = reportRepository;
    }

    /**
     * Метод для загрузки фото в базу данных и на жесткий диск
     * @param reportId - айди ежедневного отчета
     * @param file - файл фотографии
     * @throws IOException - выбрасывается исключение если файл некорректный или отсутвует
     */
    public void uploadReportPhoto(Long reportId, MultipartFile file) throws IOException {
        Report report = reportRepository.getReferenceById(reportId);
        Path filePath = Path.of(reportPhotoDir, reportId + "." + getExtension(file.getOriginalFilename()));
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
        ReportPhoto reportPhoto = new ReportPhoto();
        reportPhoto.setReport(report);
        reportPhoto.setFilePath(filePath.toString());
        reportPhoto.setFileSize(file.getSize());
        reportPhoto.setMediaType(file.getContentType());
        reportPhoto.setData(file.getBytes());
        report.setAnimalPhoto(reportPhoto);
        reportPhotoRepository.save(reportPhoto);
    }

    /**
     * Берет расширение от имени файла
     * @param fileName - имя файла
     * @return - возращаяет расширение файла в формате строки
     */
    public String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Создает фотографию с описанием для отправки в телеграм бот
     * @param chatId - айди чата
     * @param filePhoto - массив байтов фотографии
     * @param caption - описание в текстовом формате
     * @return - возвращает экземпляр класса {@link SendPhoto}
     */
    public SendPhoto sendReportPhoto(Long chatId, byte[] filePhoto, String caption) {
        SendPhoto sendPhoto = new SendPhoto(chatId, filePhoto);
        sendPhoto.caption(caption);
        return sendPhoto;
    }

    /**
     * Возвращает фотографию с адресом проезда и режимом работы приюта
     * @return - возвращает экземпляр класса {@link Report}
     */
    public Report getAddressPhoto() {
        return reportRepository.findById(1L).get();
    }

    /**
     * Возвращает пример формы ежедневного отчета о животном
     * @return - возвращает экземпляр класса {@link Report}
     */
    public Report getReportForm() {
        return reportRepository.findById(2L).get();
    }


}
