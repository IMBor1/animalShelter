package com.ourteam.animal_shelter.listener;

import com.ourteam.animal_shelter.constants.Constants;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            try {

                logger.info("Processing update: {}", update);
                String comMsg = update.message().text();
                if (comMsg.equalsIgnoreCase("/start")) {
                    Long chatId = update.message().chat().id();
                    SendResponse response = telegramBot.execute(new SendMessage(chatId, Constants.MEET));
                }
            } catch (Exception e) {
                logger.error("update not correct");
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
