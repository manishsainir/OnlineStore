package com.onlineStore.demo.repositry;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineStore.demo.model.Product;

@Repository
public class ProductDaoImp implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> q = session.createQuery("from Product");
		List<Product> list = q.list();
		return list;
	}

	@Override
	public List<Product> searchById(String productId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> q = session.createQuery("from Product where productId=" + productId);
		List<Product> list = q.list();
		return list;
	}

}
