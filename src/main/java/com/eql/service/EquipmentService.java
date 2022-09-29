package com.eql.service;

import com.eql.models.Armour;
import com.eql.models.Equipement;
import com.eql.models.Weapon;

import java.util.List;

public interface EquipmentService {

    Equipement findByPersoId(Long id);

    List<Weapon> findAllWeapon(Long id);
    List<Armour> findAllArmour(Long id);

    int findArmorValue(Long id);

    int findAtqValue(Long id);

}
