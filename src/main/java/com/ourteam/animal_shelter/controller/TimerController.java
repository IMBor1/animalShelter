package com.ourteam.animal_shelter.controller;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.ourteam.animal_shelter.service.TimerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimerController {
    private final TimerService timerService;
    private final ClientRepository clientRepository;

    public TimerController(TimerService timerService, ClientRepository clientRepository) {
        this.timerService = timerService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("timer/{idChat}")
    public ResponseEntity findByChatId(@PathVariable Long idChat,
                                       @RequestParam Integer probationaryPeriod) {
        Client client = timerService.findByChat_Id(idChat, probationaryPeriod);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
