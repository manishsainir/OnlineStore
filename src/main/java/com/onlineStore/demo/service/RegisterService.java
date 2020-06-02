package com.onlineStore.demo.service;

import java.util.List;

import com.onlineStore.demo.model.Register;

public interface RegisterService {

	List<Register> searchById(String registerId);

}
