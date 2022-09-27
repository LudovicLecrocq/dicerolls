package com.eql.service;

import com.eql.models.Weapon;

import java.util.List;

public interface WeaponService {

    List<Weapon> findAll();

    Weapon findByName(String name);
}
