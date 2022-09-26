package com.eql.service;

import com.eql.models.Race;

import java.util.List;

public interface RaceService {

    Race findByLabel(String label);
    List<Race> findAll();
}
