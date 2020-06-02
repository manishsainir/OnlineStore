package com.onlineStore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineStore.demo.model.Product;
import com.onlineStore.demo.repositry.ProductDao;

@Service
@Transactional
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		
		return this.productDao.getProducts();
	}

	@Override
	public List<Product> searchById(String productId) {
		List<Product> list = this.productDao.searchById(productId); 
		return list;
	}

}
