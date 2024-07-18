package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.constants.Constants;
import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Класс с методами, которые делают запрос к базе данных при помощи аннотации @Scheduled.
 */
@Service
@Transactional
public class TimerService {
    @Value("${chat.id.volunteer}")
    private Long chatIdVolunteer;
    private final TelegramBot telegramBot;
    private final ClientRepository clientRepository;

    public TimerService(TelegramBot telegramBot, ClientRepository clientRepository) {
        this.telegramBot = telegramBot;
        this.clientRepository = clientRepository;
    }

    Logger logger = LoggerFactory.getLogger(TimerService.class);

    /**
     *
     * метод делает запрос к базе данных раз в сутки и отправляет сообщение пользователю и раз в два дня волонтеру.
     */
    @Scheduled(fixedDelay = 8640000)
    public void reminder() {
        clientRepository.findAll().forEach(
                client -> {
                    if (client.isHasPet()) {
                        if (client.getProbationaryPeriod() == 0) {
                            SendResponse execute = telegramBot.execute(new SendMessage(chatIdVolunteer,
                                    (client.getChatId() + Constants.PROBATIONARY_PERIOD_30_DAYS_HAS_ENDED)));
                        }
                        if (client.getTimer() == 0) {
                            client.setTimer(client.getTimer() + 1);
                        }
                        if (client.getTimer() == 1) {
                            client.setTimer(client.getTimer() + 1);
                            SendResponse execute = telegramBot.execute(new SendMessage(client.getChatId(), Constants.REMINDER));
                        } else if (client.getTimer() == 2) {
                            SendResponse execute = telegramBot.execute(new SendMessage(chatIdVolunteer,
                                    (client.getChatId() + Constants.REMINDER_TO_VOLUNTEER)));
                        }
                    }
                }
        );
    }




    /**
     * Метод,который позволяет установить испытательный срок.
     * использует метод репозитория findByChatId
     *
     * @param id_chat            не может быть null
     * @param probationaryPeriod
     * @return
     */
    public Client setProbationaryPeriodById(long id_chat, Integer probationaryPeriod) {
        Client client = clientRepository.findByChatId(id_chat);
        client.setProbationaryPeriod(probationaryPeriod);
        return clientRepository.save(client);
    }

}
