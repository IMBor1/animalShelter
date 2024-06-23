package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
//    public List<Client> findByAll
}
