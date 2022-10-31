package com.app.crud.service;

import com.app.crud.model.Manipulator;

import java.util.List;

public interface ManipulatorService {
    List<Manipulator> findAllManipulator();
    Manipulator findManipulatorById(int id);
    Manipulator findManipulatorByIdContains(int id);
    void save(Manipulator manipulator);
    void delete(int id);
}
