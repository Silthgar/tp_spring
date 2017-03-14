package com.erwan.nikonikospring.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erwan.nikonikospring.dao.INikoNikoCrudRepository;
import com.erwan.nikonikospring.models.NikoNiko;
import com.erwan.nikonikospring.utils.DumpFields;


@Controller
@RequestMapping("/nikoniko")
public class NikoNikoController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("attributs",DumpFields.inspectBaseAttribut(NikoNiko.class));

		ArrayList<NikoNiko> nikonikos = (ArrayList<NikoNiko>) nikoCrud.findAll();

		model.addAttribute("sortedFields",NikoNiko.FIELDS);
		model.addAttribute("items",DumpFields.listFielder(nikonikos));
		//on peut ecrire la ligne ci dessus de la maniere suivante :
		//model.addAttribute("items",DumpFields.listFielder((List<NikoNiko>) nikoCrud.findAll()));
		//plus bourrin mais ça fait pareil

		return "nikoniko/index";
	}

	@Autowired
	private INikoNikoCrudRepository nikoCrud;
}
