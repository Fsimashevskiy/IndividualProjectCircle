package com.app.crud.repository;

import com.app.crud.model.Satellite;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SatelliteRepository extends JpaRepository<Satellite, Integer> {
    List<Satellite> findAllByUser(User user);
    List<Satellite> findAllByUserContains(User user);
    Satellite findSatelliteById(int id);
    Satellite findSatelliteByIdContains(int id);
}
