package com.service;

import java.util.List;

import com.beans.User;

public interface UserService {

	public boolean authentifier(String login, String password);

	public boolean updateuser(User user);

	

	public User getuserByLogin(String login);

	public User getUserByEmeil(String email);

	public List<User> getUsersList();

	public void creeCompte(User user);

	public void delete(int id);

}
