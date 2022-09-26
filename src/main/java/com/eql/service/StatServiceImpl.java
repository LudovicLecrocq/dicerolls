package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.Stat;
import com.eql.repository.PersoRepo;
import com.eql.repository.StatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatServiceImpl implements StatService{

    @Autowired
    StatRepo statRepo;
    @Autowired
    PersoRepo persoRepo;

    @Override
    public Stat findById(Long id) {
        Optional<Stat> stat = statRepo.findById(id);
        if (stat.isPresent()){
            return stat.get();
        } else {
            throw new RuntimeException("Stat not Found");
        }
    }

    @Override
    public void saveStat(Stat stat) {
        statRepo.save(stat);
    }

    @Override
    public Stat findByPersoId(Long id) {
        Optional<Personnage> personnage = persoRepo.findById(id);
        if (personnage.isPresent()){
            Stat stat = personnage.get().getStat();
            return stat;
        } else {
            throw new RuntimeException("Perso not found");
        }
    }
}
