package com.onlineStore.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineStore.demo.Dto.Registration;
import com.onlineStore.demo.model.Bill;
import com.onlineStore.demo.model.Cart;
import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Product;
import com.onlineStore.demo.model.Register;
import com.onlineStore.demo.service.BillService;
import com.onlineStore.demo.service.CartService;
import com.onlineStore.demo.service.LoginService;
import com.onlineStore.demo.service.ProductService;
import com.onlineStore.demo.service.RegisterService;

@RestController
@RequestMapping(value = "/onlineStore", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MainResource {

	@Autowired
	LoginService loginService;

	@Autowired
	ProductService productService;

	@Autowired
	RegisterService registerService;

	@Autowired
	CartService cartServie;

	@Autowired
	BillService billService;

	@PostMapping(value = "/register")
	public String insert(@RequestBody Registration registration) {
		Login login = registration.getLogin();
		Register register = registration.getRegister();
		register.setLoginId(login);
		this.loginService.insert(register);
		return "you have registered successfully!!";
	}

	@PostMapping(value = "/login")
	public String verify(@RequestBody Login login) {
		boolean verify = this.loginService.verify(login);
		if (verify)
			return "you have login successfully!!";
		else
			return "you have entered wrong username or password";
	}

	@GetMapping(value = "/getProducts")
	public List<Product> getProducts() {
		List<Product> list = this.productService.getProducts();
		return list;
	}

	@PostMapping(value = "/{registerId}/addToCart/{productId}/{quantity}")
	public String addToCart(@PathVariable("registerId") String registerId, @PathVariable("productId") String productId,
			@PathVariable("quantity") int quantity) {

		List<Register> list = this.registerService.searchById(registerId);
		List<Product> product = this.productService.searchById(productId);
		Cart cart = new Cart();
		cart.setRegisterId(list.get(0));
		cart.setProductId(product.get(0));
		cart.setQuantity(quantity);
		cart.setBuy(false);
		this.cartServie.addToCart(cart);
		return "product is added in your cart..";
	}

	@GetMapping(value = "/generateBill/{registerId}")
	public List<Object> generateBill(@PathVariable("registerId") String registerId) {
		List<Cart> cart = this.cartServie.searchById(registerId);
		List<Object> list2 = new ArrayList<Object>();
		if (cart.size() > 0) {
			List<Register> list = this.registerService.searchById(registerId);
			int totalAmount = 0;
			Cart cart2 = new Cart();
			for (int i = 0; i < cart.size(); i++) {
				cart2 = cart.get(i);
				totalAmount += cart2.getProductId().getProductPrice() * cart2.getQuantity();
				cart2.setBuy(true);
				this.cartServie.addToCart(cart2);
			}
			Bill bill = new Bill();
			bill.setTotalAmount(totalAmount);
			bill.setRegisterId(list.get(0));
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date d = new Date();
			bill.setDate(dateFormat.format(d));
			this.billService.save(bill);

			list2.add(bill);
			list2.add(cart);
		} else {
			list2.add("You haven't any product in your cart! please add some product in yout cart!!");
		}

		return list2;
	}

}
