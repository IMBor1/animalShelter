package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TimerServiceTest {
    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    TimerService timerService;

    public void SheduledRemider() {
        Client client = new Client();
        client.setProbationaryPeriod(1);
        client.setTimer(0);
        client.setChatId(Long.parseLong("1234"));

        List<Client> clients = new ArrayList<>();
        clients.add(client);

        Mockito.when(clientRepository.getHasPetClients()).thenReturn(clients);

        timerService.reminder();
        Mockito.verify(clientRepository, Mockito.times(1)).getHasPetClients();


    }

    @Test
    public void testSetProbationaryPeriod() {
        Client client = new Client();
        client.setName("roy");
        client.setProbationaryPeriod(1);
        client.setTimer(0);
        client.setChatId(1234);

//        List<Client> clients = new ArrayList<>();
//        clients.add(client);
        when(clientRepository.findByChatId(1234)).thenReturn(client);
        //verify(clientRepository, Mockito.times(1)).findByChatId(1234);
        Assertions.assertEquals(client, new Client(1234, "roy", false, 0, null, 1));
    }

}
