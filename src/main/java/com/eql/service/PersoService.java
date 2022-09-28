package com.eql.service;

import com.eql.models.Personnage;
import com.eql.models.Session;
import com.eql.models.User;

import java.util.List;

public interface PersoService {

    void firstSave(Personnage personnage);
    void savePerso(Personnage perso);

    void deletePerso(Personnage perso);

    List<Personnage> findAllByUser(Long id);
    Personnage findById(Long id);
    Personnage findByName(String name);

    Personnage findBySession(Long id);

}
