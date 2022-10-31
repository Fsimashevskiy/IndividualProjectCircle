package com.app.crud.repository;

import com.app.crud.model.Computer;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    List<Computer> findAllByUser(User user);
    List<Computer> findAllByUserContains(User user);
    Computer findComputerById(int id);
    Computer findComputerByIdContains(int id);
}
