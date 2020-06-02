package com.onlineStore.demo.repositry;

import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Register;

public interface LoginDao {

	void insert(Register register);

	boolean verify(Login login);

}
