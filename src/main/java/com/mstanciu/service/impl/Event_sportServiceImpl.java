package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.Event_sportDao;
import com.mstanciu.model.Event;
import com.mstanciu.service.Event_sportService;

@Service
@Transactional
public class Event_sportServiceImpl implements Event_sportService {

	@Autowired
	private Event_sportDao ess;

	@Override
	public List<Event> getSpecificEvent(int id_sport) {
		return ess.getSpecificEvent(id_sport);
	}
}
