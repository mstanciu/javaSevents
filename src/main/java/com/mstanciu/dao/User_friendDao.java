package com.mstanciu.dao;

import java.util.List;

import com.mstanciu.model.User;
import com.mstanciu.model.User_friend;

public interface User_friendDao {

	public List<User> getAllFriends(int id_user);

	public int unfriend(int id_user, int id_friend);

	public void addFriend(User_friend uf);

	public List<User> getPendingFriends(int id_user);

	public int accept(int id_user, int id_friend);

	public int reject(int id_user, int id_friend);

}
