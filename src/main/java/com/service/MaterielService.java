package com.service;

import java.util.SortedSet;

import com.beans.Materiel;
import com.dataTransfer.MaterielRep;

public interface MaterielService {

	public void ajouter(Materiel materiel);

	public MaterielRep getMaterielRepById(int id);

	public Materiel getMaterielById(int id);

	public SortedSet<MaterielRep> getListMateriel();

	public SortedSet<MaterielRep> getListMaterielByCategorie(int cat);

	public void modifier(Materiel materiel);

	public void supprimer(int id);

}
