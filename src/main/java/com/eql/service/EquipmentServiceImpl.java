package com.eql.service;

import com.eql.models.Armour;
import com.eql.models.Equipement;
import com.eql.models.Personnage;
import com.eql.models.Weapon;
import com.eql.repository.ArmourRepo;
import com.eql.repository.EquipmentRepo;
import com.eql.repository.PersoRepo;
import com.eql.repository.WeaponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    EquipmentRepo equipmentRepo;
    @Autowired
    PersoRepo persoRepo;
    @Autowired
    WeaponRepo weaponRepo;
    @Autowired
    ArmourRepo armourRepo;
    @Override
    public Equipement findByPersoId(Long id) {
        Optional<Personnage> personnage = persoRepo.findById(id);
        if (personnage.isPresent()){
            return personnage.get().getEquipment();
        } else {
            throw new RuntimeException("Perso not found");
        }
    }

    @Override
    public List<Weapon> findAllWeapon(Long id) {
        Optional<Equipement> equipement = equipmentRepo.findById(id);
        if (equipement.isPresent()){
            return equipement.get().getWeapons();
        } else {
            throw new RuntimeException("Equipment not found");
        }
    }

    @Override
    public List<Armour> findAllArmour(Long id) {
        Optional<Equipement> equipement = equipmentRepo.findById(id);
        if (equipement.isPresent()){
            return equipement.get().getArmours();
        } else {
            throw new RuntimeException("Equipment not found");
        }
    }

    @Override
    public int findArmorValue(Long id) {
        Optional<Equipement> equipement = equipmentRepo.findById(id);
        if (equipement.isPresent()){
            List<Armour> armours = equipement.get().getArmours();
            int armourValue = 0;
            for (Armour armour : armours) {
                armourValue += armour.getDefValue();
            }
            return armourValue;
        } else {
            throw new RuntimeException("Equipment not Found");
        }

    }
    @Override
    public int findAtqValue(Long id) {
        Optional<Equipement> equipement = equipmentRepo.findById(id);
        if (equipement.isPresent()){
            List<Weapon> weapons = equipement.get().getWeapons();
            int weaponValue = 0;
            for (Weapon weapon : weapons) {
                weaponValue += weapon.getAtqValue();
            }
            return weaponValue;
        } else {
            throw new RuntimeException("Equipment not Found");
        }

    }
}
