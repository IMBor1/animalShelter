package com.ourteam.animal_shelter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourteam.animal_shelter.entity.animal.Dog;
import com.ourteam.animal_shelter.model.Client;
import com.ourteam.animal_shelter.repository.DogRepository;
import com.ourteam.animal_shelter.service.DogService;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
@WebMvcTest(DogController.class)
public class DogControllerWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private DogService dogService;
    @MockBean
    private DogRepository dogRepository;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllDogsCorrect() throws Exception {
        Integer id = 20;
        String name = "test";
        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);
        List<Dog> act = new ArrayList<>();
        act.add(dogTest);
        List<Dog> exp = new ArrayList<>();
        exp.add(dogTest);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/dog/getListOf/" + dogTest)
                .accept(MediaType.APPLICATION_JSON));

        assertEquals(act.size(), exp.size());
        for (int i = 0; i < act.size(); i++) {
            assertEquals(exp.get(i).getName(), act.get(i).getName());
        }
    }

    @Test
    void getDogInfoCorrect() throws Exception {
        Integer id = 20;
        String name = "test";

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);


        when(dogService.findById(dogTest.getId())).thenReturn(Optional.of(dogTest));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dog/getInfoDog/" + id)
                        .content(objectMapper.writeValueAsString(Optional.of(dogTest)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(dogTest.getName())));

    }


    @Test
    void addDogCorrect() throws Exception {

        Integer id = 20;
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
    public void updateDogCorrect() throws Exception {
        Integer id = 20;
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
    void deleteDogCorrect() throws Exception {
        Integer id = 20;
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
    void getListOfAdoptedDogsCorrect() throws Exception {
        Integer id = 20;
        String name = "test";
        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);
        dogTest.setAdopted(true);
        List<Dog> act = new ArrayList<>();
        act.add(dogTest);
        List<Dog> exp = new ArrayList<>();
        exp.add(dogTest);
        // when(dogService.getAdopted(true).thenReturn(act);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/dog/getListOfAdopted/" + dogTest)
                .accept(MediaType.APPLICATION_JSON));

        assertEquals(act.size(), exp.size());
        for (int i = 0; i < act.size(); i++) {
            assertEquals(exp.get(i).getName(), act.get(i).getName());
        }
    }

    @Test
    void adoptDogCorrect() throws Exception {
        Integer id = 20;
        String name = "test";
        boolean isNotAdopted = false;
        boolean isAdopted = true;


        Client client = new Client();
        client.setName("davr");

        Dog dogTest = new Dog();
        dogTest.setId(id);
        dogTest.setName(name);
        dogTest.setAdopted(isNotAdopted);

        Dog dogUpdate = new Dog();
        dogUpdate.setId(id);
        dogUpdate.setAdopted(isAdopted);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("isAdopted", isAdopted);

        when(dogRepository.findById(any(Integer.class))).thenReturn(Optional.of(dogTest));
        when(dogRepository.save(any(Dog.class))).thenReturn(dogUpdate);


        mockMvc.perform(MockMvcRequestBuilders
                        .put("/dog/adoptDog/" + id)
                        .content(jsonObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.adopted").value(isAdopted));
    }
}