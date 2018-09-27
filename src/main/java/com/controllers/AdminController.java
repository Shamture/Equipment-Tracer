package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beans.Categorie;
import com.beans.User;
import com.service.CategorieService;
import com.service.RoleService;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategorieService catServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private RoleService roleServ;

	@RequestMapping("/ajouter-categorie")
	public String ajouterCategorie(Model model) {
		model.addAttribute("newCat", new Categorie());
		return "Ajouter_Categorie";
	}

	@RequestMapping(value = "/ajouter-categorie", method = RequestMethod.POST)
	public String processAjouterCategorie(@ModelAttribute("newCat") Categorie cat, HttpServletRequest request) {
		catServ.ajouter(cat);
		request.setAttribute("success", true);
		return "Ajouter_Categorie";
	}

	@RequestMapping("/liste-categorie")
	public String listeCategorie(HttpServletRequest request) {
		request.setAttribute("cats", catServ.getListCategorie());
		return "Liste_Categories";
	}

	@RequestMapping("/supprimer-categorie")
	@ResponseBody
	public String deleteCategorie(HttpServletRequest request) {
		String id = request.getParameter("id");
		catServ.supprimerCategorie(Integer.parseInt(id));
		return "yes";
	}

	@RequestMapping("/ajouter-utilisateur")
	public String ajouterUtilisateur(Model model) {
		model.addAttribute("newUser", new User());
		return "Ajouter_Utilisateur";
	}

	@RequestMapping(value = "/ajouter-utilisateur", method = RequestMethod.POST)
	public String processAjouterUtilisateur(@ModelAttribute("newUser") User user, HttpServletRequest request) {
		userServ.creeCompte(user);
		request.setAttribute("success", true);
		return "Ajouter_Utilisateur";
	}
	@RequestMapping(value = "/liste-utilisateurs")
	public String listeUtilisateur(HttpServletRequest request){
		request.setAttribute("list", userServ.getUsersList());
		return "ListeUtilsiateurs";
	}
	
	@RequestMapping("/supprimer-utilisateur")
	@ResponseBody
	public String supprimerUtilsiateur(HttpServletRequest request){
		String id = request.getParameter("id");
		userServ.delete(Integer.parseInt(id));
		return "yes";
	}

}
