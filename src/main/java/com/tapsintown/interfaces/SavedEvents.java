package com.tapsintown.interfaces;

import com.tapsintown.models.Event;
import com.tapsintown.models.SaveEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anthonyfortney on 1/20/17.
 */
public interface SavedEvents extends CrudRepository<SaveEvent, Long>{
    List<SaveEvent> findByUserId(long id);
}
