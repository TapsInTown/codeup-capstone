package com.tapsintown.controllers;

import com.tapsintown.interfaces.Events;
import com.tapsintown.interfaces.SavedEvents;
import com.tapsintown.models.Event;
import com.tapsintown.models.SaveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
@RequestMapping("/events")
public class EventsController extends BaseController {

    @Autowired
    private Events eventsDao;

    @Autowired
    private SavedEvents saveDao;


    @GetMapping
    public String getEvents(Model m){
        m.addAttribute("event", eventsDao.findAll());
        return "event/events";
    }

    @GetMapping("/create")
    public String showCreateEventForm(Model m){
        m.addAttribute("event", new Event());
        return "event/createevent";
    }

    @PostMapping("/create")
    public String createNewEvent(@ModelAttribute Event eventCreated){
        eventsDao.save(eventCreated);
        return "redirect:/events";
    }

    @GetMapping("/{id}")
    public String showEventDetails(@PathVariable long id, Model m){
        m.addAttribute("event", eventsDao.findOne(id));
        return "event/eventdetails";
    }

    @GetMapping("/{id}/edit")
    public String showEditform(@PathVariable long id, Model m){
        m.addAttribute("event", eventsDao.findOne(id));
        return "event/editevent";
    }


    @PostMapping("/{id}/edit")
    public String updateEvent(Event existingEvent){
        Event currentDetails = eventsDao.findOne(existingEvent.getId());
        String newTitle = existingEvent.getTitle();
        String newDate = existingEvent.getEventDate();
        String newDescription = existingEvent.getDescription();

        currentDetails.setTitle(newTitle);
        currentDetails.setEventDate(newDate);
        currentDetails.setDescription(newDescription);

        eventsDao.save(currentDetails);
        return "redirect:/events";

    }

    @PostMapping("/save/{id}")
    public String saveEvent(@PathVariable long id){
        if (!isLoggedIn()){
            return "redirect:/login";
        }

        Event events = eventsDao.findOne(id);
        SaveEvent saveEvent = new SaveEvent();

        saveEvent.setEvent(events);
        saveEvent.setUser(loggedInUser());

        saveDao.save(saveEvent);
        return "redirect:/user/"+ loggedInUser().getId();
    }


}
