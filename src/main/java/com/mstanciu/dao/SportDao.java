package com.mstanciu.dao;

import java.util.List;

import com.mstanciu.model.Sport;

public interface SportDao {

	public void add(Sport s);

	public void edit(Sport s);

	public void delete(int sport_id);

	public Sport getSport(int user);

	public List<Sport> getAllSports();

}
