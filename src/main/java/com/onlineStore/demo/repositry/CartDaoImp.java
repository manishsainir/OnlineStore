package com.onlineStore.demo.repositry;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineStore.demo.model.Cart;

@Repository
public class CartDaoImp implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addToCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	@Override
	public List<Cart> searchById(String registerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Cart> q = session.createQuery("from Cart where registerId='" + registerId + "' and buy=" + false);
		List<Cart> cart = q.list();
		return cart;
	}

}
