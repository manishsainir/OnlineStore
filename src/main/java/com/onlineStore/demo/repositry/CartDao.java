package com.onlineStore.demo.repositry;

import java.util.List;

import com.onlineStore.demo.model.Cart;

public interface CartDao {

	void addToCart(Cart cart);

	List<Cart> searchById(String registerId);

}
