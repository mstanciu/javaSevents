package com.mstanciu.dao;

import java.util.List;

import com.mstanciu.model.Event;

public interface Event_sportDao {

	public List<Event> getSpecificEvent(int id_sport);

}
