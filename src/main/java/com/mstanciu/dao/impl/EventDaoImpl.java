package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.EventDao;
import com.mstanciu.model.Event;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(Event e) {
		session.getCurrentSession().save(e);
	}

	@Override
	public void edit(Event e) {
		session.getCurrentSession().update(e);
	}

	@Override
	public void delete(int eventId) {
		session.getCurrentSession().delete(getEvent(eventId));
	}

	@Override
	public Event getEvent(int eventId) {
		return (Event) session.getCurrentSession().get(Event.class, eventId);
	}

	@Override
	public List<Event> getAllEvents() {
		return session.getCurrentSession().createCriteria(Event.class).list();
	}

}
