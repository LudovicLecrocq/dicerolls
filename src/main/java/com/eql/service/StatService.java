package com.eql.service;

import com.eql.models.Stat;

public interface StatService {

    Stat findById(Long id);
    void saveStat(Stat stat);

    Stat findByPersoId(Long id);

}
