package com.eql.service;

import com.eql.models.Role;
import com.eql.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    @Override
    public List<Role> roles() {
        return roleRepo.findAll();
    }
}
