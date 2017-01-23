package com.tapsintown.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(){
        return "/profile";
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }
}
