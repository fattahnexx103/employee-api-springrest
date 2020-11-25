package com.nexx.spring.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexx.spring.eventmanagement.entities.Event;
import com.nexx.spring.eventmanagement.repositories.EventRepository;

@RepositoryRestController //Controller should be part of Spring Rest controller
@RequestMapping("/events") //when you go to this path, the method gets executed
public class EventKickoffController {

	@Autowired
	private EventRepository eventRepository;
	
	//when we do a post request to /events/start/{id}, method below gets executed.
	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		
		//find the event using id and then sets its started property to true
		Event event = eventRepository.findById(id).get();
		
		if(event == null) {
			throw new ResourceNotFoundException();
		}
		
		//if we find the event
		event.setStarted(true);
		eventRepository.save(event); //save the event to the repository
		
		//return the response 
		return ResponseEntity.ok(event.getName() + " has started"); //you can also return a json object
	}
}
