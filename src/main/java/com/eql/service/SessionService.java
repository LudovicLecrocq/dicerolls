package com.eql.service;

import com.eql.models.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionService {
    void saveSession(Session session);
    List<Session> findAll();

    Session findById(Long id);

    Session findBySName(String sName);
}
