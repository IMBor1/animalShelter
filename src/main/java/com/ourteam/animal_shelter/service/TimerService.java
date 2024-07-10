package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.constants.Constants;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Класс с методами, которые делают запрос к базе данных при помощи аннотации @Scheduled.
 */
@Service
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
     * метод делает запрос к базе данных раз в сутки и отправляет сообщение пользователю.
     */
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

    /**
     * метод делает запрос к базе данных раз в сутки и отправляет сообщение волонтеру.
     */
    @Scheduled(fixedDelay = 8640000)
    public void reminder2Days() {
        clientRepository.findAllByTimerLessThan(LocalDateTime.now().minusDays(2)).forEach(
                task -> {
                    SendResponse execute = telegramBot.execute(new SendMessage(chatIdVolunteer,
                            (task.getChatId() + Constants.REMINDER_TO_VOLUNTEER)));
                    if (execute.isOk()) {
                        clientRepository.delete(task);
                    } else {
                        logger.error("Failed to send task" + task);
                    }
                }

        );
    }

    /**
     * метод делает запрос к базе данных раз в сутки и отправляет сообщение волонтеру.
     */
    @Scheduled(fixedDelay = 8640000)
    public void reminder30Day() {
        clientRepository.findAllByProbationaryPeriodLessThan(LocalDateTime.now().minusDays(30)).forEach(
                task -> {
                    SendResponse execute = telegramBot.execute(new SendMessage(chatIdVolunteer,
                            (task.getChatId() + Constants.PROBATIONARY_PERIOD_30_DAYS_HAS_ENDED)));
                    if (execute.isOk()) {
                        clientRepository.delete(task);
                    } else {
                        logger.error("Failed to send task" + task);
                    }
                }

        );
    }

    /**
     * метод делает запрос к базе данных раз в сутки и отправляет сообщение волонтеру.
     */
    @Scheduled(fixedDelay = 8640000)
    public void reminder14Day() {
        clientRepository.findAllByProbationaryPeriodLessThan(LocalDateTime.now().minusDays(14)).forEach(
                task -> {
                    SendResponse execute = telegramBot.execute(new SendMessage(chatIdVolunteer,
                            (task.getChatId() + Constants.PROBATIONARY_PERIOD_14_DAYS_HAS_ENDED)));
                    if (execute.isOk()) {
                        clientRepository.delete(task);
                    } else {
                        logger.error("Failed to send task" + task);
                    }
                }

        );
    }
}
