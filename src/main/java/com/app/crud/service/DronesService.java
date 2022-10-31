package com.app.crud.service;

import com.app.crud.model.Drones;
import com.app.crud.model.User;

import java.util.List;

public interface DronesService {
    List<Drones> findAllDrones();
    Drones findDronesById(int id);
    Drones findDronesByIdContains(int id);
    void save(Drones drones);
    void delete(int id);
}
