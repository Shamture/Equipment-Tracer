package com.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.User;
import com.dao.Crypteur;
import com.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleService roleServ;

	public boolean authentifier(String login, String password) {
		return userDAO.authentifier(login, password);
	}

	public boolean updateuser(User user) {
		return userDAO.updateUser(user);
	}

	public User getuserByLogin(String login) {
		return userDAO.getuserByLogin(login);
	}

	public User getUserByEmeil(String email) {
		return userDAO.getUserByEmail(email);
	}

	public List<User> getUsersList() {
		return userDAO.getUsersList();
	}

	public void creeCompte(User user) {
		user.setLogin(user.getNom() + "_" + user.getPrenom() + "_" + ((int) Math.random() * 100));
		user.setPassword(roleServ.getRoleById(user.getRole()));

		String mailContent = "<h1>Votre compte a ete cree avec succes</h1><p>Vous pouvez acceder a votre compte en utilisant les coordonnees suivant</p>";
		mailContent += "<p><trong>Login :</strong> " + user.getLogin() + "</p>";
		mailContent += "<p><trong>Mot de passe :</strong> " + user.getPassword() + "</p>";
		Mail.sendMail(user.getEmail(), "Compte cree avec succes", mailContent);
		try {
			user.setPassword(Crypteur.generateStorngPasswordHash(user.getPassword()));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (InvalidKeySpecException e) {

			e.printStackTrace();
		}
		user.setActive(1);
		userDAO.ajouter(user);

	}

	public void delete(int id) {
		userDAO.deleteUser(id);

	}

}
