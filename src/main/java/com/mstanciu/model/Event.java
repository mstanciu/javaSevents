package com.mstanciu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO) // for auto-number
	private int id_event;

	@Column
	private String name;

	@Column
	private String location;

	@Column
	private String date;

	@Column
	private int attendence;

	public Event() {
	}

	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAttendence() {
		return attendence;
	}

	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}

	@Override
	public String toString() {
		return "Event [id_event=" + id_event + ", name=" + name + ", location=" + location + ", date=" + date
				+ ", attendence=" + attendence + "]";
	}

}
