package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.IProjectCrudRepository;

@Controller
public class ProjectController {

	@RequestMapping(value = {"/project/","/project"})
	public String index() {

		return "project";
	}

	@Autowired
	private IProjectCrudRepository projectCrud;

}
