package com.mstanciu.service;

import java.util.List;

import com.mstanciu.model.Event;

public interface EventService {
	public void add(Event u);

	public void edit(Event u);

	public void delete(int userId);

	public Event getEvent(int user);

	public List<Event> getAllEvents();

}
