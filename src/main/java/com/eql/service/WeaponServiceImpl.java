package com.eql.service;

import com.eql.models.Weapon;
import com.eql.repository.WeaponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService{
    @Autowired
    WeaponRepo weaponRepo;
    @Override
    public List<Weapon> findAll() {
        return weaponRepo.findAll();
    }

    @Override
    public Weapon findByName(String name) {
        return weaponRepo.findByName(name);
    }
}
