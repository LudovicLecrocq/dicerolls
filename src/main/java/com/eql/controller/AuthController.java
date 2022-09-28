package com.eql.controller;


import com.eql.models.Armour;
import com.eql.models.Equipement;
import com.eql.models.Personnage;
import com.eql.models.Race;
import com.eql.models.Session;
import com.eql.models.Stat;
import com.eql.models.User;
import com.eql.models.Weapon;
import com.eql.service.ArmourService;
import com.eql.service.EquipmentService;
import com.eql.service.PersoService;
import com.eql.service.RaceService;
import com.eql.service.SessionService;
import com.eql.service.StatService;
import com.eql.service.UserService;
import com.eql.service.WeaponService;
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

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    UserService service;
    @Autowired
    PersoService persoService;
    @Autowired
    StatService statService;
    @Autowired
    RaceService raceService;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    WeaponService weaponService;
    @Autowired
    ArmourService armourService;
    @Autowired
    SessionService sessionService;

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

    @GetMapping("/sessions")
    public String sessions(Model model){
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions",sessions);
        return "sessions";
    }

    @GetMapping("/newSession")
    public String newSession(Model model){
        Session session = new Session();
        model.addAttribute("sessionGame",session);
        return "newSession";
    }

    @GetMapping("/viewSession/{id}")
    public String viewSession(@PathVariable(value = "id")Long id, Model model){
        Session session = sessionService.findById(id);
        List<Personnage> personnages = session.getPersonnages();
        model.addAttribute("persos",personnages);
        return "viewSession";
    }

    @PostMapping("/session/save")
    public String saveSession(@ModelAttribute("sessionGame") Session session, BindingResult result, Model model){
        if (result.hasErrors()){
            Session session1 = new Session();
            model.addAttribute("sessionGame",session1);
            return "newSession";
        }

        sessionService.saveSession(session);
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions",sessions);
        return "sessions";
    }

    @GetMapping("/perso")
    public String per(Model model){
        Personnage perso = new Personnage();
        List<Race> races = raceService.findAll();
        List<Weapon> weapons = weaponService.findAll();
        List<Armour> armours = armourService.findAll();
        Weapon weaponP = new Weapon();
        Armour armourP = new Armour();
        model.addAttribute("perso",perso);
        model.addAttribute("races",races);
        model.addAttribute("weapons",weapons);
        model.addAttribute("armours",armours);
        model.addAttribute("weaponP",weaponP);
        model.addAttribute("armourP",armourP);
        return "perso";
    }
    @PostMapping("/perso/save")
    public  String perso(@Valid @ModelAttribute("perso") Personnage perso, @ModelAttribute("weaponP")Weapon weaponP, @ModelAttribute("armourP") Armour armourP, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Race> races = raceService.findAll();
            model.addAttribute("races",races);
            model.addAttribute("perso",perso);
            return "perso";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        perso.setUser(user);
        Equipement equipement = new Equipement();
        perso.setEquipment(equipement);

        Armour armour = armourService.findByName(armourP.getAName());
        Weapon weapon = weaponService.findByName(weaponP.getWName());
        perso.getEquipment().getArmours().add(armour);
        perso.getEquipment().getWeapons().add(weapon);
        persoService.firstSave(perso);
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
    @GetMapping("/viewStat/{id}")
    public String showStat(@PathVariable(value = "id") Long id, Model model){
        Stat stat = statService.findByPersoId(id);
        model.addAttribute("stat",stat);
        return "statView";
    }

    @GetMapping("/viewEquip/{id}")
    public String showEquip(@PathVariable(value = "id") Long id, Model model){
        Equipement equipement = equipmentService.findByPersoId(id);
        List<Weapon> weapons = equipmentService.findAllWeapon(equipement.getId());
        List<Armour> armours = equipmentService.findAllArmour(equipement.getId());
        model.addAttribute("weapons",weapons);
        model.addAttribute("armours",armours);
        return "equipView";
    }

    @PostMapping("/saveStat")
    public String saveStat(@ModelAttribute("stat")Stat stat, Model model){
        statService.saveStat(stat);
        model.addAttribute("stat",stat);
        return "/statView";
    }

    @GetMapping("/raceInfo/{race}")
    public String showRaceInfo(@PathVariable(value = "race") String race, Model model){
        model.addAttribute("race", raceService.findByLabel(race));
        return "/raceInfo";
    }

    @GetMapping("/enterSession")
    public String enterSession(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findUserByEmail(authentication.getName());
        List<Personnage> personnages = persoService.findAllByUser(user.getId());
        model.addAttribute("persos",personnages);
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions",sessions);
        Personnage personnage = new Personnage();
        Session session = new Session();
        model.addAttribute("sessionE",session);
        model.addAttribute("persoP",personnage);
        return "enterSession";
    }
    @PostMapping("/session/enter")
    public String sessionE(@ModelAttribute(value = "sessionE") Session sessionE, @ModelAttribute(value = "persoP") Personnage persoP, Model model){
        Session session = sessionService.findBySName(sessionE.getSName());
        Personnage personnage = persoService.findByName(persoP.getName());
        personnage.setSession(session);
        persoService.savePerso(personnage);
        return "redirect:/userHomepage?create";
    }
}