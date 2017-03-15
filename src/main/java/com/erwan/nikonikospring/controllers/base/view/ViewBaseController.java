package com.erwan.nikonikospring.controllers.base.view;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erwan.nikonikospring.controllers.base.BaseController;
import com.erwan.nikonikospring.dao.base.IBaseCrudRepository;
import com.erwan.nikonikospring.models.modelbase.DatabaseItem;
import com.erwan.nikonikospring.utils.DumpFields;

public abstract class ViewBaseController<T extends DatabaseItem> extends BaseController<T> {

	@Autowired
	private IBaseCrudRepository<T> baseCrud;
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String index(Model model){
		
		ArrayList<T> listObject = (ArrayList<T>) baseCrud.findAll();
		DumpFields.listFielder(listObject);
		
		model.addAttribute("items",DumpFields.listFielder(listObject));
		
		String classNameLowerCase = listObject.get(0).getClass().getSimpleName().toLowerCase();
		
		return classNameLowerCase;
		
	}
}
