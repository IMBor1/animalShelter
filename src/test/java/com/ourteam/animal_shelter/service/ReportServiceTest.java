package com.ourteam.animal_shelter.service;


import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private TelegramBot telegramBot;
    @Mock
    private ReportService reportService;


    @Test
    public void shouldCallInformationOfShelterMethod() {

        Update update = new Update();


        reportService.informationOfShelter(update);


        verify(reportService).informationOfShelter(update);
    }
}





