package com.eql.service;

import com.eql.dto.PersoDto;
import com.eql.models.User;

public interface PersoService {

    void savePerso(PersoDto persoDto);

    User findUserById(Long id);
}
