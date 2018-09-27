package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Materiel;

@Repository
public class MaterielDAOImpl implements MaterielDAO {

	@Autowired
	private SessionFactory sessionFac;

	@Transactional
	public void ajouter(Materiel materiel) {
		Session session = sessionFac.getCurrentSession();
		session.persist(materiel);

	}

	@Transactional
	public Materiel getMaterielById(int id) {
		Session session = sessionFac.getCurrentSession();
		Query query = session.createQuery("from Materiel where id = :idM");
		query.setParameter("idM", id);

		return (Materiel) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Materiel> getListMateriel() {
		Session session = sessionFac.getCurrentSession();
		return session.createQuery("from Materiel").list();
	}

	@Transactional
	public void modifier(Materiel materiel) {
		Session session = sessionFac.getCurrentSession();
		session.update(materiel);

	}

	@Transactional
	public void supprimer(int id) {
		Session session = sessionFac.getCurrentSession();
		Materiel materiel = (Materiel) session.load(Materiel.class, id);
		if (null != materiel) {
			session.delete(materiel);
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Materiel> getListMaterielByCategorie(int cat) {
		Session session = sessionFac.getCurrentSession();
		Query query = session.createQuery("from Materiel where categorie= :cat");
		query.setParameter("cat", cat);
		return query.list();
	}

}
