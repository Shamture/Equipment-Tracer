package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.User;
import com.service.RoleService;
import com.service.UserService;

@Controller
public class Main {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleServ;

	@RequestMapping("/")
	public String login() {

		return "Login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String parseLogin(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		if (userService.authentifier(login, pass)) {
			HttpSession session = request.getSession();
			User user = userService.getuserByLogin(login);
			session.setAttribute("id", user.getIdUser());
			session.setAttribute("nom", user.getNom());
			session.setAttribute("prenom", user.getPrenom());
			session.setAttribute("role", roleServ.getRoleById(user.getRole()));
			return "redirect:/user/";
		}

		request.setAttribute("error", true);
		return "Login";
	}

	@RequestMapping("/deconnecter")
	public String deconnecter(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
