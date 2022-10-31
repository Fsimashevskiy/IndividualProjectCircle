package com.app.crud.service;

import com.app.crud.model.Satellite;
import com.app.crud.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteServiceImpl implements SatelliteService{

    @Autowired
    SatelliteRepository satelliteRepository;

    @Override
    public List<Satellite> findAllSatellite() {
        return satelliteRepository.findAll();
    }

    @Override
    public Satellite findSatelliteById(int id) {
        return satelliteRepository.findSatelliteById(id);
    }

    @Override
    public Satellite findSatelliteByIdContains(int id) {
        return satelliteRepository.findSatelliteByIdContains(id);
    }

    @Override
    public void save(Satellite satellite) {
        satelliteRepository.save(satellite);
    }

    @Override
    public void delete(int id) {
        satelliteRepository.delete(satelliteRepository.findSatelliteById(id));
    }
}
