package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.SportDao;
import com.mstanciu.model.Sport;

@Repository
public class SportDaoImpl implements SportDao {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(Sport s) {
		session.getCurrentSession().save(s);
	}

	@Override
	public void edit(Sport s) {
		session.getCurrentSession().update(s);
	}

	@Override
	public void delete(int sport_id) {
		session.getCurrentSession().delete(getSport(sport_id));
	}

	@Override
	public Sport getSport(int sport_id) {
		return (Sport) session.getCurrentSession().get(Sport.class, sport_id);
	}

	@Override
	public List<Sport> getAllSports() {
		return session.getCurrentSession().createCriteria(Sport.class).list();
	}

}
