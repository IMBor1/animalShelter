package com.ourteam.animal_shelter.service;

/*import com.ourteam.animal_shelter.model.Report;
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

    }*/


/*import com.ourteam.animal_shelter.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.pengrad.telegrambot.TelegramBot;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;

    @ExtendWith(MockitoExtension.class)
    public class ReportServiceTest {

        private ReportService reportService;
        // Создаем фиктивный объект `ClientRepository`
        @Mock
        private ClientRepository clientRepository;
        // Создаем фиктивный объект `TelegramBot`
        @Mock
        private TelegramBot telegramBot;

        @BeforeEach
        public void setUp() {
            reportService = new ReportService(clientRepository, telegramBot);
        }

        @Test
        public void informationOfShelter_positive() {
            // Создаем фиктивный объект `Update`
            Update update = mock(Update.class);

            reportService.informationOfShelter(update);

            verify(telegramBot).execute(any());
        }
}*/

import static org.mockito.Mockito.verify;

import com.ourteam.animal_shelter.repository.ClientRepository;

import com.pengrad.telegrambot.TelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.ourteam.animal_shelter.service.ReportService;


@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private TelegramBot telegramBot;
    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        reportService = new ReportService(clientRepository, telegramBot);
    }

    @Test
    public void shouldCallInformationOfShelterMethod() {
        // given
        com.pengrad.telegrambot.model.Update update = new com.pengrad.telegrambot.model.Update();

        // when
        reportService.informationOfShelter(update);

        // then
        verify(reportService).informationOfShelter(update);
    }
}

