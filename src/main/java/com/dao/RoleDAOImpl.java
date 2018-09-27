package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String getRoleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role where role = :id");
		query.setParameter("id", id);
		Role role = (Role) query.uniqueResult();
		return role.getRole_name();
	}

}
