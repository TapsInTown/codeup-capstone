package com.tapsintown.controllers;

import com.tapsintown.interfaces.EventLocations;
import com.tapsintown.models.EventLocation;
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
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private EventLocations eventsDao;

    @GetMapping("/create")
    public String showCreateLocationForm(Model m){
        m.addAttribute("location", new EventLocation());
        return "/locations";
    }

    @PostMapping("/create")
    public String createNewLocation(@ModelAttribute EventLocation locationCreated){
        eventsDao.save(locationCreated);
        return "/locations";
    }

}
