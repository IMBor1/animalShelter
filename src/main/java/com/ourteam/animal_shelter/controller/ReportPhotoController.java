package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.service.ReportPhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ReportPhotoController {

    private final ReportPhotoService reportPhotoService;

    public ReportPhotoController(ReportPhotoService reportPhotoService) {
        this.reportPhotoService = reportPhotoService;
    }
    @Operation(
            summary = "Сохранение фотографий животных ежедневного отчета в БД",
            responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Фотография сохранена"
                            )
            }
    )
    @PostMapping(value = "/{reportId}/save-report-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveReportPhoto(@Parameter(description = "Айди ежденвного отчета") @RequestParam Long reportId,
                                                  @Parameter(description = "Файл фотографии в формате jpg")@RequestBody MultipartFile multipartFile) throws IOException {

        reportPhotoService.uploadReportPhoto(reportId, multipartFile);
        return ResponseEntity.ok().build();
    }

}
