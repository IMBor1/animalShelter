package com.ourteam.animal_shelter.buttons;

import com.ourteam.animal_shelter.constants.Constants;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.stereotype.Service;

@Service
public class Buttons {
    private final TelegramBot telegramBot;

    public Buttons(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void ButtonsStage_0(Update update) {
        String comMsg = update.message().text();
        Long chatId = update.message().chat().id();
        if (comMsg.equalsIgnoreCase("/start")) {
            SendResponse response = telegramBot.execute(new SendMessage(chatId, Constants.MEET));
        }
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.addRow(new InlineKeyboardButton(
                        "Информация о приюте").callbackData("/c1"),
                new InlineKeyboardButton(
                        "Как взять животное?").callbackData("/c2"));
        markup.addRow(new InlineKeyboardButton(
                        "Прислать отчет о питомце").callbackData("/c3"),
                new InlineKeyboardButton(
                        "Позвать волонтера").callbackData("/c4"));
        SendMessage send = new SendMessage(chatId, "Выберете один из вариантов:").
                replyMarkup(markup);
        telegramBot.execute(send);

    }

    public void buttonsStage_1(Update update) {
        long chat_Id = update.callbackQuery().message().chat().id();
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.addRow(new InlineKeyboardButton(
                        "Информация о приюте").callbackData("/a1"),
                new InlineKeyboardButton(
                        "Расписание и адрес приюта").callbackData("/a2"));
        markup.addRow(new InlineKeyboardButton(
                        "Оформление пропуска").callbackData("/a3"),
                new InlineKeyboardButton(
                        "Рекомендации техники безопасности").callbackData("/a4"));
        markup.addRow(new InlineKeyboardButton(
                        "Обратная связь").callbackData("/a5"),
                new InlineKeyboardButton(
                        "Позвать волонтера").callbackData("/a6"));
        SendMessage send = new SendMessage(chat_Id, "Выберете один из вариантов:").
                replyMarkup(markup);
        telegramBot.execute(send);


    }
}
