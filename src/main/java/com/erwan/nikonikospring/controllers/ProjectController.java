package com.erwan.nikonikospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.models.Project;
import com.erwan.nikonikospring.controllers.ProjectController;
import com.erwan.nikonikospring.controllers.base.view.ViewBaseController;

@Controller
@RequestMapping(ProjectController.BASE_URL)
public class ProjectController extends ViewBaseController<Project>{

	public final static String BASE_URL = "/project";

	public ProjectController() {
		super(Project.class);
	}

}