package com.erwan.nikonikospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.dao.INikoNikoCrudRepository;
import com.erwan.nikonikospring.models.NikoNiko;

@Controller
public class NikoNikoController {
	
	@RequestMapping(value = {"/","/nikoniko"})
	public String index(){
		nikoCrud.save(new NikoNiko());
		return "toto";
	}
	
	@Autowired
	private INikoNikoCrudRepository nikoCrud;

}
