package com.eql.service;

import com.eql.models.Armour;
import com.eql.repository.ArmourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmourServiceImpl implements ArmourService{
    @Autowired
    ArmourRepo armourRepo;
    @Override
    public List<Armour> findAll() {
        return armourRepo.findAll();
    }

    @Override
    public Armour findByName(String name) {
        return armourRepo.findByName(name);

    }
}
