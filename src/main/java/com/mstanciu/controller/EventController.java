package com.mstanciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mstanciu.model.Event;
import com.mstanciu.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = { "/account/events" }, method = RequestMethod.GET)
	public List<Event> getAllEvents(ModelMap map) {
		return eventService.getAllEvents();

	}
}
