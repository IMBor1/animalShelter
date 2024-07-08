package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.exception.UploadFileException;
import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.model.ReportPhoto;
import com.ourteam.animal_shelter.repository.ReportPhotoRepository;
import com.ourteam.animal_shelter.repository.ReportRepository;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
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
    @Value("${service.file-info.uri}")
    private String fileInfoUri;
    @Value("${service.file_storege.uri}")
    private String fileStorageUri;
    @Value("${telegram.bot.token}")
    private String token;
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
     * Создает из отчета фотографию с описанием для отправки в телеграм бот
     * @param chatId айди чата
     * @param report объект класса {@link Report}
     * @return - возвращает экземпляр класса {@link SendPhoto}
     */
    public SendPhoto sendReportPhoto(Long chatId, Report report) {
        String caption = report.getCaption();
        byte[] filePhoto = report.getAnimalPhoto().getData();
        SendPhoto sendPhoto = new SendPhoto(chatId, filePhoto);
        sendPhoto.caption(caption);
        return sendPhoto;
    }

    /**
     * Возвращает фотографию с адресом проезда и режимом работы приюта
     * @return - возвращает экземпляр класса {@link Report}
     */
    public Report getAddressPhoto() {
        return reportRepository.findById(3L).get();
    }

    /**
     * Возвращает пример формы ежедневного отчета о животном
     * @return - возвращает экземпляр класса {@link Report}
     */
    public Report getReportForm() {
        return reportRepository.findById(4L).get();
    }

    /**
     * Получает путь к файлу
     * @param fileId айди файла
     * @return строка пути к файлу
     */
    public ResponseEntity<String> getFilePath(String fileId) {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        var request = new HttpEntity<>(headers);


        return restTemplate.exchange(
                fileInfoUri,
                HttpMethod.GET,
                request,
                String.class,
                token, fileId
        );
    }

    /**
     * Возвращает массив байтов файла
     * @param filePath строка пути к файлу
     * @return массив байт
     */
    public byte[] downloadFile(String filePath) {
        var fullUri = fileStorageUri.replace("{token}", token)
                .replace("{filePath}", filePath);
        URL urlObj = null;
        try {
            urlObj = new URL(fullUri);
        } catch (MalformedURLException e) {
            throw new UploadFileException(e);
        }

        try (InputStream is = urlObj.openStream()) {
            return is.readAllBytes();
        } catch (IOException e) {
            throw new UploadFileException(urlObj.toExternalForm(), e);
        }
    }

    /**
     * Сохраняет ежедневный отчет с фото в БД
     * @param file массив байт файла
     * @param caption текст отчета
     */
    public void saveReport(byte[] file, String caption) {
        ReportPhoto reportPhoto = new ReportPhoto();
        reportPhoto.setData(file);
        reportPhotoRepository.save(reportPhoto);
        Report report = new Report();
        report.setCaption(caption);
        report.setAnimalPhoto(reportPhoto);
        reportRepository.save(report);
    }
}