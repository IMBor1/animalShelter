package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ClientRepository clientRepository;
    private final TelegramBot telegramBot;

    public ReportService(ClientRepository clientRepository, TelegramBot telegramBot) {
        this.clientRepository = clientRepository;
        this.telegramBot = telegramBot;
    }

    public void informationOfShelter(Update update) {

    }
}
