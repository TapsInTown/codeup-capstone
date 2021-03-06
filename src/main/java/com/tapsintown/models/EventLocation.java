package com.tapsintown.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */
@Entity
@Table(name = "event_locations")
public class EventLocation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, name = "street_number")
    private long streetNumber;

    @Column(nullable = false, name = "street_name")
    private String streetName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private long zip;

    @Column(nullable = false, length = 2500, name = "the_brew")
    private String descriptionTheBrew;

    @Column(nullable = false, length = 2500, name = "about_them")
    private String descriptionAboutThem;


//Relationship to Event
//Many Events to one location

    @OneToMany (mappedBy = "eventLocation")
    private List<Event> events;


    //getters and setters


    public String getDescriptionTheBrew() {
        return descriptionTheBrew;
    }

    public void setDescriptionTheBrew(String descriptionTheBrew) {
        this.descriptionTheBrew = descriptionTheBrew;
    }

    public String getDescriptionAboutThem() {
        return descriptionAboutThem;
    }

    public void setDescriptionAboutThem(String descriptionAboutThem) {
        this.descriptionAboutThem = descriptionAboutThem;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }


}
