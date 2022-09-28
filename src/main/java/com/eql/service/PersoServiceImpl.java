package com.eql.service;

import com.eql.models.Equipement;
import com.eql.models.Personnage;
import com.eql.models.Stat;
import com.eql.models.User;
import com.eql.repository.PersoRepo;
import com.eql.repository.StatRepo;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersoServiceImpl implements  PersoService{
    @Autowired
    PersoRepo repo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersoRepo persoRepo;
    StatRepo statRepo;

    @Override
    public void firstSave(Personnage personnage) {
        Stat stat = new Stat(10,10,personnage.getRace().getStrBon()+4,personnage.getRace().getDexBon()+4,personnage.getRace().getConBon()+4,personnage.getRace().getIntBon()+4
                ,personnage.getRace().getWisBon()+4,personnage.getRace().getChaBon()+4,personnage);
        personnage.setStat(stat);
        persoRepo.save(personnage);
    }

    @Override
    public void savePerso(Personnage perso) {
        repo.save(perso);
    }

    @Override
    public void deletePerso(Personnage perso) {
        persoRepo.delete(perso);
    }

    @Override
    public List<Personnage> findAllByUser(Long id) {
        return persoRepo.findAllByUser(id);
    }

    public Personnage findById(Long id){
        Optional<Personnage> personnage = persoRepo.findById(id);
        if (personnage.isPresent()){
            return personnage.get();
        } else {
            throw new RuntimeException("Perso not found");
        }
    }

    @Override
    public Personnage findByName(String name) {
        return persoRepo.findByName(name);
    }

}
