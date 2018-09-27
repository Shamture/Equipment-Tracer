package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Categorie;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Categorie> getListCategorie() {
		Session session = sessionFac.getCurrentSession();

		List<Categorie> list = session.createQuery("from Categorie").list();
		return list;
	}

	@Transactional
	public Categorie getCategorie(int id) {
		Session session = sessionFac.getCurrentSession();
		Query query = session.createQuery("from Categorie where id = :idC");
		query.setParameter("idC", id);
		return (Categorie) query.uniqueResult();
	}

	@Transactional
	public void ajouter(Categorie cat) {
		Session session = sessionFac.getCurrentSession();
		session.persist(cat);

	}

	@Transactional
	public void supprimerCategorie(int id) {
		Session session = sessionFac.getCurrentSession();
		Categorie cat = (Categorie) session.load(Categorie.class, id);
		if (null != cat)
			session.delete(cat);

	}
}
