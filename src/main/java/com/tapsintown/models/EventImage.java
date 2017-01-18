package com.tapsintown.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */

@Entity
@Table(name = "event_images")
public class EventImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "image_url")
    private String imageUrl;

// Relationship to Event
// Many images to one Event
    @ManyToOne
    private Event event;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
