package com.codegym.minitest.controller;

import com.codegym.minitest.model.City;
import com.codegym.minitest.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAllCity() {
        List<City> cities = (List<City>) cityService.findAll();
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> findCityById(@RequestParam Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        City city = cityOptional.get();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<City> updateCity(@RequestParam Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<City> deleteCity(@RequestParam Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }
}
