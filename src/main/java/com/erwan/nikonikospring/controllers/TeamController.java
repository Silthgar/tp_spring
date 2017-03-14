package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.ITeamCrudRepository;
import com.erwan.nikonikospring.models.Team;

@Controller
public class TeamController {
	
	@RequestMapping(value = {"/","/team"})
	public String index(){
		//teamCrud.save(new Team());
		return "team";
	}
	
	@Autowired
	private ITeamCrudRepository teamCrud;

}
