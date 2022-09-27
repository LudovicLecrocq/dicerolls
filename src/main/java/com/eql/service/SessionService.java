package com.eql.service;

import com.eql.models.Session;

import java.util.List;

public interface SessionService {
    void saveSession(Session session);
    List<Session> findAll();

    Session findById(Long id);
}
