package com.tapsintown.controllers;

import com.tapsintown.interfaces.Events;
import com.tapsintown.models.Event;
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
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private Events eventsDao;

    @GetMapping("/create")
    public String showCreateEventForm(Model m){
        m.addAttribute("event", new Event());
        return "/events";
    }

    @PostMapping("/create")
    public String createNewEvent(@ModelAttribute Event eventCreated){
        eventsDao.save(eventCreated);
        return "/events";
    }

}
