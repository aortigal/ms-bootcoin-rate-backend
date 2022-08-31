package com.bank.msbootcoinratebackend.repository;


import com.bank.msbootcoinratebackend.models.Rate;

import java.util.Map;

public interface RateRespository {

    Map<String, Rate> findAll();

    void update(Rate rate);
    Rate findById(String id);
    void save(Rate afiliado);
    void delete(String id);
}
