package com.onlineStore.demo.service;

import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Register;

public interface LoginService {

	void insert(Register register);

	boolean verify(Login login);

}
