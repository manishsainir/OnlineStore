package com.onlineStore.demo.repositry;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineStore.demo.model.Register;

@Repository
public class RegisterDaoImp implements RegisterDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Register> searchById(String registerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Register> q = session.createQuery("from Register where registerId=" + registerId);
		List<Register> list = q.list();
		return list;
	}

}
