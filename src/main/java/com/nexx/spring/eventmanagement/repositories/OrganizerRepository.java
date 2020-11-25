package com.nexx.spring.eventmanagement.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nexx.spring.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
