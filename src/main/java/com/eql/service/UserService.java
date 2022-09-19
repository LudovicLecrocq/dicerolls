package com.eql.service;

import com.eql.dto.UserDto;
import com.eql.models.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUser();

}
