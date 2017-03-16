package com.erwan.nikonikospring.controllers.base.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erwan.nikonikospring.controllers.base.BaseController;
import com.erwan.nikonikospring.models.modelbase.DatabaseItem;
import com.erwan.nikonikospring.utils.DumpFields;

public abstract class ViewBaseController<T extends DatabaseItem> extends
		BaseController<T> {

	// Nom de classe 
	private String baseName;

	// String qui vont permettre d'accéder à la page create (utilisé avec PATH et REDIRECT)
	protected String createView;
	protected String createRedirect;

	// String qui vont permettre d'accéder à la page delete (utilisé avec PATH et REDIRECT)
	protected String deleteView;
	protected String deleteRedirect;

	// String qui vont permettre d'accéder à la page update (utilisé avec PATH et REDIRECT)
	protected String updateView;
	protected String updateRedirect;

	// String qui vont permettre d'accéder à la page show (utilisé avec PATH et REDIRECT)
	protected String showView;
	protected String showRedirect;

	// String qui vont permettre d'accéder à la page list (utilisé avec PATH et REDIRECT)
	protected String listView;
	protected String listRedirect;
	
	// String qui va permettre d'accéder aux informations concernant la classe en question (nikoniko, project etc...)
	protected String baseView;

	
	// Constructeur de VBC prenant en paramètre le nom de classe (NikoNiko) et la classe elle même (NikoNiko)
	// récupéré depuis la classe enfant qui par le RequestMapping appelle le constructeur ci-dessous
	protected ViewBaseController(Class<T> clazz, String baseName) {
		super(clazz);

		// Récupération du nom de la classe et de la classe enfant
		this.baseName = baseName;
		this.baseView = "base";

		// this.(...)View = nom de la classe sur laquelle on est + le chemin de la page sur laquelle on veut aller.
		this.createView = this.baseView + PATH_CREATE_FILE;
		this.deleteView = this.baseView + PATH_DELETE_FILE;
		this.updateView = this.baseView + PATH_UPDATE_FILE;
		this.showView = this.baseView + PATH_SHOW_FILE;
		this.listView = this.baseView + PATH_LIST_FILE;

		// Redirection
		this.createRedirect = REDIRECT + this.baseName + PATH_LIST_FILE;
		this.deleteRedirect = REDIRECT + this.baseName + PATH_LIST_FILE;
		this.updateRedirect = REDIRECT + this.baseName + PATH_LIST_FILE;
		this.showRedirect = REDIRECT + this.baseName + PATH_LIST_FILE;
		this.listRedirect = REDIRECT + this.baseName + PATH_LIST_FILE;
	}

	// Méthode permettant de renvoyer la liste de tous les objets, concernant une classe que l'on renseigne par le PATH, contenu dans la BDD
	// Si on ne met juste que l'URL et pas le nom de la méthode pas besoin de value
	@RequestMapping(value = { PATH, ROUTE_LIST }, method = RequestMethod.GET)
	public String index(Model model) {
		// model est un object de SPRING permettant d'ajouter à cet objet plusieurs éléments ("page", "fields" etc... de type string ou autre)
		// et de la ajouter a la view souhaitée (..._action correspond à list, create etc..)
		model.addAttribute("page", this.baseName + " " + LIST_ACTION);
		model.addAttribute("fields",DumpFields.createContentsEmpty(super.getClazz()).fields);
		model.addAttribute("items", DumpFields.listFielder(super.getItems()));
		return listView;
	}

	// Méthode permettant d'afficher uniquement un seul élément en fonction de son id et l'afficher
	// sur la page show. @PathVariable récupère le nom identique en paramètre qu'on lui indique sur les view.
	@RequestMapping(path = ROUTE_SHOW, method = RequestMethod.GET)
	public String itemGet(@PathVariable Long id, Model model) {
		model.addAttribute("page", this.baseName + " " + SHOW_ACTION);
		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
		model.addAttribute("currentItem", DumpFields.fielder(super.getItem(id)));
		return showView;
	}

	// A revoir (fonction fielder advance)
	@RequestMapping(path = ROUTE_CREATE, method = RequestMethod.GET)
	public String createItemGet(Model model) {
		model.addAttribute("page", this.baseName + " " + CREATE_ACTION);
		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
		model.addAttribute("currentItem", DumpFields.fielderAdvance(DumpFields.createContentsEmpty(super.getClazz()),super.getClazz()));
		return createView;
	}

	// Création d'un nouvel object du type de la classe renseigné dans le constructeur par un formulaire (RequestMethod.POST)
	@RequestMapping(path = ROUTE_CREATE, method = RequestMethod.POST)
	public String createItemPost(T item, Model model) {
		try {
			super.insertItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
//		model.addAttribute("items", super.getItems());
		return createRedirect;
	}

	@RequestMapping(path = ROUTE_UPDATE, method = RequestMethod.GET)
	public String updateItemGet(@PathVariable Long id, Model model) {
		model.addAttribute("page", this.baseName + " " + UPDATE_ACTION);
		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
		model.addAttribute("currentItem", DumpFields.fielder(super.getItem(id)));
		return updateView;
	}

	@RequestMapping(path = ROUTE_UPDATE, method = RequestMethod.POST)
	public String updateItemPost(@ModelAttribute T item, Model model) {
		super.updateItem(item);
//		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
//		model.addAttribute("items", super.getItems());
		return updateRedirect;
	}

	@RequestMapping(path = ROUTE_DELETE, method = RequestMethod.GET)
	public String deleteItemGet(@PathVariable Long id, Model model) {
		model.addAttribute("page", this.baseName + " " + DELETE_ACTION);
		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
		model.addAttribute("currentItem", DumpFields.fielder(super.getItem(id)));
		return deleteView;
	}

	@RequestMapping(path = ROUTE_DELETE, method = RequestMethod.POST)
	public String deleteItemPost(@PathVariable Long id, Model model) {
		super.deleteItem(id);
//		model.addAttribute("fields", DumpFields.createContentsEmpty(super.getClazz()).fields);
//		model.addAttribute("items", super.getItems());
		return deleteRedirect;
	}
}
