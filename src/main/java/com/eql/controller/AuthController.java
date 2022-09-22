package com.eql.controller;


import com.eql.dto.PersoDto;
import com.eql.dto.UserDto;
import com.eql.models.User;
import com.eql.service.PersoService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    UserService service;
    @Autowired
    PersoService persoService;

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user")UserDto userDto, BindingResult result, Model model){
        User existingUser = service.findUserByEmail(userDto.getEmail());
        if (existingUser!=null && existingUser.getEmail()!=null){
            result.rejectValue("email",null,"Email already in use");
        }

        if (result.hasErrors()){
            model.addAttribute("user",userDto);
            return "register";
        }
        service.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = service.findAllUser();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/perso")
    public String per(Model model){
        PersoDto perso = new PersoDto();
        model.addAttribute("perso",perso);
        return "perso";
    }
    @PostMapping("/perso/save")
    public  String perso(@Valid @ModelAttribute("perso") PersoDto persoDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute(persoDto);
            return "perso";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        persoDto.setUser(user);
        System.out.println(user);
        System.out.println(persoDto);
        System.out.println(persoDto.getName() + "  " + persoDto.getSurname() + "   " + persoDto.getUser().getId());
        persoService.savePerso(persoDto);
        return "index";
    }
}