package com.tapsintown.controllers;




import com.tapsintown.interfaces.EventLocations;
import com.tapsintown.interfaces.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.stream.Location;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
public class ProfileController extends BaseController{

    @Autowired
    private Events eventsDao;

//    @Autowired
//    private EventLocations locationsDao;

    @GetMapping("/profile")
    public String showProfilePage(){
        return "/profile";
    }

    @GetMapping("/home")
    public String showHomePage(Model m){
        m.addAttribute("events", eventsDao.findAll());
//
        return "home";
    }
}
