package com.app.crud.service;

import com.app.crud.model.Computer;
import com.app.crud.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    ComputerRepository computerRepository;

    @Override
    public List<Computer> findAllComputer() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findComputerById(int id) {
        return computerRepository.findComputerById(id);
    }

    @Override
    public Computer findComputerByIdContains(int id) {
        return computerRepository.findComputerByIdContains(id);
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void delete(int id) {
        computerRepository.delete(computerRepository.findComputerById(id));
    }
}
