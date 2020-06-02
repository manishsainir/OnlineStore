package com.onlineStore.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineStore.demo.model.Bill;
import com.onlineStore.demo.repositry.BillDao;

@Service
@Transactional
public class BillServiceImp implements BillService {

	@Autowired
	BillDao billDao;

	@Override
	public void save(Bill bill) {
		this.billDao.save(bill);
	}

}
