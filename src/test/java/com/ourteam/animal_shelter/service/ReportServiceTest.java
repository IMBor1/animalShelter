package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Report;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class ReportServiceTest {


    @Test
    public void informationOfShelter_positive() {
        // Создаем фиктивный объект `Update`
        Update update = mock(Update.class);

        // Создаем фиктивный объект `ClientRepository`
        ClientRepository clientRepository = mock(ClientRepository.class);

        // Создаем фиктивный объект `TelegramBot`
        TelegramBot telegramBot = mock(TelegramBot.class);

        // Создаем экземпляр класса `ReportService`
        ReportService reportService = new ReportService(clientRepository, telegramBot);

        // Вызываем метод `informationOfShelter()`
        reportService.informationOfShelter(update);

    }

}
