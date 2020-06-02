package com.onlineStore.demo.service;

import java.util.List;

import com.onlineStore.demo.model.Cart;

public interface CartService {

	void addToCart(Cart cart);

	List<Cart> searchById(String registerId);

}
