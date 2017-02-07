package com.tapsintown.controllers;

import com.tapsintown.SecurityConfiguration;
import com.tapsintown.interfaces.Roles;
import com.tapsintown.interfaces.SavedEvents;
import com.tapsintown.interfaces.Users;
import com.tapsintown.models.SaveEvent;
import com.tapsintown.models.User;
import com.tapsintown.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by anthonyfortney on 1/18/17.
 */

@Controller
@RequestMapping("/user")
public class UsersController extends BaseController{

    @Autowired
    private Users userDao;

    @Autowired
    private SavedEvents savedEventsDao;

    @Autowired
    private Roles rolesDao;

    @GetMapping("/me")
    public String loginRedirect(Model model){
        User loggedInUser = loggedInUser();
        return "redirect:/user/" + loggedInUser.getId();

    }

    @GetMapping("/register")
    public String showRegisterForm (Model m){
        m.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String createNewUser(@Valid User userCreated,
                                Errors validation,
                                Model m,
                                @RequestParam(name = "confirmPassword")String confirmPassword) {

        if (!userCreated.getPassword().equals(confirmPassword)){
            m.addAttribute("errors", validation);
            m.addAttribute("user", userCreated);
            m.addAttribute("passwordMatch", "Passwords must match");
            return "/register";
        }
        if(validation.hasErrors()){
            m.addAttribute("errors", validation);
            m.addAttribute("user", userCreated);
          return "/register";
        }

        User newUser = userDao.save(userCreated);

        UserRole newRole = new UserRole(newUser.getId());

        SecurityConfiguration sc = new SecurityConfiguration();
        userCreated.setPassword(sc.passwordEncoder().encode(userCreated.getPassword()));

        userCreated.setUserRole(newRole);
        rolesDao.save(newRole);
        userDao.save(userCreated);

        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String getUserId(@PathVariable long id, Model m){

        User loggedInUser = userDao.findOne(id);

        m.addAttribute("user", loggedInUser);
        m.addAttribute("savedEvents", savedEventsDao.findByUserId(id));

        System.out.println("trying to bring up user profile...");

//        System.out.println(loggedInUser + " is the logged in in user");
//        System.out.println(loggedInUser.getUserRole() + " logged in user and user role");
//        System.out.println("I am a " + loggedInUser.getUserRole().getRole());


        m.addAttribute("isAdmin", "admin".equalsIgnoreCase(loggedInUser.getUserRole().getRole()));

        System.out.println("You see yourself! YAY");

        return "userprofile";

    }

    @GetMapping("/{id}/edit")
    public String showUserEditForm(@PathVariable long id, Model m){
        m.addAttribute("user", userDao.findOne(id));
        return "edituser";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(User existingUser){

        User currentDetails = userDao.findOne(existingUser.getId());
        SecurityConfiguration sc = new SecurityConfiguration();

        String newName = existingUser.getName();
        String newEmail = existingUser.getEmail();
        String newUsername = existingUser.getUsername();
        String newPassword = existingUser.getPassword();

        currentDetails.setName(newName);
        currentDetails.setEmail(newEmail);
        currentDetails.setUsername(newUsername);
        currentDetails.setPassword(sc.passwordEncoder().encode(newPassword));

        userDao.save(currentDetails);
        System.out.println("saved new information to database");
        return "redirect:/user/" + loggedInUser().getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteUserEvent(@PathVariable long id){
        SaveEvent saveEvent = savedEventsDao.findOne(id);
        savedEventsDao.delete(saveEvent);

        return "redirect:/user/" + loggedInUser().getId();
    }


}
