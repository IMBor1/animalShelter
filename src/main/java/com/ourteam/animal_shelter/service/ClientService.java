package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Сервис для работы с Клиентами
 */
@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final DogService dogService;

    private final TelegramBot telegramBot;

    public ClientService(ClientRepository clientRepository, DogService dogService, TelegramBot telegramBot) {
        this.clientRepository = clientRepository;
        this.dogService = dogService;
        this.telegramBot = telegramBot;
    }

    /**
     * Сохраняет клиента с питомцем или добавляет старому клиенту питомца
     * @param update апдейт телеграмма
     */
    public void saveClient(Update update) {
        String callback = update.callbackQuery().data();
        if (callback.startsWith("/x")) {
            Long idDog = Long.parseLong(callback.replace("/x", ""));
            Client client = getByChatId(update.callbackQuery().message().chat().id());
            Dog dog = dogService.getDogById(idDog).orElseThrow();
            if (client != null) {
                if (client.getDog() == null) {
                    client.setHasPet(true);
                    client.setTimer(LocalDateTime.now());
                    dog.setClient(client);
                    dogService.updateDog(dog);
                    client.setDog(dog);
                    clientRepository.save(client);
                    telegramBot.execute(new SendMessage(
                            update.callbackQuery().message().chat().id(),
                            "Поздравляем вы усыновили питомца: " + dog.getName()));
                }
                telegramBot.execute(new SendMessage(
                        update.callbackQuery().message().chat().id(),
                        "У вас уже есть питомец: " + client.getDog().getName()));
            } else {
                clientRepository.save(new Client(
                        update.callbackQuery().message().chat().id(),
                        update.callbackQuery().message().chat().username(),
                        true,
                        LocalDateTime.now(),
                        dog
                ));
                telegramBot.execute(new SendMessage(update.callbackQuery().message().chat().id(),
                        "Поздравляем вы усыновили питомца: " + dog.getName()));
            }
        }
    }

    /**
     * Получение клиента по чатайди
     * @param chatId чатайди клиента
     * @return объект класса клиента {@link Client}
     */
    public Client getByChatId(Long chatId) {
        return clientRepository.findByChatId(chatId);
    }
}
