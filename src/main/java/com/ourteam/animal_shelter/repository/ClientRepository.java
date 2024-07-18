package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
   public Client findByChatId(long chat_Id);

   @Query(value = "Select * from Client WHERE hasPet true", nativeQuery = true)
   List<Client> getHasPetClients();
}
