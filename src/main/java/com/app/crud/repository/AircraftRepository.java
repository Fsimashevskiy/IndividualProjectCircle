package com.app.crud.repository;

import com.app.crud.model.Aircraft;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    List<Aircraft> findAllByUser(User user);
    List<Aircraft> findAllByUserContains(User user);
    Aircraft findAircraftById(int id);
    Aircraft findAircraftByIdContains(int id);
}
