package com.tapsintown.controllers;

import com.tapsintown.SecurityConfiguration;
import com.tapsintown.interfaces.Roles;
import com.tapsintown.interfaces.SavedEvents;
import com.tapsintown.interfaces.Users;
import com.tapsintown.models.SaveEvent;
import com.tapsintown.models.User;
import com.tapsintown.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
@RequestMapping("/user")
public class UsersController extends BaseController{

    @Autowired
    private Users userDao;

    @Autowired
    private SavedEvents savedEventsDao;

    @Autowired
    private Roles rolesDao;

    @GetMapping("/me")
    public String loginRedirect(Model model){
        User loggedInUser = loggedInUser();
        return "redirect:/user/" + loggedInUser.getId();

    }

    @GetMapping("/register")
    public String showRegisterForm (Model m){
        m.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String createNewUser(@Valid User userCreated, Errors validation, Model m){
        System.out.println("Password: " + userCreated.getPassword());
        if(validation.hasErrors()){
            m.addAttribute("errors", validation);
            m.addAttribute("user", userCreated);
          return "/register";
        }

        User newUser = userDao.save(userCreated);
        UserRole newRole = new UserRole(newUser.getId());
        SecurityConfiguration sc = new SecurityConfiguration();
        userCreated.setPassword(sc.passwordEncoder().encode(userCreated.getPassword()));
        userCreated.setUserRole(newRole);
        rolesDao.save(newRole);
        userDao.save(userCreated);

        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String getUserId(@PathVariable long id, Model m){

        User loggedInUser = userDao.findByUsername(loggedInUser().getUsername());

        m.addAttribute("user", userDao.findOne(id));
        m.addAttribute("savedEvents", savedEventsDao.findByUserId(id));


        m.addAttribute("isAdmin", "admin".equalsIgnoreCase(loggedInUser.getUserRole().getRole()));

        return "userprofile";
    }

    @PostMapping("/delete/{id}")
    public String deleteUserEvent(@PathVariable long id){
        SaveEvent saveEvent = savedEventsDao.findOne(id);
        savedEventsDao.delete(saveEvent);

        return "redirect:/user/" + loggedInUser().getId();
    }


}
