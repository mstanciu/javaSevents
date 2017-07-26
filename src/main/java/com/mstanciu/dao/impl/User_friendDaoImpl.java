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
		String hql = "select Z.id_user, Z.age, Z.gender, Z.firstName, Z.lastName from com.mstanciu.model.User Z "
				+ "where Z.id_user in (select F.id_friend "
				+ "from com.mstanciu.model.User U,com.mstanciu.model.User_friend F "
				+ "where U.id_user = F.id_user and U.id_user =" + id_user + ")";
		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public int unfriend(int id_user, int id_friend) {
		String hql = "delete from com.mstanciu.model.User_friend E "
				+ "where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_user + " and E.id_friend = " + id_friend + ")";
		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}
}
