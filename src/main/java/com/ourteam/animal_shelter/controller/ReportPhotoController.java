package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.service.ReportPhotoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/{reportId}/save-report-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveReportPhoto(@RequestParam Long reportId,
                                                  @RequestBody MultipartFile multipartFile) throws IOException {

        reportPhotoService.uploadReportPhoto(reportId, multipartFile);
        return ResponseEntity.ok().build();
    }
}
