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
    DronesService droneService;

    @Autowired
    CarService carService;

    @Autowired
    ComputerService computerService;

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

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String cars(Model model) {
        model.addAttribute("cars", carService.findAllCars());
        model.addAttribute("searchForm", new SearchForm());
        return "car";
    }

    @RequestMapping(value = "/cars/find", method = RequestMethod.GET)
    public String getCarById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Car car = carService.findCarById(searchForm.getId());
        if(car==null){
            return "redirect:/cars";
        }
        model.addAttribute("car", car );
        return "searchCar";
    }

    @RequestMapping(value = "/cars/efind", method = RequestMethod.GET)
    public String getCarByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Car car = carService.findCarByIdContains(searchForm.getId());
        if(car==null){
            return "redirect:/cars";
        }
        model.addAttribute("car", car );
        return "searchCar";
    }
    @RequestMapping(value = "/cars/add", method = RequestMethod.GET)
    public String addCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("users", userService.findAllUsers());
        return "addCar";
    }

    @PostMapping(value = "/cars/add")
    public String addCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            return "addCar";
        }
        carService.save(car);
        return "redirect:/cars";
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

    @RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.POST)
    public String deleteCar(@PathVariable("id") int id) {
        carService.delete(id);
        return "redirect:/cars";
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

    @RequestMapping(value = "/cars/edit/{id}", method = RequestMethod.GET)
    public String carUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carService.findCarById(id));
        model.addAttribute("users", userService.findAllUsers());
        return "editCar";
    }

    @PostMapping(value = "/cars/edit/{id}")
    public String editUser(@PathVariable("id") int id, @Valid @ModelAttribute("car") Car car,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            car.setId(id);
            model.addAttribute("users", userService.findAllUsers());
            return "editCar";
        }

        carService.save(car);
        return "redirect:/cars";
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

    @RequestMapping(value = "/drones", method = RequestMethod.GET)
    public String drones(Model model) {
        model.addAttribute("drones", droneService.findAllDrones());
        model.addAttribute("searchForm", new SearchForm());
        return "drones";
    }

    @RequestMapping(value = "/drones/find", method = RequestMethod.GET)
    public String getDronesById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Drones drones = droneService.findDronesById(searchForm.getId());
        if(drones==null){
            return "redirect:/drones";
        }
        model.addAttribute("drones", drones );
        return "searchDrones";
    }

    @RequestMapping(value = "/drones/efind", method = RequestMethod.GET)
    public String getDronesByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Drones drones = droneService.findDronesByIdContains(searchForm.getId());
        if(drones==null){
            return "redirect:/drones";
        }
        model.addAttribute("drones", drones );
        return "searchDrones";
    }

    @RequestMapping(value = "/drones/add", method = RequestMethod.GET)
    public String addDronesPage(Model model) {
        Drones drones = new Drones();
        model.addAttribute("drones", drones);
        model.addAttribute("users", userService.findAllUsers());
        return "addDrones";
    }


    @PostMapping(value = "/drones/add")
    public String addDrones(@Valid @ModelAttribute("drones") Drones drones, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            return "addDrones";
        }
        droneService.save(drones);
        return "redirect:/drones";
    }

    @RequestMapping(value = "/drones/delete/{id}", method = RequestMethod.POST)
    public String deleteDrones(@PathVariable("id") int id) {
        phoneService.delete(id);
        return "redirect:/drones";
    }

    @RequestMapping(value = "/drones/edit/{id}", method = RequestMethod.GET)
    public String dronesUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("drones", droneService.findDronesById(id));
        model.addAttribute("users", userService.findAllUsers());
        return "editDrones";
    }

    @PostMapping(value = "/drones/edit/{id}")
    public String editUser(@PathVariable("id") int id, @Valid @ModelAttribute("drones") Drones drones,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            drones.setId(id);
            model.addAttribute("users", userService.findAllUsers());
            return "editDrones";
        }
        droneService.save(drones);
        return "redirect:/drones";
    }

    //Computer
    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    public String computer(Model model) {
        model.addAttribute("computer", computerService.findAllComputer());
        model.addAttribute("searchForm", new SearchForm());
        return "computer";
    }

    @RequestMapping(value = "/computer/find", method = RequestMethod.GET)
    public String getComputerById(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Computer computer = computerService.findComputerById(searchForm.getId());
        if(computer==null){
            return "redirect:/computer";
        }
        model.addAttribute("computer", computer );
        return "searchComputer";
    }

    @RequestMapping(value = "/computer/efind", method = RequestMethod.GET)
    public String getComputerByIdContains(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        Computer computer = computerService.findComputerByIdContains(searchForm.getId());
        if(computer==null){
            return "redirect:/computer";
        }
        model.addAttribute("computer", computer );
        return "searchComputer";
    }

    @RequestMapping(value = "/computer/add", method = RequestMethod.GET)
    public String addComputerPage(Model model) {
        Computer computer = new Computer();
        model.addAttribute("computer", computer);
        model.addAttribute("users", userService.findAllUsers());
        return "addComputer";
    }


    @PostMapping(value = "/computer/add")
    public String addComputer(@Valid @ModelAttribute("computer") Computer computer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            return "addComputer";
        }
        computerService.save(computer);
        return "redirect:/computer";
    }

    @RequestMapping(value = "/computer/delete/{id}", method = RequestMethod.POST)
    public String deleteComputer(@PathVariable("id") int id) {
        computerService.delete(id);
        return "redirect:/computer";
    }

    @RequestMapping(value = "/computer/edit/{id}", method = RequestMethod.GET)
    public String computerUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("computer", computerService.findComputerById(id));
        model.addAttribute("users", userService.findAllUsers());
        return "editComputer";
    }

    @PostMapping(value = "/computer/edit/{id}")
    public String editUser(@PathVariable("id") int id, @Valid @ModelAttribute("computer") Computer computer,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            computer.setId(id);
            model.addAttribute("users", userService.findAllUsers());
            return "editComputer";
        }
        computerService.save(computer);
        return "redirect:/computer";
    }
}
