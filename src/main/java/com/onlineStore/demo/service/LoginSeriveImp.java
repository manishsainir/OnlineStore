package com.onlineStore.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Register;
import com.onlineStore.demo.repositry.LoginDao;

@Service
@Transactional
public class LoginSeriveImp implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public void insert(Register register) {
		this.loginDao.insert(register);

	}

	@Override
	public boolean verify(Login login) {
		
		return this.loginDao.verify(login);
	}

}
