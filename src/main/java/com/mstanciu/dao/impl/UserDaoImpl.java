package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<User> getUserByEmail(String email) {
		String hql = "FROM User E WHERE E.email = :user_email";
		Query query = session.getCurrentSession().createQuery(hql);
		query.setParameter("user_email", email);
		return query.list();
	}

	@Override
	public User getUserByAge(int age) {
		String sql = "FROM user U WHERE U.age = " + age;
		Query query = (Query) session.getCurrentSession().createCriteria(sql);
		List<?> result = query.list();
		return (User) result.remove(0);
	}

	@Override
	public boolean login(String email, String password) {
		Criteria cr = session.getCurrentSession().createCriteria(User.class);

		Criterion emailCr = Restrictions.eq("email", email);
		Criterion pwdCr = Restrictions.eq("password", password);

		// To get records matching with OR conditions
		LogicalExpression orExp = Restrictions.and(emailCr, pwdCr);
		cr.add(orExp);

		List results = cr.list();
		if (results.isEmpty()) {
			return false;
		}

		return true;
	}

}
