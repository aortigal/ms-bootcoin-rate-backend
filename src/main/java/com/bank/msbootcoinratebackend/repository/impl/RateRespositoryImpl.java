package com.bank.msbootcoinratebackend.repository.impl;

import com.bank.msbootcoinratebackend.models.Rate;
import com.bank.msbootcoinratebackend.repository.RateRespository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class RateRespositoryImpl implements RateRespository {

    private static final String KEY = "rate";
    private RedisTemplate redisTemplate;
    private HashOperations hashOperations;

    public RateRespositoryImpl(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }
    @Override
    public void save(Rate rate) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), rate);
    }

    @Override
    public Map<String, Rate> findAll(){
        return hashOperations.entries(KEY);
    }

    @Override
    public Rate findById(String id) {
        return (Rate) hashOperations.get(KEY, id);
    }

    @Override
    public void update(Rate rate) {
        save(rate);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
    
}
