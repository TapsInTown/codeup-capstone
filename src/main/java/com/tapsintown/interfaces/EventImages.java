package com.tapsintown.interfaces;

import com.tapsintown.models.EventImage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface EventImages extends CrudRepository<EventImage, Long> {
}
