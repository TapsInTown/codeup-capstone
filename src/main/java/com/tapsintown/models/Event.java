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

    @Column(nullable = false)
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

    @OneToMany(mappedBy = "event")
    private List<EventLocation> locations;

// Relationship to EventImages
// one Event to many EventImages

    @OneToMany (mappedBy = "event")
    private List<EventImage> images;

// Relationship to SavedEvents
// one Event to many SavedEvents

    @OneToMany (mappedBy = "event")
    private List<SavedEvents> savedEvents;

//  Getters and setters

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
