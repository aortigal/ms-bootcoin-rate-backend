package com.bank.msbootcoinratebackend.controllers;


import com.bank.msbootcoinratebackend.models.Rate;
import com.bank.msbootcoinratebackend.repository.RateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping ("/api/rate")
public class RateController {

    @Autowired
    private RateRespository rateRespository;


    @GetMapping
    public Map<String, Rate> findAll(){
        return rateRespository.findAll();
    }

    @GetMapping("/{id}")
    public Rate findById(@PathVariable String id){
        return rateRespository.findById(id);
    }

    @PostMapping
    public void createRate(@RequestBody Rate rate){
        rateRespository.save(rate);
    }

    @PutMapping
    public Rate update(@RequestBody Rate rate){
        rateRespository.update(rate);
        return rate;
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable String id){
        rateRespository.delete(id);
    }

}
