package com.tapsintown.interfaces;

import com.tapsintown.models.Event;
import com.tapsintown.models.EventLocation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface EventLocations extends CrudRepository<EventLocation, Long> {
    EventLocation findByName(String name);

}
