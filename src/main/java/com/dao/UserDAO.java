package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDAO {

	public boolean authentifier(String login, String password);

	public User getUserByEmail(String email);

	public boolean updateUser(User user);

	public User getuserByLogin(String login);

	public List<User> getUsersList();

	public void ajouter(User user);

	public void deleteUser(int id);

}
