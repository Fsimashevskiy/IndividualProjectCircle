package com.app.crud.repository;

import com.app.crud.model.Drones;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drones, Integer> {
    List<Drones> findAllByUser(User user);
    List<Drones> findAllByUserContains(User user);
    Drones findDronesById(int id);
    Drones findDronesByIdContains(int id);
}
