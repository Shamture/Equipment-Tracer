package com.service;

import java.util.List;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Categorie;
import com.dao.CategorieDAO;
import com.dataTransfer.MaterielRep;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private MaterielService matServ;

	public List<Categorie> getListCategorie() {
		return categorieDAO.getListCategorie();
	}

	public Categorie getCategorie(int id) {
		return categorieDAO.getCategorie(id);
	}

	public void ajouter(Categorie cat) {
		categorieDAO.ajouter(cat);

	}

	public void supprimerCategorie(int id) {
		SortedSet<MaterielRep> materielSet = matServ.getListMaterielByCategorie(id);
		for (MaterielRep mat : materielSet)
			matServ.supprimer(mat.getId());
		categorieDAO.supprimerCategorie(id);

	}

}
