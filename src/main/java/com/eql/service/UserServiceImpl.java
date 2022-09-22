package com.eql.service;

import com.eql.models.Role;
import com.eql.models.User;
import com.eql.repository.RoleRepository;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public void saveUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepository.findBylabel("ROLE_USER");

        if (role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setLabel("ROLE_USER");
        return roleRepository.save(role);

    }
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }


}
