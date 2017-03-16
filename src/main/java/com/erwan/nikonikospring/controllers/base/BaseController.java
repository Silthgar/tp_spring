package com.erwan.nikonikospring.controllers.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.erwan.nikonikospring.dao.base.IBaseCrudRepository;
import com.erwan.nikonikospring.models.modelbase.DatabaseItem;

public abstract class BaseController <T extends DatabaseItem> {

	// Définition du nom des pages (url) pour accéder aux différentes actions
	public final static String SHOW_ACTION = "show";
	public final static String CREATE_ACTION = "create";
	public final static String UPDATE_ACTION = "update";
	public final static String DELETE_ACTION = "delete";
	public final static String LIST_ACTION = "list";

	// Redirection
	public final static String REDIRECT = "redirect:/";

	// '/' Important à mettre pour accéder aux différentes pages (chemin)
	public final static String PATH = "/";
	
	// Définition des différents PATH pour accéder aux différentes pages
	public final static String PATH_SHOW_FILE = PATH + SHOW_ACTION;
	public final static String PATH_CREATE_FILE = PATH + CREATE_ACTION;
	public final static String PATH_UPDATE_FILE = PATH + UPDATE_ACTION;
	public final static String PATH_DELETE_FILE = PATH + DELETE_ACTION;
	public final static String PATH_LIST_FILE = PATH + LIST_ACTION;

	// PATH utile lorsqu'on utilise l'id (Nécessaire : ROUTE_LIST = LIST_ACTION ?)
	public final static String ROUTE_SHOW = "{id}/" + SHOW_ACTION;
	public final static String ROUTE_CREATE = CREATE_ACTION;
	public final static String ROUTE_UPDATE = "{id}/" + UPDATE_ACTION;
	public final static String ROUTE_DELETE = "{id}/" + DELETE_ACTION;
	public final static String ROUTE_LIST = LIST_ACTION;

	// Autoinstanciation de baseCrud pour utiliser toutes les fonctions du CRUD
	@Autowired
	private IBaseCrudRepository<T> baseCrud;

	private Class<T> clazz;

	/**
	 * @return the clazz
	 */
	protected Class<T> getClazz() {
		return clazz;
	}

	protected BaseController(Class<T> clazz){
		this.clazz = clazz;
	}

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

	public String deleteItem(Long id){
		try {
			baseCrud.delete(id);
		} catch (Exception e) {
			return "Delete failed";
		}
		return "Delete OK";
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
