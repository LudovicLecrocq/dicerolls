package com.eql.controller;


import com.eql.models.Personnage;
import com.eql.models.User;
import com.eql.service.PersoService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/mjHomepage")
    public String mjHomepage(){return "mjHomepage";}

    @GetMapping("/userHomepage")
    public String userHomepage(){return "userHomepage";}

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user")User user, BindingResult result, Model model){
        User existingUser = service.findUserByEmail(user.getEmail());
        if (existingUser!=null && existingUser.getEmail()!=null){
            result.rejectValue("email",null,"Email already in use");
        }
        if (result.hasErrors()){
            model.addAttribute("user",user);
            return "register";
        }
        service.saveUser(user);
        return "redirect:/index?success";
    }
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = service.findAllUser();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }


    @GetMapping("/perso")
    public String per(Model model){
        Personnage perso = new Personnage();
        model.addAttribute("perso",perso);
        return "perso";
    }
    @PostMapping("/perso/save")
    public  String perso(@Valid @ModelAttribute("perso") Personnage perso, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute(perso);
            return "perso";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        perso.setUser(user);
        persoService.savePerso(perso);
        return "userHomepage";
    }

    @GetMapping("listPerso")
    public String listPerso(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        List<Personnage> personnages = persoService.findAllByUser(user.getId());
        model.addAttribute("persos",personnages);
        return "listPerso";
    }

    @GetMapping("/showPerso/{id}")
    public String showPerso(@PathVariable(value = "id") Long id, Model model){
        Personnage personnage = persoService.findById(id);
        model.addAttribute("perso",personnage);
        return "showPerso";
    }

    @GetMapping("/deletePerso/{id}")
    public String deletePerso(@PathVariable(value = "id") Long id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        Personnage personnage = persoService.findById(id);
        persoService.deletePerso(personnage);
        model.addAttribute("persos",persoService.findAllByUser(user.getId()));
        return "listPerso";
    }

    @PostMapping("/savePerso")
    public String savePerso(@ModelAttribute("perso") Personnage personnage, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        personnage.setUser(user);
        persoService.savePerso(personnage);
        model.addAttribute("persos",persoService.findAllByUser(user.getId()));
        return "/listPerso";
    }
}