package com.tapsintown.controllers;

import com.tapsintown.interfaces.EventLocations;
import com.tapsintown.interfaces.Events;
import com.tapsintown.models.Event;
import com.tapsintown.models.EventLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private EventLocations locationDao;

    @Autowired
    private Events eventsDao;

    @GetMapping
    public String getLocations(Model m) {
        m.addAttribute("location", locationDao.findAll());
        return "location/location";
    }

    @GetMapping("/create")
    public String showCreateLocationForm(Model m){
        m.addAttribute("location", new EventLocation());
        return "location/createlocation";
    }

    @PostMapping("/create")
    public String createNewLocation(@Valid EventLocation locationCreated){
        locationDao.save(locationCreated);
        return "redirect:/location";
    }

    @GetMapping("/{id}")
    public String showLocationDetails(@PathVariable long id, Model m){

        List<Event> events = new ArrayList((Collection) eventsDao.findByEventLocationId(id));

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });
        m.addAttribute("location", locationDao.findOne(id));
        m.addAttribute("events", events );
        return "profile";
    }

    @GetMapping("/{id}/edit")
    public String showEditLocationForm(@PathVariable long id, Model m){
        m.addAttribute("location", locationDao.findOne(id));
        return "location/editlocation";
    }

    @PostMapping("/{id}/edit")
    public String updateLocation(EventLocation editedLocation, Model m){

        EventLocation currentDetails = locationDao.findOne(editedLocation.getId());
        String newName = editedLocation.getName();
        Long newStreetNum = editedLocation.getStreetNumber();
        String newStreetName = editedLocation.getStreetName();
        String newCity = editedLocation.getCity();
        String newState = editedLocation.getState();
        Long newZip = editedLocation.getZip();

        currentDetails.setName(newName);
        currentDetails.setStreetNumber(newStreetNum);
        currentDetails.setStreetName(newStreetName);
        currentDetails.setCity(newCity);
        currentDetails.setState(newState);
        currentDetails.setZip(newZip);

        locationDao.save(currentDetails);
        return "redirect:/location";
    }

    @GetMapping("/{id}/delete")
    public String deleteLocation(@PathVariable long id){
        locationDao.delete(id);
        return "redirect:/location";
    }
}
