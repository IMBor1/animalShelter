package com.ourteam.animal_shelter.service;


import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DogServiceTest {

    @Mock
    private DogRepository dogRepository;

    @InjectMocks
    private DogService dogService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddDog() {
        Dog dog = new Dog();
        dogService.addDog(dog);

        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void testGetDogById() {
        long id = 1L;
        Dog dog = new Dog();
        when(dogRepository.findById(id)).thenReturn(Optional.of(dog));

        Optional<Dog> retrievedDog = dogService.getDogById(id);

        assertTrue(retrievedDog.isPresent());
        assertEquals(dog, retrievedDog.get());
    }

    @Test
    public void testUpdateDog() {
        Dog dog = new Dog();
        when(dogRepository.save(dog)).thenReturn(dog);

        Dog updatedDog = dogService.updateDog(dog);

        assertEquals(dog, updatedDog);
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void testDeleteDog() {
        long id = 1L;
        dogService.deleteDog(id);

        verify(dogRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetAll() {
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        when(dogRepository.findAll()).thenReturn(dogs);

        List<Dog> retrievedDogs = dogService.getAll();

        assertEquals(dogs, retrievedDogs);
    }

    @Test
    public void testDogToAdopt() {
        long id = 1L;
        Dog dog = new Dog();
        Client client = new Client();

        when(dogRepository.findById(id)).thenReturn(Optional.of(dog));
        when(dogRepository.save(dog)).thenReturn(dog);

        Dog adoptedDog = dogService.dogToAdopt(id, client);

        assertEquals(dog, adoptedDog);
        assertTrue(adoptedDog.isAdopted());
        assertEquals(client, adoptedDog.getClient());
        verify(dogRepository, times(1)).findById(id);
        verify(dogRepository, times(1)).save(dog);
    }
}
