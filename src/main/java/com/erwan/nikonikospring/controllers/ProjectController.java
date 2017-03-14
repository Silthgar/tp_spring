package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.IProjectCrudRepository;
import com.erwan.nikonikospring.models.Project;

@Controller
public class ProjectController {
	
	@RequestMapping(value = {"/","/project"})
	public String index(){
		//projectCrud.save(new Project());
		return "project";
	}
	
	@Autowired
	private IProjectCrudRepository projectCrud;

}
