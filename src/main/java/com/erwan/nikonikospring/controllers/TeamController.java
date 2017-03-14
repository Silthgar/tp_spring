package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.ITeamCrudRepository;

@Controller
public class TeamController {

	@RequestMapping(value = {"/team/","/team"})
	public String index() {

		return "team";
	}

	@Autowired
	private ITeamCrudRepository teamCrud;

}
