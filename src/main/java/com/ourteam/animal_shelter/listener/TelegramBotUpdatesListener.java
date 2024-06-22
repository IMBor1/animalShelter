package com.ourteam.animal_shelter.listener;

import com.ourteam.animal_shelter.service.AddressPhotoService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.SendResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private AddressPhotoService addressPhotoService;

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            Long chatId = update.message().chat().id();

            logger.info("Processing update: {}", update);
                if (update.message().text().equals("/address")) {
                    try {
                        SendResponse response = telegramBot.execute(
                                addressPhotoService.sendAddressPhoto(chatId,
                                        addressPhotoService.findAddressPhoto(1L).getFilePath(),
                                        "Наш адрес: г. Москва, Камергерский переулок, 6/5с3" +
                                                "\nРасписание работы: \nПн - Пт: c 09:00 до 18:00; \n" +
                                                "Сб,Вс - выходные дни."));

                    } catch (IOException e) {
                        logger.error("File not found");
                    }
                }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
