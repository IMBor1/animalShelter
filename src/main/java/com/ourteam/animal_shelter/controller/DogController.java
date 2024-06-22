package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.service.DogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
@Tag(
        name = "Собаки",
        description = "CRUD-операции для работы с собаками"
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "500",
                description = "Произошла ошибка"
        )
})
public class DogController {
    private final DogService dogService;
    public DogController(DogService dogService){
        this.dogService = dogService;
    }
}
