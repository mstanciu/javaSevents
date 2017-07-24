package com.mstanciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mstanciu.model.Sport;
import com.mstanciu.service.SportService;

@RestController
public class SportController {

	@Autowired
	private SportService sportService;

	@RequestMapping(value = { "/account/sports" }, method = RequestMethod.GET)
	public List<Sport> getAllSports(ModelMap map) {
		return sportService.getAllSports();
	}

}
