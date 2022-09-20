package com.eql.service;

import com.eql.dto.PersoDto;
import com.eql.models.Personnage;
import com.eql.models.User;
import com.eql.repository.PersoRepo;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersoServiceImpl implements  PersoService{
    @Autowired
    PersoRepo repo;
    @Autowired
    UserRepository userRepository;

    @Override
    public void savePerso(PersoDto persoDto) {
        Personnage personnage = new Personnage();
        personnage.setName(persoDto.getName());
        personnage.setSurname(persoDto.getSurname());
        personnage.setUser(persoDto.getUser());
        repo.save(personnage);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findByPersoId(id);
    }
}
