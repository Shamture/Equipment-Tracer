package com.service;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Categorie;
import com.beans.Materiel;
import com.dao.MaterielDAO;
import com.dataTransfer.MaterielRep;

@Service
public class MaterielServiceImpl implements MaterielService {

	@Autowired
	private MaterielDAO materielDAO;
	@Autowired
	private CategorieService categServ;
	@Autowired
	private OperationService opServ;

	public void ajouter(Materiel materiel) {
		materielDAO.ajouter(materiel);

	}

	public MaterielRep getMaterielRepById(int id) {
		Materiel mat = materielDAO.getMaterielById(id);
		Categorie cat = categServ.getCategorie(mat.getCategorie());

		return MaterielRep.generateMateriel(mat, cat.getNom(), opServ.getPeriodForNextOperation(mat.getId()));
	}

	public SortedSet<MaterielRep> getListMateriel() {
		SortedSet<MaterielRep> materielRepSet = new TreeSet<MaterielRep>();
		List<Materiel> listM = materielDAO.getListMateriel();
		for (Materiel m : listM) {
			
			Categorie cat = categServ.getCategorie(m.getCategorie());
			MaterielRep mat = MaterielRep.generateMateriel(m, cat.getNom(),
					opServ.getPeriodForNextOperation(m.getId()));
			if(mat.getJoursRestantDansLeDelai()<0){
				m.setEtat(0);
				modifier(m);
				mat.setEtat("non actif");
			}
			materielRepSet.add(mat);
		}

		return materielRepSet;
	}

	public void modifier(Materiel materiel) {
		materielDAO.modifier(materiel);

	}

	public void supprimer(int id) {
		opServ.supprimerOperationsPourMateriel(id);
		materielDAO.supprimer(id);

	}

	public SortedSet<MaterielRep> getListMaterielByCategorie(int cat) {
		SortedSet<MaterielRep> list = new TreeSet<MaterielRep>();
		List<Materiel> listM = materielDAO.getListMaterielByCategorie(cat);
		for (Materiel m : listM) {
			Categorie categ = categServ.getCategorie(m.getCategorie());
			MaterielRep mat = MaterielRep.generateMateriel(m, categ.getNom(),
					opServ.getPeriodForNextOperation(m.getId()));
			list.add(mat);
		}
		return list;
	}

	public Materiel getMaterielById(int id) {
		return materielDAO.getMaterielById(id);
	}

}
