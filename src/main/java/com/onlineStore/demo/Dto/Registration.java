package com.onlineStore.demo.Dto;

import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Register;

public class Registration {
	private Login login;
	private Register register;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

}
