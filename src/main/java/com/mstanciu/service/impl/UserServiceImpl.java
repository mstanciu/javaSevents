package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.UserDao;
import com.mstanciu.model.User;
import com.mstanciu.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void add(User u) {
		userDao.add(u);
	}

	@Override
	public void edit(User u) {
		userDao.edit(u);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Override
	public User getUser(int user) {
		return userDao.getUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
