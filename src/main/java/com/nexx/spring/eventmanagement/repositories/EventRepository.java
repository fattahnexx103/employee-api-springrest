package com.nexx.spring.eventmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nexx.spring.eventmanagement.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
