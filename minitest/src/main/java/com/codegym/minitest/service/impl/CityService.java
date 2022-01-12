package com.codegym.minitest.service.impl;

import com.codegym.minitest.model.City;
import com.codegym.minitest.repository.CityRepository;
import com.codegym.minitest.service.ICityService;
import com.codegym.minitest.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
cityRepository.deleteById(id);
    }
}
