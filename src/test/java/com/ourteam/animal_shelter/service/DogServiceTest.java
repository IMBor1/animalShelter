package com.ourteam.animal_shelter.service;


import com.ourteam.animal_shelter.entity.animal.Dog;
import com.ourteam.animal_shelter.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {


    @Mock
    private DogService dogService;
    @Mock
    private DogRepository dogRepository;

    @Test
    public void testAddDog() {
        Dog dog = new Dog("Барбос", 5, true,true);
        when(dogService.save(dog)).thenReturn(true);
        Boolean t = dogService.save(dog);
        assertEquals(true, t);
        verify(dogService).save(dog);
    }

    @Test
    public void testGetDogById() {
        Dog dog = new Dog("Барбос", 5, true,true);
        when(dogService.findById(1)).thenReturn(Optional.of(dog));
        Optional<Dog> foundDog = dogService.findById(1);
        // Проверяем, что найденная собака соответствует ожидаемой
        assertEquals(Optional.of(dog), foundDog);
        verify(dogService).findById(1);
    }

    @Test
    public void testUpdateDog() {
        Dog dog = new Dog("Барбос", 5, true,true);
        when(dogService.updateById(1, "Барбос", 5, true)).thenReturn(1);
        Integer updated = dogService.updateById(1, "Барбос", 5, true);
        // Проверяем, что собака была обновлена
        assertEquals(1, updated);
        verify(dogService).updateById(1, "Барбос", 5, true);
    }

    @Test
    public void testDeleteDogById() {
        // Создаем тестовую собаку по идентификатору 1
        Dog dog = new Dog();
        dog.setId(1);
        dogRepository.save(dog);
        // Удаляем собаку по ее идентификатору
        dogService.deleteById(1);
        // Проверяем, что собака не существует
        assertFalse(dogRepository.existsById(1));
    }

    @Test
    public void testGetAllDogs() {
        List<Dog> dogs = Arrays.asList (new Dog("Барбос", 5, true,true),
                new Dog("Каштанка", 3, true,true));
        when(dogService.findAll()).thenReturn(dogs);
        List<Dog> foundDogs = dogService.findAll();
        // Проверяем, что список собак соответствует ожидаемому
        assertEquals(dogs, foundDogs);
        verify(dogService).findAll();
    }

}
