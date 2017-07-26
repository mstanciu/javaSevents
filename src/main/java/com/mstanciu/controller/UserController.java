package com.mstanciu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mstanciu.model.User;
import com.mstanciu.service.UserService;

/*@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)*/
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public List<User> setupForm(ModelMap map) {
		return userService.getAllUsers();
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		userService.add(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/register/{email}").buildAndExpand(user.getEmail()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = { "/login/login" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> login(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		User result = userService.login(user.getEmail(), user.getPassword());
		List<String> info = new ArrayList();
		info.add(result.getId_user() + "");
		info.add(result.getEmail());
		info.add(result.getFirstName());
		info.add(result.getLastName());
		info.add(result.getAge() + "");
		info.add(result.getGender());
		if (result != null) {
			return info;
		}
		return null;
	}
}
