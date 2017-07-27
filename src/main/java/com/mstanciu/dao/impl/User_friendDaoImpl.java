package com.mstanciu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstanciu.dao.User_friendDao;
import com.mstanciu.model.User;
import com.mstanciu.model.User_friend;

/**
 * 
 * @author MStanciu 0 - refused 1 - accepted 2 - pending 3 - init 4 - canceled
 */
@Repository
public class User_friendDaoImpl implements User_friendDao {

	@Autowired
	private SessionFactory session;

	@Override
	public List<User> getAllFriends(int id_user) {
		String hql = "select Z.id_user, Z.age, Z.gender, Z.firstName, Z.lastName from com.mstanciu.model.User Z "
				+ "where Z.id_user in (select F.id_friend "
				+ "from com.mstanciu.model.User U,com.mstanciu.model.User_friend F "
				+ "where U.id_user = F.id_user and U.id_user =" + id_user + " and F.pending = 1)";
		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public int unfriend(int id_user, int id_friend) {
		String hql = "delete from com.mstanciu.model.User_friend E "
				+ "where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_user + " and E.id_friend = " + id_friend + ")";

		String hql2 = "delete from com.mstanciu.model.User_friend E "
				+ "where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_friend + " and E.id_friend = " + id_user + ")";

		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		Query q2 = session.getCurrentSession().createQuery(hql2);
		return query.executeUpdate() + q2.executeUpdate();
	}

	@Override
	public void addFriend(User_friend uf) {
		uf.setPending(3);
		session.getCurrentSession().save(uf);
		User_friend uf2 = new User_friend();
		uf2.setId_user(uf.getId_friend());
		uf2.setId_friend(uf.getId_user());
		uf2.setPending(3);
		session.getCurrentSession().save(uf2);
	}

	@Override
	public List<User> getPendingFriends(int id_user) {
		String hql = "select Z.id_user, Z.age, Z.gender, Z.firstName, Z.lastName from com.mstanciu.model.User Z "
				+ "where Z.id_user in (select F.id_friend "
				+ "from com.mstanciu.model.User U,com.mstanciu.model.User_friend F "
				+ "where U.id_user = F.id_user and U.id_user =" + id_user + " and F.pending = 2)";
		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public int accept(int id_user, int id_friend) {
		String hql = "update com.mstanciu.model.User_friend E "
				+ "set E.pending = 1 where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_user + " and E.id_friend = " + id_friend + ")";

		String hql2 = "update com.mstanciu.model.User_friend E "
				+ "set E.pending = 1 where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_friend + " and E.id_friend = " + id_user + ")";

		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		Query q2 = session.getCurrentSession().createQuery(hql2);
		return query.executeUpdate() + q2.executeUpdate();
	}

	@Override
	public int reject(int id_user, int id_friend) {
		String hql = "update com.mstanciu.model.User_friend E "
				+ "set E.pending = 0 where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_user + " and E.id_friend = " + id_friend + ")";

		String hql2 = "update com.mstanciu.model.User_friend E "
				+ "set E.pending = 0 where exists (select E.id_user from com.mstanciu.model.User U where U.id_user = E.id_user and U.id_user"
				+ " = " + id_friend + " and E.id_friend = " + id_user + ")";

		System.out.println(hql);
		Query query = session.getCurrentSession().createQuery(hql);
		Query q2 = session.getCurrentSession().createQuery(hql2);
		return query.executeUpdate() + q2.executeUpdate();
	}
}
