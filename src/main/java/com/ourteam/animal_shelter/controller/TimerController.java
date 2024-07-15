package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.ourteam.animal_shelter.service.TimerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для установки испытательного срока
 */
@RestController
public class TimerController {
    private final TimerService timerService;
    private final ClientRepository clientRepository;

    public TimerController(TimerService timerService, ClientRepository clientRepository) {
        this.timerService = timerService;
        this.clientRepository = clientRepository;
    }

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
    @GetMapping("timer/{idChat}")
    public ResponseEntity findByChatId(@Parameter(description = "Номер айди чата", example = "534284") @PathVariable Long idChat,
                                       @RequestParam(required = false, name = "14/30") Integer probationaryPeriod) {
        Client client = timerService.findByChat_Id(idChat, probationaryPeriod);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
