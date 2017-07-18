package com.mstanciu.dao;

import java.util.List;

import com.mstanciu.model.User;

public interface UserDao {
	
	public void add(User u);
	public void edit(User u);
	public void delete(int userId);
	public User getUser(int user);
	public List<User> getAllUsers();

}
