package com.mstanciu.service;

import java.util.List;

import com.mstanciu.model.User;

public interface UserService {
	public void add(User u);

	public void edit(User u);

	public void delete(int userId);

	public User getUser(int userId);

	public List<User> getUserByEmail(String email);

	public User getUserByAge(int age);

	public List<User> getAllUsers();

	public User login(String email, String password);

}
