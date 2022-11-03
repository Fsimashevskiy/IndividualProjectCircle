package com.app.crud.controller;

import com.app.crud.model.*;
import com.app.crud.repository.ClientRepository;
import com.app.crud.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    PhoneService phoneService;



    @Autowired
    ClientService clientService;



    @Autowired
    ClientRepository clientRepository;





    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Principal principal, Model model) {
        Client client = clientRepository.findClientByEmail(principal.getName());
        model.addAttribute("client", client);
        return "main";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("searchForm", new SearchForm());
        return "user";
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public String getUserById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        User user = userService.findUserById(searchForm.getId());
        if(user==null){
            return "redirect:/users";
        }
        model.addAttribute("user", user );
        return "searchUser";
    }

    @RequestMapping(value = "/users/efind", method = RequestMethod.GET)
    public String getUserByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        User user = userService.findUserByIdContains(searchForm.getId());
        if(user==null){
            return "redirect:/users";
        }
        model.addAttribute("user", user );
        return "searchUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }


    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public String phones(Model model) {
        model.addAttribute("phones", phoneService.findAllPhones());
        model.addAttribute("searchForm", new SearchForm());
        return "phone";
    }

    @RequestMapping(value = "/phones/find", method = RequestMethod.GET)
    public String getPhoneById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Phone phone = phoneService.findPhoneById(searchForm.getId());
        if(phone==null){
            return "redirect:/phones";
        }
        model.addAttribute("phone", phone );
        return "searchPhone";
    }

    @RequestMapping(value = "/phones/efind", method = RequestMethod.GET)
    public String getPhoneByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Phone phone = phoneService.findPhoneByIdContains(searchForm.getId());
        if(phone==null){
            return "redirect:/phones";
        }
        model.addAttribute("phone", phone );
        return "searchPhone";
    }

    @RequestMapping(value = "/phones/add", method = RequestMethod.GET)
    public String addPhonePage(Model model) {
        Phone phone = new Phone();
        model.addAttribute("phone", phone);
        model.addAttribute("users", userService.findAllUsers());
        return "addPhone";
    }



    @RequestMapping(value = "/phones/delete/{id}", method = RequestMethod.POST)
    public String deletePhone(@PathVariable("id") int id) {
        phoneService.delete(id);
        return "redirect:/phones";
    }






    @PostMapping(value = "/phones/add")
    public String addPhone(@Valid @ModelAttribute("phone") Phone phone, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            return "addPhone";
        }
        phoneService.save(phone);
        return "redirect:/phones";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        userService.save(user);
        return "redirect:/users";
    }




    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String editUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

    @PostMapping(value = "/users/edit/{id}")
    public String editUser(@PathVariable("id") int id, @Valid @ModelAttribute("user") User user,
                           BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "editUser";
        }

        userService.save(user);
        return "redirect:/users";
    }





    @RequestMapping(value = "/phones/edit/{id}", method = RequestMethod.GET)
    public String phoneUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", phoneService.findPhoneById(id));
        model.addAttribute("users", userService.findAllUsers());
        return "editPhone";
    }

    @PostMapping(value = "/phones/edit/{id}")
    public String editUser(@PathVariable("id") int id, @Valid @ModelAttribute("phone") Phone phone,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            phone.setId(id);
            model.addAttribute("users", userService.findAllUsers());
            return "editPhone";
        }
        phoneService.save(phone);
        return "redirect:/phones";
    }


//    drones





}
