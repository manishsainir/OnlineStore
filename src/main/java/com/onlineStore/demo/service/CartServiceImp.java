package com.onlineStore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineStore.demo.model.Cart;
import com.onlineStore.demo.repositry.CartDao;

@Service
@Transactional
public class CartServiceImp implements CartService {

	@Autowired
	CartDao cartDao;

	@Override
	public void addToCart(Cart cart) {
		this.cartDao.addToCart(cart);
	}

	@Override
	public List<Cart> searchById(String registerId) {
		List<Cart> cart = cartDao.searchById(registerId);
		return cart;
	}

}
