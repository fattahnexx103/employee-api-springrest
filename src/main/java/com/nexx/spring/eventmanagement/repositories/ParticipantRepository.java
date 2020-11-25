package com.nexx.spring.eventmanagement.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nexx.spring.eventmanagement.entities.Venue;

import java.util.List;

public interface ParticipantRepository extends PagingAndSortingRepository<Venue, Long> {

}
