package com.tapsintown.interfaces;

import com.tapsintown.models.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anthonyfortney on 1/17/17.
 */

@Repository
public interface Events extends PagingAndSortingRepository<Event, Long> {
    List<Event> findByEventLocationId(long id);

    Page<Event> findAll(Pageable pageable);
}
