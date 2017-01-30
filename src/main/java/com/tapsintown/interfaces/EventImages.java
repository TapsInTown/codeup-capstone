package com.tapsintown.interfaces;

import com.tapsintown.models.EventImage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface EventImages extends CrudRepository<EventImage, Long> {
    List<EventImage> findByEventId(long id);
}
