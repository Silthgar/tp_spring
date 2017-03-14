package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.IUserCrudRepository;
import com.erwan.nikonikospring.models.User;

@Controller
public class UserController {
	
	@RequestMapping(value = {"/","/user"})
	public String index(){
		//userCrud.save(new User());
		return "user";
	}
	
	@Autowired
	private IUserCrudRepository userCrud;

}
