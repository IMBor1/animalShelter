package com.ourteam.animal_shelter.service;

import com.ourteam.animal_shelter.entity.animal.Dog;
import com.ourteam.animal_shelter.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public Optional<Dog> findById(int id) {
        return dogRepository.findById(id);
    }
    public boolean save(Dog dog) {
        if (!(dog == null
                || (dog.getName() == null || dog.getName().isBlank())
                || (dog.getAge() == null || dog.getAge() < 0)
                || dog.getHealthy() == null)) {
            dogRepository.save(dog);
            return true;
        }
        return false;
    }
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public Boolean deleteById(int id) {
        Optional<Dog> findDogById = findById(id);
        if (findDogById.isEmpty()) {
            return false;
        }
        dogRepository.deleteById(id);
        return true;
    }
    public Integer updateById(Integer id, String name, Integer age, Boolean isHealthy) {
        Optional<Dog> dog = findById(id);
        if (dog.isEmpty()
                || (name == null || name.isBlank())
                || (age == null || age < 0)
                || isHealthy == null) {
            return 0;
        } else {
            dogRepository.updateById(id, name, age, isHealthy);
            return 1;
        }
    }

}