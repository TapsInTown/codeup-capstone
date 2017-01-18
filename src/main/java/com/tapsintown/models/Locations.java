package com.tapsintown.models;

import com.tapsintown.models.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface Locations extends CrudRepository<Location, Long> {
}
