package com.tapsintown.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "event_date")
    private String eventDate;

    @Column(nullable = false, length = 1000)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

//  Relationship to User
//  many events to one user

    @ManyToOne
    private User user;

//Relationship to EventLocations;
//One location to many events

    @ManyToOne
    private EventLocation eventLocation;

// Relationship to EventImages
// one Event to many EventImages

    @OneToMany (mappedBy = "event")
    private List<EventImage> images;

// Relationship to SaveEvent
// one Event to many SaveEvent

    @OneToMany (mappedBy = "event")
    private List<SaveEvent> savedEvents;

//  Getters and setters


    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<EventImage> getImages() {
        return images;
    }

    public void setImages(List<EventImage> images) {
        this.images = images;
    }

    public List<SaveEvent> getSavedEvents() {
        return savedEvents;
    }

    public void setSavedEvents(List<SaveEvent> savedEvents) {
        this.savedEvents = savedEvents;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifyDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifyDate = modifiedDate;
    }




}
