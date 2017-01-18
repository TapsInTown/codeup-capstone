package com.tapsintown.interfaces;

import com.tapsintown.models.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/17/17.
 */
public interface Events extends CrudRepository<Event, Long> {
}
