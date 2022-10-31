package com.app.crud.repository;

import com.app.crud.model.Manipulator;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManipulatorRepository extends JpaRepository<Manipulator, Integer> {
    List<Manipulator> findAllByUser(User user);
    List<Manipulator> findAllByUserContains(User user);
    Manipulator findManipulatorById(int id);
    Manipulator findManipulatorByIdContains(int id);
}
