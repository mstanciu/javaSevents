package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.User_friendDao;
import com.mstanciu.model.User;

@Repository
public class User_friendDaoImpl implements User_friendDao {

	@Autowired
	private SessionFactory session;

	@Override
	public List<User> getAllFriends(int id_user) {
		String hql = "Select U.id_user, U.age, U.gender, U.firstName, U.lastName FROM com.mstanciu.model.User U, com.mstanciu.model.User_friend UF WHERE U.id_user = UF.id_user AND UF.id_user = "
				+ id_user;
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}
}
