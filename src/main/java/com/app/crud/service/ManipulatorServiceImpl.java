package com.app.crud.service;

import com.app.crud.model.Manipulator;
import com.app.crud.repository.ManipulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManipulatorServiceImpl implements ManipulatorService{

    @Autowired
    ManipulatorRepository manipulatorRepository;

    @Override
    public List<Manipulator> findAllManipulator() {
        return manipulatorRepository.findAll();
    }

    @Override
    public Manipulator findManipulatorById(int id) {
        return manipulatorRepository.findManipulatorById(id);
    }

    @Override
    public Manipulator findManipulatorByIdContains(int id) {
        return manipulatorRepository.findManipulatorByIdContains(id);
    }

    @Override
    public void save(Manipulator manipulator) {
        manipulatorRepository.save(manipulator);
    }

    @Override
    public void delete(int id) {
        manipulatorRepository.delete(manipulatorRepository.findManipulatorById(id));
    }
}
