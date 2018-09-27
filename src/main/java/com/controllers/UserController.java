package com.controllers;

import java.io.File;
import java.util.SortedSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.beans.Materiel;
import com.beans.Operation;
import com.dataTransfer.MaterielRep;
import com.service.CategorieService;
import com.service.MaterielService;
import com.service.OperationService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private MaterielService materielServ;
	@Autowired
	private CategorieService categServ;
	@Autowired
	private OperationService opServ;

	@RequestMapping("/")
	public String accueil() {
		return "Accueil";
	}

	@RequestMapping("/ajouter-materiel")
	public String ajouterMateriel(HttpServletRequest request, Model model) {
		request.setAttribute("categs", categServ.getListCategorie());
		model.addAttribute("newMateriel", new Materiel());
		return "Ajouter_Materiel";
	}

	@RequestMapping(value = "/ajouter-materiel", method = RequestMethod.POST)
	public String processAjouterMateriel(@ModelAttribute("newMateriel") @Valid Materiel newMat,
			HttpServletRequest request, Model model) {
		MultipartFile image = newMat.getImage();
		String path = request.getServletContext().getRealPath("/") + "/resources/images/materiel";
		try {

			materielServ.ajouter(newMat);
			System.out.println(newMat.getId());
			System.out.println(path);
			image.transferTo(new File(path, newMat.getId() + ".jpg"));
			Operation op = new Operation();
			op.setDate_operation(newMat.getDernierMod());
			op.setDescription("implementation du materiel");
			op.setIdMateriel(newMat.getId());
			op.setNom("Implementation");
			opServ.ajouterOperation(op);
			return "redirect:/user/liste-materiel";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		request.setAttribute("error", true);
		return "Ajouter_Materiel";
	}

	@RequestMapping("/liste-materiel")
	public String listeMateriel(HttpServletRequest request) {
		String categ = request.getParameter("categ");
		SortedSet<MaterielRep> liste;
		if (null != categ) {
			if ("0".equals(categ))
				liste = materielServ.getListMateriel();
			else
				liste = materielServ.getListMaterielByCategorie(Integer.parseInt(categ));

		} else
			liste = materielServ.getListMateriel();

		request.setAttribute("mats", liste);
		request.setAttribute("categs", categServ.getListCategorie());
		return "Liste_Materiel";
	}

	@RequestMapping("/modifier-materiel/{idM}")
	public String modifierMateriel(@PathVariable("idM") String idMateriel, HttpServletRequest request, Model model) {
		Materiel mat = materielServ.getMaterielById(Integer.parseInt(idMateriel));
		model.addAttribute("mat", mat);
		request.setAttribute("categs", categServ.getListCategorie());
		request.setAttribute("curr_categ", mat.getCategorie());
		return "Modifier_Materiel";
	}

	@RequestMapping(value = "/modifier-materiel/{idM}", method = RequestMethod.POST)
	public String processModifierMateriel(@ModelAttribute("mat") @Valid Materiel mat, HttpServletRequest request,
			@PathVariable("idM") String idMateriel) {
		mat.setId(Integer.parseInt(idMateriel));
		materielServ.modifier(mat);
		request.setAttribute("success", true);
		request.setAttribute("categs", categServ.getListCategorie());
		request.setAttribute("curr_categ", mat.getCategorie());
		return "Modifier_Materiel";
	}

	@RequestMapping("/consulter-materiel")
	public String consulterMateriel(HttpServletRequest request) {
		String id = request.getParameter("id");
		MaterielRep materiel = materielServ.getMaterielRepById(Integer.parseInt(id));
		request.setAttribute("mat", materiel);
		request.setAttribute("ops", opServ.getListOperationsPourMateriel(materiel.getId()));
		return "Consulter_Materiel";
	}

	@RequestMapping("/ajouter-operation/{idM}")
	public String AjouterOperation(Model model) {
		model.addAttribute("newOp", new Operation());
		return "Ajouter_Operation";
	}

	@RequestMapping(value = "/ajouter-operation/{idM}", method = RequestMethod.POST)
	public String processAjouterOperation(@ModelAttribute("newOp") Operation op, HttpServletRequest request,
			@PathVariable("idM") String idM) {
		op.setIdMateriel(Integer.parseInt(idM));
		opServ.ajouterOperation(op);
		request.setAttribute("success", true);
		return "Ajouter_Operation";
	}

	@RequestMapping("/supprimer-materiel")
	@ResponseBody
	public String supprimerMateriel(HttpServletRequest request) {
		String id = request.getParameter("id");
		materielServ.supprimer(Integer.parseInt(id));

		return "yes";
	}

}
