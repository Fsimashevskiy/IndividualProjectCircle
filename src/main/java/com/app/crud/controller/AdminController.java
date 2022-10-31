package com.app.crud.controller;

import com.app.crud.model.Client;
import com.app.crud.model.User;
import com.app.crud.repository.ClientRepository;
import com.app.crud.service.ClientService;
import  com.app.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AdminController {
    @Autowired
    private ClientService clientService;

    @Autowired
    ClientRepository clientRepository;




    @GetMapping("/admin")
    public String clientList(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return "admin";
    }

    @PostMapping("/admin/manage/{id}")
    public String manage(@PathVariable("id") int id, Model model) {
        clientService.makeClientAdmin(id);
        return "redirect:/admin";
    }

    //clients

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.POST)
    public String deleteClient(@PathVariable("id") int id) {
        clientService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
    public String editClientPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientService.findClientById(id));
        return "editClient";
    }

    @PostMapping(value = "/admin/edit/{id}")
    public String ClientUser(@PathVariable("id") int id, @Valid @ModelAttribute("client") Client client,
                           BindingResult result) {
        Client dbClient=clientRepository.findClientById(id);

        if (result.hasErrors()) {

            client.setId(id);
            return "editClient";

        }
        dbClient.setName(client.getName());
        dbClient.setSurname(client.getSurname());
        dbClient.setEmail(client.getEmail());
        dbClient.setAddress(client.getAddress());
        dbClient.setAddress(client.getAddress());
        dbClient.setAddress(client.getAddress());
        dbClient.setAddress(client.getAddress());

        clientRepository.save(dbClient);

//        clientService.save(client);
        return "redirect:/admin";
    }



}
