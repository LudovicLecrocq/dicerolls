package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.User;

public interface PersoService {

    void savePerso(Personnage perso);

    User findUserById(Long id);
}
