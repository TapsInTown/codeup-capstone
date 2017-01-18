package com.tapsintown.interfaces;

import com.tapsintown.models.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface Images extends CrudRepository<Image, Long> {
}
