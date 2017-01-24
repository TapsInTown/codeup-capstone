package com.tapsintown.interfaces;

import com.tapsintown.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */
public interface Events extends CrudRepository<Event, Long> {
    List<Event> findByEventLocationId(long id);
}
