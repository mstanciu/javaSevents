package com.mstanciu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mstanciu.dao.User_friendDao;
import com.mstanciu.model.User;
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

}
