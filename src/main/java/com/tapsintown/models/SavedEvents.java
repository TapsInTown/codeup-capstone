package com.tapsintown.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonyfortney on 1/20/17.
 */

@Entity
@Table(name = "saved_events")
public class SavedEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

}
