package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.EventDao;
import com.mstanciu.model.Event;
import com.mstanciu.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public void add(Event u) {
		eventDao.add(u);

	}

	@Override
	public void edit(Event u) {
		eventDao.edit(u);
	}

	@Override
	public void delete(int userId) {
		eventDao.delete(userId);
	}

	@Override
	public Event getEvent(int user) {
		return eventDao.getEvent(user);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

}
