/*package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.service.ReportPhotoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ReportPhotoController.class)
public class ReportPhotoControllerWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportPhotoService reportPhotoService;


    @Test
    public void saveReportPhoto_positive() throws Exception {
        // Создаем фиктивный объект `MultipartFile`
        MultipartFile multipartFile = mock(MultipartFile.class);

        // Преобразуем объект `MultipartFile` в объект `MockMultipartFile`
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",
                multipartFile.getOriginalFilename(),
                multipartFile.getContentType(),
                multipartFile.getInputStream());

        // Выполняем POST-запрос к эндпоинту `/save-report-photo` с фиктивным объектом `MockMultipartFile`
        mockMvc.perform(multipart("/save-report-photo")
                        .file(mockMultipartFile)
                        .param("reportId", "1"))
                .andExpect(status().isOk());

        // Проверяем, что метод `uploadReportPhoto()` из `reportPhotoService` был вызван
        verify(reportPhotoService).uploadReportPhoto(1L, mockMultipartFile);
    }
}*/



