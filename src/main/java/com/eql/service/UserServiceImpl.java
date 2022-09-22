package com.eql.service;

import com.eql.dto.PersoDto;
import com.eql.dto.UserDto;
import com.eql.models.Personnage;
import com.eql.models.Role;
import com.eql.models.User;
import com.eql.repository.PersoRepo;
import com.eql.repository.RoleRepository;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    PersoRepo persoRepo;

    @Override
    public void saveUser(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getFirstName() + "/" + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setLogin(userDto.getLogin());

        Role role = roleRepository.findBylabel("ROLE_ADMIN");

        if (role == null){
            role = checkRoleExist();

        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role checkRoleExist() {

        Role role = new Role();
        role.setLabel("ROLE_ADMIN");
        return roleRepository.save(role);

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void addPerso(Long id, PersoDto dto) {
        Personnage personnage = new Personnage();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            personnage.setUser(user.get());
            personnage.setName(dto.getName());
            personnage.setSurname(dto.getSurname());
            persoRepo.save(personnage);
            userRepository.save(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    private UserDto mapToUserDto(User user){

        UserDto userDto = new UserDto();

        String[] str = user.getName().split("/");

        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setLogin(user.getLogin());

        return userDto;
    }
}
