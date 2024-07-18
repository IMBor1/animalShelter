package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.repository.ClientRepository;
import com.ourteam.animal_shelter.repository.DogRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с Клиентами
 */
@Service
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;
    private final DogService dogService;
    private final DogRepository dogRepository;

    private final TelegramBot telegramBot;

    public ClientService(ClientRepository clientRepository, DogService dogService, DogRepository dogRepository, TelegramBot telegramBot) {
        this.clientRepository = clientRepository;
        this.dogService = dogService;
        this.dogRepository = dogRepository;
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
                    client.setProbationaryPeriod(30);
                    client.setTimer(0);
                    client.setDog(dog);
                    dog.setClient(client);
                    dog.setAdopted(true);
                    clientRepository.save(client);
                    dogRepository.save(dog);
                    telegramBot.execute(new SendMessage(
                            update.callbackQuery().message().chat().id(),
                            "Поздравляем вы усыновили питомца: " + dog.getName()));
                }
                telegramBot.execute(new SendMessage(
                        update.callbackQuery().message().chat().id(),
                        "У вас уже есть питомец: " + client.getDog().getName()));
            } else {
                dog.setClient(clientRepository.save(new Client(
                        update.callbackQuery().message().chat().id(),
                        update.callbackQuery().message().chat().username(),
                        true,
                        0,
                        dog,
                        30
                )));
                dog.setAdopted(true);
                dogRepository.save(dog);
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
