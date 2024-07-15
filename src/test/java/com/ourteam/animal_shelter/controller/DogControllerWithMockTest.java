package com.ourteam.animal_shelter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourteam.animal_shelter.model.Dog;
import com.ourteam.animal_shelter.repository.DogRepository;
import com.ourteam.animal_shelter.service.DogService;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DogController.class)
@ExtendWith(MockitoExtension.class)
class DogControllerWithMockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogRepository dogRepository;

    @SpyBean
    private DogService dogService;


    @InjectMocks
    private DogController dogController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addPetCorrect() throws Exception {

        long id = 20L;
        String name = "test";

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);


        when(dogRepository.save(any(Dog.class))).thenReturn(dogTest);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/dog/addDog")
                        .content(objectMapper.writeValueAsString(dogTest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    @Test
    void getPetInfoCorrect() throws Exception {
        long id = 20L;
        String name = "test";

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);


        when(dogService.getDogById(dogTest.getId())).thenReturn(Optional.of(dogTest));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dog/getInfoDog/" + id)
                        .content(objectMapper.writeValueAsString(Optional.of(dogTest)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(dogTest.getName())));

    }

    @Test
    void updatePetCorrect() throws Exception {
        long id = 20L;
        String name = "test";
        String newName = "new";

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);

        Dog dogUpdate = new Dog();
        dogUpdate.setId(id);
        dogUpdate.setName(newName);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", newName);

        when(dogRepository.save(any(Dog.class))).thenReturn(dogUpdate);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/dog/updateInfoDog")
                        .content(jsonObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(newName));
    }

    @Test
    void deletePetCorrect() throws Exception {
        Long id = 20L;
        String name = "test";

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);


        when(dogRepository.save(any(Dog.class))).thenReturn(dogTest);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/dog/deleteDog/" + dogTest.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getListOfAdoptedPetsCorrect() throws Exception {
        long id = 20L;
        String name = "test";
        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);
        dogTest.setAdopted(true);
        List<Dog> act = new ArrayList<>();
        act.add(dogTest);
        List<Dog> exp = new ArrayList<>();
        exp.add(dogTest);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/dog/getListOfAdopted/")
                .accept(MediaType.APPLICATION_JSON));

        assertEquals(act.size(), exp.size());
        for (int i = 0; i < act.size(); i++) {
            assertEquals(exp.get(i).getName(), act.get(i).getName());
        }
    }

    @Test
    void getListOfAllPetsCorrect() throws Exception {
        long id = 20L;
        String name = "test";
        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);
        List<Dog> act = new ArrayList<>();
        act.add(dogTest);
        List<Dog> exp = new ArrayList<>();
        exp.add(dogTest);
        when(dogService.getAll()).thenReturn(act);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/dog/getListOfAllDogs")
                .accept(MediaType.APPLICATION_JSON));

        assertEquals(act.size(), exp.size());
        for (int i = 0; i < act.size(); i++) {
            assertEquals(exp.get(i).getName(), act.get(i).getName());
        }
    }

}