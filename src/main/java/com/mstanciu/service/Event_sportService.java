package com.mstanciu.service;

import java.util.List;

import com.mstanciu.model.Event;

public interface Event_sportService {

	public List<Event> getSpecificEvent(int id_sport);
}
