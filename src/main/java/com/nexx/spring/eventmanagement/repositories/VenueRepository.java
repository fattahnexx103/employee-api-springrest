package com.nexx.spring.eventmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nexx.spring.eventmanagement.entities.Event;
import com.nexx.spring.eventmanagement.entities.Participant;

public interface VenueRepository extends CrudRepository<Participant, Long> {

}
