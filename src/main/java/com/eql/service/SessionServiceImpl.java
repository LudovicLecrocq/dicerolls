package com.eql.service;

import com.eql.models.Session;
import com.eql.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService{
    @Autowired
    SessionRepo sessionRepo;

    @Override
    public void saveSession(Session session) {
        sessionRepo.save(session);
    }

    @Override
    public List<Session> findAll() {
        return sessionRepo.findAll();
    }

    @Override
    public Session findById(Long id) {
        Optional<Session> session = sessionRepo.findById(id);
        if (session.isPresent()){
            return session.get();
        } else {
            throw new RuntimeException("Session not found");
        }
    }

    @Override
    public Session findBySName(String sName) {
        return sessionRepo.findBySName(sName);
    }
}
