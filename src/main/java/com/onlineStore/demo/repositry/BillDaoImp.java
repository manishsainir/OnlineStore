package com.onlineStore.demo.repositry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineStore.demo.model.Bill;

@Repository
public class BillDaoImp implements BillDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Bill bill) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bill);
	}

}
