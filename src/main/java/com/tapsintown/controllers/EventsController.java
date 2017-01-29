package com.tapsintown.controllers;

import com.tapsintown.interfaces.EventLocations;
import com.tapsintown.interfaces.Events;
import com.tapsintown.interfaces.SavedEvents;
import com.tapsintown.interfaces.Users;
import com.tapsintown.models.Event;
import com.tapsintown.models.SaveEvent;
import com.tapsintown.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @Autowired
    private EventLocations locationDao;

    @Autowired
    private Users usersDao;


    @GetMapping
    public String getEvents(Model m){
        List<Event> events = new ArrayList((Collection) eventsDao.findAll());
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });
        m.addAttribute("events", events);
        return "event/events";
    }

    @GetMapping("/create")
    public String showCreateEventForm(Model m){
        m.addAttribute("event", new Event());
        m.addAttribute("locations", locationDao.findAll());
        return "event/createevent";
    }

    @PostMapping("/create")
    public String createNewEvent(@ModelAttribute Event eventCreated, @RequestParam(name="locationId") String name){
        eventCreated.setEventLocation(locationDao.findByName(name));
        eventCreated.setUser(loggedInUser());
        eventsDao.save(eventCreated);
        return "redirect:/location";
    }

    @GetMapping("/{id}")
    public String showEventDetails(@PathVariable long id, Model m){

        boolean isAdmin = false;

        if(isLoggedIn()){
            User loggedInUser = usersDao.findByUsername(loggedInUser().getUsername());
            isAdmin = "admin".equalsIgnoreCase(loggedInUser.getUserRole().getRole());
        }

        m.addAttribute("event", eventsDao.findOne(id));
        m.addAttribute("loggedIn", isLoggedIn());
        m.addAttribute("isAdmin", isAdmin);
        return "event/eventdetails";
    }

    @GetMapping("/{id}/edit")
    public String showEditform(@PathVariable long id, Model m){
        m.addAttribute("event", eventsDao.findOne(id));
        m.addAttribute("locations", locationDao.findAll());
        return "event/editevent";
    }


    @PostMapping("/{id}/edit")
    public String updateEvent(Event existingEvent, @RequestParam(name="locationId") String name){
        Event currentDetails = eventsDao.findOne(existingEvent.getId());
        existingEvent.setEventLocation(locationDao.findByName(name));

        String newTitle = existingEvent.getTitle();
        String newDate = existingEvent.getEventDate();
        String newTime = existingEvent.getEventTime();
        String newDescription = existingEvent.getDescription();

        currentDetails.setTitle(newTitle);
        currentDetails.setEventDate(newDate);
        currentDetails.setEventTime(newTime);
        currentDetails.setDescription(newDescription);

        eventsDao.save(currentDetails);
        return "redirect:/location";

    }

    @GetMapping("/{id}/delete")
    public String deleteEvents(@PathVariable long id){
        eventsDao.delete(id);
        return "redirect:/location";

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
