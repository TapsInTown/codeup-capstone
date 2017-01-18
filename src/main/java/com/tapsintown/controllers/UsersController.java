package com.tapsintown.controllers;


import com.tapsintown.interfaces.Users;
import com.tapsintown.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private Users userDao;

    @GetMapping("/register")
    public String showRegisterForm (Model m){
        m.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String createNewUser(@ModelAttribute User userCreated){
        userDao.save(userCreated);
        return "redirect:/login";
    }




}
