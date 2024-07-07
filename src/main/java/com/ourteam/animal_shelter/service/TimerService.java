package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.constants.Constants;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class TimerService {
    private final TelegramBot telegramBot;
    private final ClientRepository clientRepository;

    public TimerService(TelegramBot telegramBot, ClientRepository clientRepository) {
        this.telegramBot = telegramBot;
        this.clientRepository = clientRepository;
    }

    Logger logger = LoggerFactory.getLogger(TimerService.class);

    @Scheduled(fixedDelay = 8640000)
    public void reminder1Day() {
        clientRepository.findAllByTimerLessThan(LocalDateTime.now().minusDays(1)).forEach(
                task -> {
                    SendResponse execute = telegramBot.execute(new SendMessage(task.getChatId(), Constants.REMINDER));
                    if (execute.isOk()) {
                        clientRepository.delete(task);
                    } else {
                        logger.error("Failed to send task" + task);
                    }
                }

        );
    }

    @Scheduled(fixedDelay = 8640000)
    public void reminder2Days() {
        clientRepository.findAllByTimerLessThan(LocalDateTime.now().minusDays(2)).forEach(
                task -> {
                    SendResponse execute = telegramBot.execute(new SendMessage(task.getChatId(), (task.getChatId() + Constants.REMINDER_TO_VOLUNTEER)));
                    if (execute.isOk()) {
                        clientRepository.delete(task);
                    } else {
                        logger.error("Failed to send task" + task);
                    }
                }

        );
    }
}
