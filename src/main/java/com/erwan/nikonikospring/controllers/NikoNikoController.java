package com.erwan.nikonikospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.erwan.nikonikospring.controllers.base.view.ViewBaseController;
import com.erwan.nikonikospring.models.NikoNiko;
import com.erwan.nikonikospring.controllers.NikoNikoController;

	@Controller
	@RequestMapping(NikoNikoController.BASE_URL)
	public class NikoNikoController extends ViewBaseController<NikoNiko>{

		public final static String BASE_URL = "/nikoniko";

		public NikoNikoController() {
			super(NikoNiko.class, BASE_URL);
		}
	
//	@RequestMapping(path="/", method = RequestMethod.GET)
//	public String index(Model model){
//		
//		ArrayList<NikoNiko> nikonikos = (ArrayList<NikoNiko>) nikoCrud.findAll();
//		DumpFields.listFielder(nikonikos);
//		
//		model.addAttribute("items",DumpFields.listFielder(nikonikos));
//		
//		model.addAttribute("attributs", DumpFields.inspectBaseAttribut(NikoNiko.class));
//		
//		model.addAttribute("page","NIKONIKOS");
//		
//		// Fonction permettant de ranger les éléments de la liste (NE MARCHE PAS)
//		//model.addAttribute("items",orderListe(nikonikos));
//		
//		return "nikoniko";
//	}
//	
//	@Autowired
//	private INikoNikoCrudRepository nikoCrud;
	
	
	
	
	
	
	
	
//	// Fonction de tri (NE MARCHE PAS)
//	public static ArrayList<Map<String, Object>>  orderListe(ArrayList<NikoNiko> nikoniko){
//		
//		//On créer un arrayList de map vide
//		ArrayList<Map<String, Object>>  mapList = new ArrayList<Map<String,Object>>();
//		
//		// On créer une map vide pour insérer les bonnes valeurs
//		Map<String, Object> mapAttributs = null;
//		
//		// On définit un NikoNIko arbitraire pour retrouver les fields
//		NikoNiko niko = new NikoNiko();
//		
//		// On créer une liste vide et on insère les fields dans une nouvelle liste nikoFields
//		String [] nikoFields;
//		nikoFields = niko.FIELDS;
//		
//		// On créé une arrayList contenant les attributs de la classe NikoNiko.class
//		ArrayList<Map<String, Object>> attributs = DumpFields.listFielder(nikoniko);
//		
//		// On boucle sur toute les maps dans la liste attributs
//		for (Map<String, Object> map : attributs) {
//			// On boucle sur touts les fields de NikoNiko
//			for (String field : NikoNiko.FIELDS) {
//				if (map.keySet().equals(field)) {
//					mapList.add(map);
//				}
//			}
//		}
//		return mapList;
//	}
}
