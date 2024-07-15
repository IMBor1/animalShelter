package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.exception.DogAlreadyExistsException;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogService dogService;

    @Operation(
            summary = "Добавление питомца в приют"

    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Питомец добавлен"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Параметры запроса отсутствуют или имеют некорректный формат"
            )
    })
    @PostMapping("/addDog")
    public void addDog(@RequestBody Dog dog) {
        if (dogService.getDogById(dog.getId()).isPresent()) {
            throw new DogAlreadyExistsException("Такой питомец уже существует");
        }
        dogService.addDog(dog);
    }

    @Operation(
            summary = "Получение информации о питомце"
    )

    @GetMapping("/getInfoDog/{id}")
    public ResponseEntity<Optional<Dog>> getDog(@PathVariable long id) {
        Optional<Dog> dogToFind = dogService.getDogById(id);
        if (dogToFind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dogService.getDogById(id));
    }

    @Operation(
            summary = "Коррекция информации о питомце"
    )

    @PutMapping("/updateInfoDog")
    public ResponseEntity<Dog> updateDog(@RequestBody Dog dog) {
        Dog dogToUpdate = dogService.updateDog(dog);
        if (dogToUpdate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dogToUpdate);

    }

    @Operation(
            summary = "Удаление данных о питомце"
    )

    @DeleteMapping("/deleteDog/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable long id) {
        dogService.deleteDog(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получение списка всех питомцев"
    )

    @GetMapping("/getListOfAllDogs")
    public ResponseEntity<List<Dog>> getListOfAllDogs() {
        if (dogService.getAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dogService.getAll());
    }

}
