package com.eql.service;

import com.eql.models.Armour;

import java.util.List;

public interface ArmourService {

    List<Armour> findAll();

    Armour findByName(String name);
}
