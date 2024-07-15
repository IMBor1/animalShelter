package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.model.Photo;
import com.ourteam.animal_shelter.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Operation(
            summary = "Выводит фото собаки по айди собаки",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Фотография собаки"
                    )
            }
    )
    @GetMapping("/{id}/photo-from-db")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Long id) {
        Photo photo = photoService.findDogPhoto(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(photo.getMediaType()));
        headers.setContentLength(photo.getData().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(photo.getData());
    }
    @Operation(
            summary = "Выводит фотографии всех собак",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Фотографии всех собак"
                    )
            }
    )
    @GetMapping(value = "/all-photos-from-db")
    public ResponseEntity<List<Photo>> downloadAllPhotos(@RequestParam("page") Integer pageNumber,
                                                          @RequestParam("size") Integer pageSize) {
        return ResponseEntity.ok(photoService.findAllDogsPhoto(pageNumber,pageSize));

    }
    @Operation(
            summary = "Сохраняет фотграфию собаки",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Фотография сохранена"
                    )
            }
    )
    @PostMapping(value = "/{dogId}/save-dog-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> savePhoto(@RequestParam Long dogId,
                                            @RequestBody MultipartFile multipartFile) throws IOException {
        photoService.uploadPhoto(dogId,multipartFile);
        return ResponseEntity.ok().build();
    }

}
