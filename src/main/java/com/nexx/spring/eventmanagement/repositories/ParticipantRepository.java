package com.nexx.spring.eventmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nexx.spring.eventmanagement.entities.Event;
import com.nexx.spring.eventmanagement.entities.Participant;
import com.nexx.spring.eventmanagement.entities.Venue;

public interface ParticipantRepository extends CrudRepository<Venue, Long> {

}
