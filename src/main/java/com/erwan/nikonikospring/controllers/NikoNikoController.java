package com.erwan.nikonikospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erwan.nikonikospring.controllers.base.view.ViewBaseController;
import com.erwan.nikonikospring.models.NikoNiko;


@Controller
@RequestMapping(NikoNikoController.BASE_URL)
public class NikoNikoController extends ViewBaseController<NikoNiko>{

	public final static String BASE_URL = "/nikoniko";

	public NikoNikoController() {
		super(NikoNiko.class, BASE_URL);
	}

}
