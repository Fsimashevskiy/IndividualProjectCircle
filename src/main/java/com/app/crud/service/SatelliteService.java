package com.app.crud.service;

import com.app.crud.model.Satellite;

import java.util.List;

public interface SatelliteService {
    List<Satellite> findAllSatellite();
    Satellite findSatelliteById(int id);
    Satellite findSatelliteByIdContains(int id);
    void save(Satellite satellite);
    void delete(int id);
}
