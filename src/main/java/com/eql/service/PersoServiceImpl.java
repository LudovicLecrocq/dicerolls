package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.User;
import com.eql.repository.PersoRepo;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersoServiceImpl implements  PersoService{
    @Autowired
    PersoRepo repo;
    @Autowired
    UserRepository userRepository;

    @Override
    public void savePerso(Personnage perso) {
        repo.save(perso);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
