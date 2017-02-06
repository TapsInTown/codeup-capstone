package com.tapsintown.controllers;


import com.tapsintown.interfaces.EventImages;
import com.tapsintown.interfaces.Events;
import com.tapsintown.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String showHomePage(Model m, @PageableDefault(value = 7, sort = "eventDate", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Event> pages = eventsDao.findAll(pageable);

//        List<EventImage> eventImages = new ArrayList<>(imagesDao.findByEventId(id));
        for ( Event event: pages) {
            event.pics = imagesDao.findByEventId(event.getId());
        }
        m.addAttribute("pages", pages);
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
