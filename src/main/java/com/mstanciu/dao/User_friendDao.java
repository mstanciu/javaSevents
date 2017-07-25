package com.mstanciu.dao;

import java.util.List;

import com.mstanciu.model.User;

public interface User_friendDao {

	public List<User> getAllFriends(int id_user);

}
