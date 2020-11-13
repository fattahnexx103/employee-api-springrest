package com.nexx.spring.eventmanagement.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass // Since this is super class which other entitites extend from
public class AbstractEntity {

	@Id // primary key
	@Column(nullable = false, updatable = false) // id cannot be null or updatable
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto update of id

	protected long id;

	@CreationTimestamp // for timestamp purposes
	@Column(updatable = false) // since we don't want to change time, we make updatable = false
	protected Instant created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

}
