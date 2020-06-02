package com.onlineStore.demo.service;

import java.util.List;

import com.onlineStore.demo.model.Product;

public interface ProductService {

	List<Product> getProducts();

	List<Product> searchById(String productId);

}
