package com.ourteam.animal_shelter.listener;

import com.ourteam.animal_shelter.constants.Constants;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс, в котором принимаются ответы от пользователя, обрабатываются и выдается ответ.
 * Метод обработки и отправки данных  {@link #process(List)}
 */

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

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
                    String comMsg = update.message().text();
                    Long chatId = update.message().chat().id();
                    if (comMsg.equalsIgnoreCase("/start")) {
                        SendResponse response = telegramBot.execute(new SendMessage(chatId, Constants.MEET));
                    }

                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    markup.addRow(new InlineKeyboardButton(
                                    "Узнать информацию о приюте").callbackData("/c1"),
                            new InlineKeyboardButton(
                                    "Как взять животное из приюта").callbackData("/c2"));
                    markup.addRow(new InlineKeyboardButton(
                                    "Прислать отчет о питомце").callbackData("/c3"),
                            new InlineKeyboardButton(
                                    "Позвать волонтера").callbackData("/c4"));
                    SendMessage send = new SendMessage(chatId, "Выберете один из вариантов:").
                            replyMarkup(markup);
                    telegramBot.execute(send);

                } catch (Exception e) {
                    logger.error("update not correct");
                }
            } else if (update.callbackQuery() != null) {
                String text = update.callbackQuery().data();
                long chat_Id = update.callbackQuery().message().chat().id();
                String path = " Для связи с волонтером позвоните по телефону +7-900-100-20-10";


                if (text.equalsIgnoreCase("/c4")) {
                    telegramBot.execute(new SendMessage(chat_Id, path));
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
