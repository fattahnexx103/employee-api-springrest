package com.nexx.spring.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexx.spring.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
import com.nexx.spring.eventmanagement.entities.Participant;
import com.nexx.spring.eventmanagement.repositories.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {
	
	@Autowired
	private ParticipantRepository participantRepository;

	//Take a id and check in the participant
	//Path will be POST @ /events/checkin/{id}
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
		
		//the assembler converts entities into HAL objects since we want to return a HAL object as response.
		Participant participant = participantRepository.findById(id).get();
		
		if(participant != null) {
			//participant is already registered so see if participant checked in
			if(participant.getCheckedIn()) {
				throw new AlreadyCheckedInException(); //return our own custom excpetion
			}
			
			participant.setCheckedIn(true); //check in the participant
			participantRepository.save(participant); 
		}
		
		//return the HAL object which uses to Full Resource to convert the participant to PersistentEntityResource
		return ResponseEntity.ok(assembler.toFullResource(participant));
	}
}
