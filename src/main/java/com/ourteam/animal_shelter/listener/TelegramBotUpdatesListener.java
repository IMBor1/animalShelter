package com.ourteam.animal_shelter.listener;

import com.ourteam.animal_shelter.buttons.Buttons;
import com.ourteam.animal_shelter.constants.Constants;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Класс, в котором принимаются ответы от пользователя, обрабатываются и выдается ответ.
 * Метод обработки и отправки данных  {@link #process(List)}
 */

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);


    private final TelegramBot telegramBot;
    private final Buttons buttons;

    public TelegramBotUpdatesListener(TelegramBot telegramBot, Buttons buttons) {
        this.telegramBot = telegramBot;
        this.buttons = buttons;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    /**
     * Метод для взаимодействия бота с пользователем
     *
     * @param updates
     * @return ответ на запрос пользователя
     * @throws Exception если зеачение update не корректное.
     */
    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            if (update.message() != null) {
                try {
                    logger.info("Processing update: {}", update);
                    buttons.ButtonsStage_0(update);

                } catch (Exception e) {
                    logger.error("update not correct");
                }
            } else if (update.callbackQuery() != null) {


                long chat_Id = update.callbackQuery().message().chat().id();
                String text = update.callbackQuery().data();
                if (text.equalsIgnoreCase("/c1")) {
                    buttons.buttonsStage_1(update);
                } else if (update.callbackQuery().data().equalsIgnoreCase("/c4")) {
                    telegramBot.execute(new SendMessage(update.callbackQuery().message().chat().id(), Constants.PHONE_VOLUNTEER));
                }
                text = update.callbackQuery().data();
                if (text.equalsIgnoreCase("/a1")) {
                    telegramBot.execute(new SendMessage(chat_Id, Constants.INFO_SHELTER));
                } else if (text.equalsIgnoreCase("/a2")) {
                    telegramBot.execute(new SendMessage(update.callbackQuery().message().chat().id(), Constants.SHEDULE));
                } else if (text.equalsIgnoreCase("/a3")) {
                    telegramBot.execute(new SendMessage(chat_Id, Constants.GUARD_CONTACTS));
                } else if (text.equalsIgnoreCase("/a4")) {
                    telegramBot.execute(new SendMessage(chat_Id, Constants.RULES));
//        }else if (text.equalsIgnoreCase("/c5")) {
//            telegramBot.execute(new SendMessage(chat_Id, Constants.SHEDULE));
                } else if (text.equalsIgnoreCase("/a6")) {
                    telegramBot.execute(new SendMessage(chat_Id, Constants.PHONE_VOLUNTEER));
                }


            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
