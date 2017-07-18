package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.UserDao;
import com.mstanciu.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(User u) {
		session.getCurrentSession().save(u);
	}

	@Override
	public void edit(User u) {
		session.getCurrentSession().update(u);
	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUser(userId));
	}
	
	public User getUser(int userId) {
		return (User) session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public List<User> getAllUsers() {
		return session.getCurrentSession().createCriteria(User.class).list();
	}

}
