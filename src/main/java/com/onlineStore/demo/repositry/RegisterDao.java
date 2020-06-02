package com.onlineStore.demo.repositry;

import java.util.List;

import com.onlineStore.demo.model.Register;

public interface RegisterDao {

	List<Register> searchById(String registerId);

}
