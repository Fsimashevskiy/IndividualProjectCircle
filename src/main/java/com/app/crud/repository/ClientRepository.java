package com.app.crud.repository;

import com.app.crud.model.Client;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientByEmail(String email);

    Client findClientById(int id);


}
