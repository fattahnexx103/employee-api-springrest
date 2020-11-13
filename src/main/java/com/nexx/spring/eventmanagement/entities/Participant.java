package com.nexx.spring.eventmanagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participant extends AbstractEntity {

	//Need to create name and email
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	private Boolean checkedIn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = false,updatable = false) //Event column is associated with ID e.g event_id
	private Event event;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Participant) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
