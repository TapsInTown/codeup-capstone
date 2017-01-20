package com.tapsintown.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
public class EventsController {
    @GetMapping("/event")
    public String showEvents(){
        return "/event";

    }
}
