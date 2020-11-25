package com.nexx.spring.eventmanagement.repositories;

import java.time.ZoneId;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nexx.spring.eventmanagement.entities.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	//finding a resource object by name 
	//have to do GET @ localhost:8080/events/search/findByName?=YourNameHere
	List<Event> findByName(@Param("name") String name);
	
	//To return a page instead of a list simply do this
	//have to do GET @ localhost:8080/events/search/findByName?=YourNameHere
	Page<Event> findByName(@Param("name") String name, Pageable pageable);
	
	//to find resource using multiple resources
	//have to do GET @ localhost:8080/events/search/findByNameAndZoneId?name=YourNameHere&zoneId=YourZoneId
	List<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId);

}