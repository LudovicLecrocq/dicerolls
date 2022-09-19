package com.eql.security;

import com.eql.models.User;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user!=null){
            return new  org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority((role.getLabel()))).collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("Invalid Password");
        }
    }
}
