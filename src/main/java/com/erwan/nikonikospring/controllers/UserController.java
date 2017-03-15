package com.erwan.nikonikospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.models.User;
import com.erwan.nikonikospring.controllers.UserController;
import com.erwan.nikonikospring.controllers.base.view.ViewBaseController;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController extends ViewBaseController<User>{

	public final static String BASE_URL = "/user";

	public UserController() {
		super(User.class);
	}
}
