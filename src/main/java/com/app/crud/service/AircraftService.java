package com.app.crud.service;

import com.app.crud.model.Aircraft;

import java.util.List;

public interface AircraftService {
    List<Aircraft> findAllAircraft();
    Aircraft findAircraftById(int id);
    Aircraft findAircraftByIdContains(int id);
    void save(Aircraft aircraft);
    void delete(int id);
}
