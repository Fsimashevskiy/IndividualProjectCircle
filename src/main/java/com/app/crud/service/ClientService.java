package com.app.crud.service;

import com.app.crud.model.Address;
import com.app.crud.model.Client;
import com.app.crud.model.User;

import java.util.List;

public interface ClientService {
    boolean isEmailExist(Client client);
    boolean save(Client client);

    List<Client> findAllClients();

    void delete(int id);
    Client findClientById(int id);

    boolean makeClientAdmin(int id);

}
