package com.tapsintown.controllers;


import com.tapsintown.interfaces.EventImages;
import com.tapsintown.interfaces.Events;
import com.tapsintown.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
public class ProfileController extends BaseController{

    @Autowired
    private Events eventsDao;

    @Autowired
    private EventImages imagesDao;

//    @Autowired
//    private EventLocations locationsDao;

    @GetMapping("/")
    public String showHomePage(Model m){

        List<Event> events = new ArrayList((Collection) eventsDao.findAll());

//        List<EventImage> eventImages = new ArrayList<>(imagesDao.findByEventId(id));
        for ( Event event: events) {
            event.pics = imagesDao.findByEventId(event.getId());
        }

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });

        m.addAttribute("events", events);
        return "home";
    }

    @GetMapping("/profile")
    public String showProfilePage(){
        return "/profile";
    }

    @GetMapping("/about-us")
    public String showAboutUsPage(){
        return"aboutus";
    }

}
