package com.ourteam.animal_shelter.controller;

/*import com.fasterxml.jackson.databind.ObjectMapper;
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
        List<Dog> act = new ArrayList<>();
        act.add(dogTest);
        List<Dog> exp = new ArrayList<>();
        exp.add(dogTest);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/dog/getListOfAdopted/" + dogTest)
                .accept(MediaType.APPLICATION_JSON));

        assertEquals(act.size(), exp.size());
        for (int i = 0; i < act.size(); i++) {
            assertEquals(exp.get(i).getName(), act.get(i).getName());
        }
    }
}

import com.ourteam.animal_shelter.repository.DogRepository;
import net.minidev.json.JSONObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ourteam.animal_shelter.controller.DogController;

import com.ourteam.animal_shelter.entity.animal.Dog;
import com.ourteam.animal_shelter.service.DogService;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest
public class DogControllerWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogRepository dogRepository;
    @SpyBean
    private DogService dogService;
    @InjectMocks
    private DogController dogController;


   /* private Dog dog;

    @BeforeEach
    public void setUp() {
        dog = new Dog();
        dog.setId(1);
        dog.setName("Buddy");
        dog.setAge(3);
        dog.setHealthy(true);
    @Test
    public void saveDogTest() throws Exception {
        Integer id = 1;
        String name = "Barbos";

        JSONObject dogObject = new JSONObject();
        dogObject.put("name", name);

        Dog dog = new Dog();
        dog.setId(id);
        dog.setName(name);
        dog.setHealthy(true);

        when(dogRepository.save(any(Dog.class))).thenReturn(dog);
        when(dogRepository.findById(any(Integer.class))).thenReturn(Optional.of(dog));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/dog")   //send
                        .content(dogObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())   //receive
                        .andExpect(jsonPath("$.id").value(1))
                        .andExpect(jsonPath("$.name").value("Barbos"));


    }

//.andExpect(status().isOk())   //receive
  //          .andExpect(jsonPath("$.id").value(id))
    //        .andExpect(jsonPath("$.name").value(name));




  /*  @Test
    public void save_positive() throws Exception {
        when(dogService.save(dog)).thenReturn(true);

        mockMvc.perform(post("/dog")
                        .contentType("application/json")
                        .content("{\"name\": \"Buddy\", \"age\": 3, \"isHealthy\": true}"))
                .andExpect(status().isOk());

        verify(dogService).save(dog);
    }

    @Test
    public void save_negative() throws Exception {
        when(dogService.save(dog)).thenReturn(false);

        mockMvc.perform(post("/dog")
                        .contentType("application/json")
                        .content("{\"name\": \"Buddy\", \"age\": 3, \"isHealthy\": true}"))
                .andExpect(status().isBadRequest());

        verify(dogService).save(dog);
    }

    @Test
    public void findById_positive() throws Exception {
        when(dogService.findById(1)).thenReturn(java.util.Optional.of(dog));

        mockMvc.perform(get("/dog/1"))
                .andExpect(status().isOk());

        verify(dogService).findById(1);
    }

    @Test
    public void findById_negative() throws Exception {
        when(dogService.findById(1)).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/dog/1"))
                .andExpect(status().isNotFound());

        verify(dogService).findById(1);
    }

    @Test
    public void findAll_positive() throws Exception {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);

        when(dogService.findAll()).thenReturn(dogs);

        mockMvc.perform(get("/dog"))
                .andExpect(status().isOk());

        verify(dogService).findAll();
    }

    @Test
    public void findAll_negative() throws Exception {
        List<Dog> dogs = new ArrayList<>();

        when(dogService.findAll()).thenReturn(dogs);

        mockMvc.perform(get("/dog"))
                .andExpect(status().isNotFound());

        verify(dogService).findAll();
    }

    @Test
    public void updateById_positive() throws Exception {
        when(dogService.updateById(1, "Buddy", 3, true)).thenReturn(1);

        mockMvc.perform(put("/dog/1")
                        .contentType("application/json")
                        .param("name", "Buddy")
                        .param("age", "3")
                        .param("isHealthy", "true"))
                .andExpect(status().isOk());

        verify(dogService).updateById(1, "Buddy", 3, true);
    }

    @Test
    public void updateById_negative() throws Exception {
        when(dogService.updateById(1, "Buddy", 3, true)).thenReturn(0);

        mockMvc.perform(put("/dog/1")
                        .contentType("application/json")
                        .param("name", "Buddy")
                        .param("age", "3")
                        .param("isHealthy", "true"))
                .andExpect(status().isBadRequest());

        verify(dogService).updateById(1, "Buddy", 3, true);
    }

    @Test
    public void deleteById_positive() throws Exception {
        when(dogService.deleteById(1)).thenReturn(true);

        mockMvc.perform(delete("/dog/1"))
                .andExpect(status().isOk());

        verify(dogService).deleteById(1);
    }

    @Test
    public void deleteById_negative() throws Exception {
        when(dogService.deleteById(1)).thenReturn(false);

        mockMvc.perform(delete("/dog/1"))
                .andExpect(status().isNotFound());

        verify(dogService).deleteById(1);
    }*/

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.ourteam.animal_shelter.entity.animal.Dog;
import com.ourteam.animal_shelter.service.DogService;
import com.ourteam.animal_shelter.controller.DogController;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerWithMockTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    private DogService dogService;

    @InjectMocks
    private DogController dogController;

    private Dog dog1;
    private Dog dog2;

    @BeforeEach
    public void setUp() {
        dog1 = new Dog("Dog1", 1, true);
        dog2 = new Dog("Dog2", 2, false);
    }

    @Test
    public void shouldReturn200WhenSaveDog() throws Exception {
        // given
        when(dogService.save(dog1)).thenReturn(true);
        String json = new ObjectMapper().writeValueAsString(dog1);

        // when & then
        mockMvc.perform(post("/dog/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn200WhenFindDogById() throws Exception {
        // given
        when(dogService.findById(1)).thenReturn(Optional.of(dog1));
        // when & then
        mockMvc.perform(get("/dog/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(dog1)));
    }

    @Test
    public void shouldReturn404WhenDogWithIdNotFound() throws Exception {
        // given
        when(dogService.findById(3)).thenReturn(Optional.empty());
        // when & then
        mockMvc.perform(get("/dog/3"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200WhenFindAllDogs() throws Exception {
        // given
        List<Dog> dogs = Arrays.asList(dog1, dog2);
        when(dogService.findAll()).thenReturn(dogs);
        // when & then
        mockMvc.perform(get("/dog/"))
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(dogs)));
    }

    @Test
    public void shouldReturn404WhenNoDogsFound() throws Exception {
        // given
        when(dogService.findAll()).thenReturn(List.of());
        // when & then
        mockMvc.perform(get("/dog/"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200WhenUpdateDogById() throws Exception {
        // given
        when(dogService.updateById(1, "Dog1", 1, true)).thenReturn(1);
        mockMvc.perform(put("/dog/1?name=Dog1&age=1&isHealthy=true"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400WhenUpdateDogByIdWithBadRequest() throws Exception {
        // given
        when(dogService.updateById(1, null, null, null)).thenReturn(0);
        mockMvc.perform(put("/dog/1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn200WhenDeleteDogById() throws Exception {
        // given
        when(dogService.deleteById(1)).thenReturn(true);
        mockMvc.perform(delete("/dog/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn404WhenDeleteDogByIdWithBadRequest() throws Exception {
        // given
        when(dogService.deleteById(3)).thenReturn(false);
        mockMvc.perform(delete("/dog/3"))
                .andExpect(status().isNotFound());
    }
}


