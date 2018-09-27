package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Operation;

@Repository
public class OperationDAOImpl implements OperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Operation> getListOperationsPourMateriel(int idMat) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Operation where idMateriel = :idM order by date_operation desc");
		query.setParameter("idM", idMat);

		return query.list();
	}

	@Transactional
	public void supprimerOperationsPourMateriel(int idMat) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Operation where idMateriel = :idM");
		query.setParameter("idM", idMat);
		query.executeUpdate();

	}

	@Transactional
	public int getPeriodForNextOperation(int idMat) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select DATEDIFF(curdate(),max(date_operation)) from Operation where idMateriel= :idM");
		query.setParameter("idM", idMat);
		return (Integer) query.uniqueResult();
	}

	@Transactional
	public void ajouterOperation(Operation op) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(op);

	}

}
