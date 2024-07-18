package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.service.TimerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для установки испытательного срока
 */
@RestController
public class TimerController {
    private final TimerService timerService;

    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @Operation(
            summary = "добавить испытательный срок"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Поиск клиента и установление параметра испытательный срок",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Client.class)
                    )
            )
    })
    @PostMapping("timer/{idChat}")
    public ResponseEntity setProbationaryPeriodById(@Parameter(description = "Номер айди чата", example = "5051414034") @PathVariable Long idChat,
                                                    @RequestParam(required = false, name = "14 или 30") Integer probationaryPeriod) {
        Client client = timerService.setProbationaryPeriodById(idChat, probationaryPeriod);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
