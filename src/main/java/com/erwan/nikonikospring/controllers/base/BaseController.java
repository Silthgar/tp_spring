package com.erwan.nikonikospring.controllers.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.erwan.nikonikospring.dao.base.IBaseCrudRepository;
import com.erwan.nikonikospring.models.modelbase.DatabaseItem;

public abstract class BaseController <T extends DatabaseItem> {
	
	@Autowired
	private IBaseCrudRepository<T> baseCrud;
	
	public T insertItem(@ModelAttribute T item){
		baseCrud.save(item);
		return item;
	}
	
	public String updateItem(@ModelAttribute T item){
		try {
			baseCrud.save(item);
		} catch (Exception e) {
			return "Update failed";
		}
		return "Update OK";
	}
	
	
	public String deleteItem(@ModelAttribute T item){
		try {
			baseCrud.delete(item);
		} catch (Exception e) {
			return "Delete failed";
		}
		return "Delete OK";
	}
	
	public T getItem(Long id){
		T item = null;
		item = baseCrud.findOne(id);
		return item;
	}
	
	public List<T> getItems(){
		List<T> items = null;
		items = (List<T>) baseCrud.findAll();
		return items;
		 
	}

}
