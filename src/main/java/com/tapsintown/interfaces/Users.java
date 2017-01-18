package com.tapsintown.interfaces;

import com.tapsintown.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/17/17.
 */
public interface Users extends CrudRepository<User, Long> {
}
