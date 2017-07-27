package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.User_friendDao;
import com.mstanciu.model.User;
import com.mstanciu.model.User_friend;
import com.mstanciu.service.User_friendService;

@Service
@Transactional
public class User_friendServiceImpl implements User_friendService {

	@Autowired
	private User_friendDao ufd;

	@Override
	public List<User> getAllFriends(int id_user) {
		return ufd.getAllFriends(id_user);
	}

	@Override
	public int unfriend(int id_user, int id_friend) {
		return ufd.unfriend(id_user, id_friend);
	}

	@Override
	public void addFriend(User_friend uf) {
		ufd.addFriend(uf);
	}

	@Override
	public List<User> getPendingFriends(int id_user) {
		return ufd.getPendingFriends(id_user);
	}

	@Override
	public int accept(int id_user, int id_friend) {
		return ufd.accept(id_user, id_friend);
	}

	@Override
	public int reject(int id_user, int id_friend) {
		return ufd.reject(id_user, id_friend);
	}

}
