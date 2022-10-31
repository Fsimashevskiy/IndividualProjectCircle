package com.app.crud.service;

import com.app.crud.model.Computer;

import java.util.List;

public interface ComputerService {
    List<Computer> findAllComputer();
    Computer findComputerById(int id);
    Computer findComputerByIdContains(int id);
    void save(Computer computer);
    void delete(int id);
}
