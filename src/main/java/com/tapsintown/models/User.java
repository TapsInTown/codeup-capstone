package com.tapsintown.models;

import com.tapsintown.SecurityConfiguration;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int isAdmin;

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
        SecurityConfiguration sc = new SecurityConfiguration();
        this.password = sc.passwordEncoder().encode(password);
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
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
