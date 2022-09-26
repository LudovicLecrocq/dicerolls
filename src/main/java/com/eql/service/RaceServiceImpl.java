package com.eql.service;

import com.eql.models.Race;
import com.eql.repository.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService{
    @Autowired
    RaceRepo raceRepo;

    @Override
    public Race findByLabel(String label) {
        return  raceRepo.findByLabel(label);
    }

    @Override
    public List<Race> findAll() {
        return raceRepo.findAll();
    }
}
