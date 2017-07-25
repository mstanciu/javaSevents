package com.mstanciu.service;

import java.util.List;

import com.mstanciu.model.User;

public interface User_friendService {
	public List<User> getAllFriends(int id_user);
}
