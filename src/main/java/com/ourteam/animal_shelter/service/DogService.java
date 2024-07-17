package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.repository.DogRepository;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    /**
     * Сохраняет заданную сущность.
     * Используется метод репозитория {@link JpaRepository#save(Object)}
     *
     * @param dog сохраняемая сущность
     */
    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    /**
     * Позволяет получить информацию о питомце
     *
     * @param id идентификатор питомца
     * @return Optional <Dog>
     */

    public Optional<Dog> getDogById(long id) {
        return dogRepository.findById(id);
    }

    /**
     * Позволяет обновить информацию о питомце
     *
     * @param dog сущность питомца
     * @return обновленные данные питомца
     */

    public Dog updateDog(Dog dog) {
        return dogRepository.save(dog);
    }

    /**
     * Позволяет удалить питомца из базы данных
     *
     * @param id идентификатор питомца
     */

    public void deleteDog(long id) {
        dogRepository.deleteById(id);
    }

    /**
     * Позволяет получить список всех питомцев
     *
     * @return список всех питомцев
     */

    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    /**
     * Позволяет взять под опеку питомца
     *
     * @param id идентификатор животного
     * @return обновленная информация о питомце
     */
    public Dog connectDogToClient(long id, Client client) {
        Dog dog = dogRepository.findById(id).get();
        dog.setAdopted(true);
        dog.setClient(client);
        return dogRepository.save(dog);
    }

}