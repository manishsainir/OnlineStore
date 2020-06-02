package com.onlineStore.demo.repositry;

import java.util.List;

import com.onlineStore.demo.model.Product;

public interface ProductDao {

	List<Product> getProducts();

	List<Product> searchById(String productId);

}
