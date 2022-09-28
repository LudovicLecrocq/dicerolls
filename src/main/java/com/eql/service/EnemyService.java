package com.eql.service;
import com.eql.models.Enemy;
import java.util.List;

public interface EnemyService {
    Enemy findByName(String name);
    List<Enemy> findAll();
}