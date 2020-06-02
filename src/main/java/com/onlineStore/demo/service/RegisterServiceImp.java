package com.onlineStore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineStore.demo.model.Register;
import com.onlineStore.demo.repositry.RegisterDao;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService {

	@Autowired
	RegisterDao registerDao;
	
	@Override
	public List<Register> searchById(String registerId) {
		List<Register> list = this.registerDao.searchById(registerId);
		return list;
	}

}
