package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.model.ReportPhoto;
import com.ourteam.animal_shelter.service.ReportPhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

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
                                                  @Parameter(description = "Файл фотографии в формате jpg") @RequestBody MultipartFile multipartFile) throws IOException {

        reportPhotoService.uploadReportPhoto(reportId, multipartFile);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Выводит список всех отчетов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список отчетов"
                    )
            }
    )
    @GetMapping(value = "/find-all-report")
    public Collection<Report> findAllReport() {
        return reportPhotoService.getAllReports();
    }

    @Operation(
            summary = "Выводит фото из ежедневного отчета по айди отчета",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Фотография из очтета"
                    )
            }
    )
    @GetMapping(value = "/{id}/find-report-photo-by-id")
    public ResponseEntity<byte[]> findReportPhotoByReportId(@PathVariable Long id) {
        ReportPhoto reportPhoto = reportPhotoService.getReportPhoto(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(reportPhoto.getData().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reportPhoto.getData());
    }

    @Operation(
            summary = "Находит отчет по айди",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Найденный отчет"
                    )
            }
    )
    @GetMapping(value = "/{id}/find-report")
    public Report findReportById(@PathVariable Long id) {
        return reportPhotoService.findReportById(id);
    }

    @Operation(
            summary = "Ставит отметку, что отчет проверен",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Отчет проверен"
                    )
            }
    )
    @PostMapping(value = "/{id}/verified-report")
    public ResponseEntity<Report> verifiedReport(@PathVariable Long id) {
        reportPhotoService.verifiedReportById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Отправляет предупреждение клиенту, что отчет заполняется плохо",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Предупрежение отправлено"
                    )
            }
    )
    @GetMapping(value = "/{id}/send-warning")
    public ResponseEntity<Client> sendWarningMessage(Long clientId) {
        reportPhotoService.sendWarning(clientId);
        return ResponseEntity.ok().build();
    }
}
