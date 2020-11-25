package com.nexx.spring.eventmanagement.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nexx.spring.eventmanagement.entities.Participant;

public interface VenueRepository extends PagingAndSortingRepository<Participant, Long> {

}
