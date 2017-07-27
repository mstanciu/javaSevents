package com.mstanciu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_friend", schema = "sevents")
public class User_friend {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_entrance;

	@Column
	private int id_user;

	@Column
	private int id_friend;

	@Column
	private int pending;

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getId_entrance() {
		return id_entrance;
	}

	public void setId_entrance(int id_entrance) {
		this.id_entrance = id_entrance;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_friend() {
		return id_friend;
	}

	public void setId_friend(int id_friend) {
		this.id_friend = id_friend;
	}

}
