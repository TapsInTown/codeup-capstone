package com.tapsintown.interfaces;

import com.tapsintown.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/18/17.
 */
public interface Roles extends CrudRepository<Role, Long> {
}
