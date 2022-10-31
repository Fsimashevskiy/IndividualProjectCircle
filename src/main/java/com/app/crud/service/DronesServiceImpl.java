package com.app.crud.service;

import com.app.crud.model.Drones;
import com.app.crud.model.Phone;
import com.app.crud.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DronesServiceImpl implements DronesService{

    @Autowired
    DroneRepository droneRepository;

    @Override
    public List<Drones> findAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drones findDronesById(int id) {
        return droneRepository.findDronesById(id);
    }

    @Override
    public Drones findDronesByIdContains(int id) {
        return droneRepository.findDronesByIdContains(id);
    }

    @Override
    public void save(Drones drones) {
        droneRepository.save(drones);
    }

    @Override
    public void delete(int id) {
        droneRepository.delete(droneRepository.findDronesById(id));
    }
}
