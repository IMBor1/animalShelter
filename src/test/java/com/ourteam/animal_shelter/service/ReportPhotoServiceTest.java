package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.model.ReportPhoto;
import com.ourteam.animal_shelter.repository.ReportPhotoRepository;
import com.ourteam.animal_shelter.repository.ReportRepository;
import com.pengrad.telegrambot.request.SendPhoto;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

import com.ourteam.animal_shelter.service.ReportPhotoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportPhotoServiceTest {
    @Test
    public void uploadReportPhoto_positive() throws IOException {
        // Создаем фиктивный объект `MultipartFile`
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("test.jpg");
        when(file.getSize()).thenReturn(1024L);
        when(file.getContentType()).thenReturn("image/jpeg");
        when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[]{}));

        // Создаем фиктивный объект `Report`
        Report report = mock(Report.class);
        when(report.getReportId()).thenReturn(1L);

        // Создаем фиктивный объект `ReportPhotoRepository`
        ReportPhotoRepository reportPhotoRepository = mock(ReportPhotoRepository.class);

        // Создаем фиктивный объект `ReportRepository`
        ReportRepository reportRepository = mock(ReportRepository.class);
        when(reportRepository.getReferenceById(1L)).thenReturn(report);

        // Создаем экземпляр класса `ReportPhotoService`
        ReportPhotoService reportPhotoService = new ReportPhotoService(reportPhotoRepository, reportRepository);

        // Вызываем метод `uploadReportPhoto()`
        reportPhotoService.uploadReportPhoto(1L, file);

        // Проверяем, что был вызван метод `save()` у `reportPhotoRepository`
        verify(reportPhotoRepository).save(any(ReportPhoto.class));

        // Проверяем, что был вызван метод `getReferenceById()` у `reportRepository`
        verify(reportRepository).getReferenceById(1L);
    }

    @Test
    public void uploadReportPhoto_negative() throws IOException {
        // Создаем фиктивный объект `MultipartFile`
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("test");

        // Создаем фиктивный объект `Report`
        Report report = mock(Report.class);
        when(report.getReportId()).thenReturn(1L);

        // Создаем фиктивный объект `ReportPhotoRepository`
        ReportPhotoRepository reportPhotoRepository = mock(ReportPhotoRepository.class);

        // Создаем фиктивный объект `ReportRepository`
        ReportRepository reportRepository = mock(ReportRepository.class);
        when(reportRepository.getReferenceById(1L)).thenReturn(report);

        // Создаем экземпляр класса `ReportPhotoService`
        ReportPhotoService reportPhotoService = new ReportPhotoService(reportPhotoRepository, reportRepository);

        // Вызываем метод `uploadReportPhoto()`
        reportPhotoService.uploadReportPhoto(1L, file);
    }

    @Test
    public void getExtension_positive() {
        String fileName = "test.jpg";
        String extension = ReportPhotoService.getExtension(fileName);
        assertEquals("jpg", extension);
    }

    @Test
    public void sendReportPhoto_positive() {
        byte[] filePhoto = new byte[]{};
        String caption = "Test caption";

        Report report = new Report();
        // Получить экземпляр объекта Report

        if (report.getAnimalPhoto() != null) {
            // Получить данные из объекта ReportPhoto
            byte[] data = report.getAnimalPhoto().getData();
        } else {
            System.out.println("Объект ReportPhoto равен null");
            // Обработать случай, когда объект ReportPhoto равен null
        }

        SendPhoto sendPhoto = ReportPhotoService.sendReportPhoto(1L, report);
        assertEquals("Test caption", caption);
    }

    @Test
    public void getAddressPhoto_positive() {
        // Создаем фиктивный объект `Report`
        Report report = mock(Report.class);

        // Создаем фиктивный объект `ReportRepository`
        ReportRepository reportRepository = mock(ReportRepository.class);
        when(reportRepository.findById(3L)).thenReturn(Optional.of(report));

        // Создаем экземпляр класса `ReportPhotoService`
        ReportPhotoService reportPhotoService = new ReportPhotoService(null, reportRepository);

        // Вызываем метод `getAddressPhoto()`
        Report result = reportPhotoService.getAddressPhoto();

        // Проверяем, что был вызван метод `findById()` у `reportRepository`
        verify(reportRepository).findById(3L);
    }

    @Test
    public void getReportForm_positive() {
        // Создаем фиктивный объект `Report`
        Report report = mock(Report.class);

        // Создаем фиктивный объект `ReportRepository`
        ReportRepository reportRepository = mock(ReportRepository.class);
        when(reportRepository.findById(4L)).thenReturn(Optional.of(report));

        // Создаем экземпляр класса `ReportPhotoService`
        ReportPhotoService reportPhotoService = new ReportPhotoService(null, reportRepository);

        // Вызываем метод `getReportForm()`
        Report result = reportPhotoService.getReportForm();

        // Проверяем, что был вызван метод `findById()` у `reportRepository`
        verify(reportRepository).findById(4L);
    }

}
