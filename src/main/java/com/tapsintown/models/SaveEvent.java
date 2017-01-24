package com.tapsintown.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonyfortney on 1/20/17.
 *
 * This is the model for the user to be able to save an event to there profile page
 */

@Entity
@Table(name = "saved_events")
public class SaveEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
