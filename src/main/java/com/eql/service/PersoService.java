package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.User;

import java.util.List;

public interface PersoService {

    void savePerso(Personnage perso);

    void deletePerso(Personnage perso);

    List<Personnage> findAllByUser(Long id);
    Personnage findById(Long id);
    User findUserById(Long id);
}
