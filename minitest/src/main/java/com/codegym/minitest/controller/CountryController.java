package com.codegym.minitest.controller;

import com.codegym.minitest.model.Country;
import com.codegym.minitest.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
    @RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @GetMapping("")
    public ResponseEntity<Iterable<Country>> findAllCountry() {
        List<Country> countries = (List<Country>) countryService.findAll();
        if (countries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Country> findCategoryById(@RequestParam Long id) {
        Optional<Country> countryOptional = countryService.findById(id);
        if (!countryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Country country = countryOptional.get();
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

}
