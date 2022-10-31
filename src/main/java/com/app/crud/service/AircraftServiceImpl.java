package com.app.crud.service;

import com.app.crud.model.Aircraft;
import com.app.crud.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService{

    @Autowired
    AircraftRepository aircraftRepository;

    @Override
    public List<Aircraft> findAllAircraft() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft findAircraftById(int id) {
        return aircraftRepository.findAircraftById(id);
    }

    @Override
    public Aircraft findAircraftByIdContains(int id) {
        return aircraftRepository.findAircraftByIdContains(id);
    }

    @Override
    public void save(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    @Override
    public void delete(int id) {
        aircraftRepository.delete(aircraftRepository.findAircraftById(id));
    }
}
