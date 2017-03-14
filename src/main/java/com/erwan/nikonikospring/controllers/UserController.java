package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.IUserCrudRepository;



@Controller
public class UserController {

	@RequestMapping(value = {"/user/","/user"})
	public String index() {

		return "user";
	}

	@Autowired
	private IUserCrudRepository userCrud;

}
