package com.vubari.prime.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.User;

@ManagedBean
@RequestScoped
public class UserControllerOld {

	private User registrationUser;

	public UserControllerOld() {
		this.registrationUser = new User();
	}

	public User getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) {
		this.registrationUser = registrationUser;
	}

	public String register() {
		System.out.println("Register User :" + this.registrationUser);
		String msg = "User Registered Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "registration.jsf?faces-redirect=true";
	}

	public void checkUserNamesExists() {
		String userName = this.registrationUser.getUserName();
		if ("admin".equals(userName) || "test".equals(userName)) {
			String msg = "UserName [" + userName + "] already in use.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:userName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
}