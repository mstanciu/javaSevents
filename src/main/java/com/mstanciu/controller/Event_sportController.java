package com.mstanciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mstanciu.model.Event;
import com.mstanciu.model.Event_sport;
import com.mstanciu.service.Event_sportService;

@RestController
public class Event_sportController {

	@Autowired
	private Event_sportService ess;

	@RequestMapping(value = { "/account/events/id" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<Event> getSpecificEvents(@RequestBody Event_sport evsp, UriComponentsBuilder ucBuilder) {
		List<Event> results = ess.getSpecificEvent(evsp.getSport_id());
		return results;
	}
}
