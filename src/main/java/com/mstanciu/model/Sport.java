package com.mstanciu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sport")
public class Sport {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_sport;

	@Column
	private String sport_name;

	public Sport() {
	}

	public int getId_sport() {
		return id_sport;
	}

	public void setId_sport(int id_sport) {
		this.id_sport = id_sport;
	}

	public String getSport_name() {
		return sport_name;
	}

	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}

}
