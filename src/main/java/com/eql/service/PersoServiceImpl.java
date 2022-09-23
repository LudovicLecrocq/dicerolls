package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.User;
import com.eql.repository.PersoRepo;
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

    @Override
    public void savePerso(Personnage perso) {
        repo.save(perso);
    }

    @Override
    public List<Personnage> findAllByUser(Long id) {
        List<Personnage> personnages = persoRepo.findAllByUser(id);
        return personnages;
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
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
