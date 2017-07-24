package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.SportDao;
import com.mstanciu.model.Sport;
import com.mstanciu.service.SportService;

@Service
@Transactional
public class SportServiceImpl implements SportService {

	@Autowired
	private SportDao sportDao;

	@Override
	public void add(Sport s) {
		sportDao.add(s);
	}

	@Override
	public void edit(Sport s) {
		sportDao.edit(s);
	}

	@Override
	public void delete(int sport_id) {
		sportDao.delete(sport_id);
	}

	@Override
	public Sport getSport(int sport_id) {
		return sportDao.getSport(sport_id);
	}

	@Override
	public List<Sport> getAllSports() {
		return sportDao.getAllSports();
	}

}
