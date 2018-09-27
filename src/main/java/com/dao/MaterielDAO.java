package com.dao;

import java.util.List;

import com.beans.Materiel;

public interface MaterielDAO {

	public void ajouter(Materiel materiel);

	public Materiel getMaterielById(int id);

	public List<Materiel> getListMateriel();

	public List<Materiel> getListMaterielByCategorie(int cat);

	public void modifier(Materiel materiel);

	public void supprimer(int id);

}
