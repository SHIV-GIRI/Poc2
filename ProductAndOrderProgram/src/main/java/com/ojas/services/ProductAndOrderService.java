package com.ojas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.models.Orders;
import com.ojas.models.Products;
import com.ojas.repositories.OrderDao;
import com.ojas.repositories.ProductDao;

@Service
public class ProductAndOrderService {

	@Autowired
	private ProductDao productdao;

	// createProduct method
	public Products createProduct(Products product) {
		return productdao.save(product);
	}

	// getAllProducts method
	public Iterable<Products> getProducts() {
		return productdao.findAll();
	}

	// particular product get
	public Optional<Products> getproduct(Integer productId) {
		return productdao.findById(productId);
	}

	@Autowired
	private OrderDao orderdao;

	// createOrder method
	public Orders createOrder(Orders order) {
		return orderdao.save(order);
	}

	// getAllOrders method
	public Iterable<Orders> getOrders() {
		return orderdao.findAll();
	}

	// getOrder method
	public Optional<Orders> getOrder(Integer orderId) {
		return orderdao.findById(orderId);
	}

	// placeOrder method
	public int placeOrder(Integer productId, Integer quantity) {
		int result = 1;
		Optional<Products> product = productdao.findById(productId);
		if (product == null)
			return result;

		Iterable<Orders> orders = orderdao.findAll();
		for (Orders order : orders) {

			if (order.getProducts().getProductId() == productId) {
				order.setQuantity(quantity);
				orderdao.save(order);
				result = 0;
			}
		}

		return result;
	}

	// updateOrder method
	public int updateOrder(Integer id, Integer quantity) {
		int result = 1;
		Orders order = orderdao.findById(id).orElse(new Orders());
		if (order.getOrderId() == 0) {
			return result;
		}

		order.setQuantity(quantity);
		orderdao.save(order);
		result = 0;

		return result;
	}
}
