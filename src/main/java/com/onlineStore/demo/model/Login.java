package com.onlineStore.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5351601303070512670L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
