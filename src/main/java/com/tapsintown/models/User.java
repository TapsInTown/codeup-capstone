package com.tapsintown.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */
@Entity
@Table(name = "users")
public class User {

//  Generate Table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "Names can have no less than 2 characters.")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Must be a valid Email address")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Please enter your Username.")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 5, message = "Password must have at least 5 Characters")
    @Column(nullable = false)
    private String password;


//  Relationship to role
//  one user to one user_role

    @OneToOne
    private UserRole userRole;

// Relationship to Event
//  one user to many events

    @OneToMany(mappedBy = "user")
    private List <Event> events;

// Relationship to SaveEvent
// one user to many SaveEvent

    @OneToMany(mappedBy = "user")
    private List<SaveEvent> savedEvents;

// Constructor

    public User() {
    }

    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
    }

// Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<SaveEvent> getSavedEvents() {
        return savedEvents;
    }

    public void setSavedEvents(List<SaveEvent> savedEvents) {
        this.savedEvents = savedEvents;
    }
}
