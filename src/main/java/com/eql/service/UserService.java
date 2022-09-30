package com.eql.service;

import com.eql.models.Role;
import com.eql.models.Session;
import com.eql.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user, Role role);

    User findUserByEmail(String email);

    List<User> findAllUser();

    List<Session> findMySessions(Long id);

}
