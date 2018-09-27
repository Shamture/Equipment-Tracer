package com.service;

import java.util.List;

import com.beans.Categorie;

public interface CategorieService {

	public List<Categorie> getListCategorie();

	public Categorie getCategorie(int id);

	public void ajouter(Categorie cat);

	public void supprimerCategorie(int id);

}
