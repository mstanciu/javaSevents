package com.mstanciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mstanciu.model.User;
import com.mstanciu.model.User_friend;
import com.mstanciu.service.User_friendService;

@RestController
public class User_friendController {

	@Autowired
	private User_friendService ufs;

	@RequestMapping(value = { "/account/friends/listFriends" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getFriends(@RequestBody User_friend uf, UriComponentsBuilder ucBuilder) {
		List<User> results = ufs.getAllFriends(uf.getId_user());
		return results;
	}

	@RequestMapping(value = { "/account/friends/unfriend" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public boolean unfriend(@RequestBody User_friend uf, UriComponentsBuilder ucBuilder) {
		int results = ufs.unfriend(uf.getId_user(), uf.getId_friend());
		if (results > 0) {
			return true;
		}
		return false;
	}

}
