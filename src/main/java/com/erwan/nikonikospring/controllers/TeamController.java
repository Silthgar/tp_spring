package com.erwan.nikonikospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.models.Team;
import com.erwan.nikonikospring.controllers.TeamController;
import com.erwan.nikonikospring.controllers.base.view.ViewBaseController;

@Controller
@RequestMapping(TeamController.BASE_URL)
public class TeamController extends ViewBaseController<Team>{

	public final static String BASE_URL = "/team";

	public TeamController() {
		super(Team.class);
	}
}
