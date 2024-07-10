package com.ourteam.animal_shelter.repository;

import com.ourteam.animal_shelter.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
   public Client findByChatId(long chat_Id);

   public List<Client> findAllByTimerLessThan(LocalDateTime time);

   public List<Client> findAllByProbationaryPeriodLessThan(LocalDateTime probationaryPeriod);
}
