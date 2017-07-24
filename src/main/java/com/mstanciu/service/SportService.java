package com.mstanciu.service;

import java.util.List;

import com.mstanciu.model.Sport;

public interface SportService {

	public void add(Sport s);

	public void edit(Sport s);

	public void delete(int sport_id);

	public Sport getSport(int user);

	public List<Sport> getAllSports();

}
