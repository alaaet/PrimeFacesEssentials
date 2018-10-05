package com.vubari.prime.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.User;

@ManagedBean
@RequestScoped
public class LoginUserController {
	private User loginUser;
	private String loginStatus;

	public LoginUserController() {
		this.loginUser = new User();
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String login() {
		boolean validCredentials = "admin".equals(loginUser.getUserName()) && "admin".equals(loginUser.getPassword());
		this.loginStatus = validCredentials ? "Login Successful" : "Login failed";
		return null;
	}
}