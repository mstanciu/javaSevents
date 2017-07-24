package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.Event_sportDao;
import com.mstanciu.model.Event;

@Repository
public class Event_sportDaoImpl implements Event_sportDao {

	@Autowired
	private SessionFactory session;

	@Override
	public List<Event> getSpecificEvent(int id_sport) {
		String hql = "Select E.name, E.location, E.date, E.attendence FROM com.mstanciu.model.Event E, com.mstanciu.model.Event_sport ES WHERE E.id_event = ES.event_id AND ES.sport_id = "
				+ id_sport;
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}
}
