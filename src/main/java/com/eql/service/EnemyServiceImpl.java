package com.eql.service;

import com.eql.models.Enemy;
import com.eql.repository.EnemyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnemyServiceImpl implements EnemyService{
    @Autowired
    EnemyRepo enemyRepo;

    @Override
    public Enemy findByName(String name) {
        return enemyRepo.findByName(name);
    }

    @Override
    public List<Enemy> findAll() {
        return enemyRepo.findAll();
    }
}
