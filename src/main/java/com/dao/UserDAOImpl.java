package com.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean authentifier(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where login = :lgn");
		query.setParameter("lgn", login);
		System.out.println(login);
		User user = (User) query.uniqueResult();

		if (null != user) {

			try {
				if (Crypteur.validatePassword(password, user.getPassword()))
					return true;
			} catch (NoSuchAlgorithmException e) {

				e.printStackTrace();
			} catch (InvalidKeySpecException e) {

				e.printStackTrace();
			}

		}
		return false;
	}

	@Transactional
	public User getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query sql = session.createQuery("from User where email = :eml");
		sql.setParameter("eml", email);
		User user = (User) sql.uniqueResult();
		return user;
	}

	@Transactional
	public boolean updateUser(User user) {
		try {
			user.setPassword(Crypteur.generateStorngPasswordHash(user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	@Transactional
	public User getuserByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Query sql = session.createQuery("from User where login = :logn");
		sql.setParameter("logn", login);
		User user = (User) sql.uniqueResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsersList() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery("from User").list();
	}

	@Transactional
	public void ajouter(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);

	}

	@Transactional
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		if (null != user) {
			session.delete(user);
		}
	}

}
