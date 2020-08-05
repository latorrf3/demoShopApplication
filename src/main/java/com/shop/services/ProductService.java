package com.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.shop.models.Product;

@Service
public class ProductService {
	
	PromotionService promotionService;

	public List<Product> getAllProducts() {
		ArrayList<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product("p001", "Product 1", "description of Product 1", 10.10, "Seller 1"));
		listOfProducts.add(new Product("p002", "Product 2", "description of Product 2", 60.00, "Seller 2"));
		listOfProducts.add(new Product("p003", "Product 3", "description of Product 3", 30.30, "Seller 1"));
		listOfProducts.add(new Product("p004", "Product 4", "description of Product 4", 40.40, "Seller 3"));
		listOfProducts.add(new Product("p005", "Product 5", "description of Product 5", 100.00,"Seller 2"));
		listOfProducts.add(new Product("p006", "Product 6", "description of Product 6", 60.60, "Seller 4"));
		
		return listOfProducts;
	}
	
	public Product getProductById(String id) {
		
		Predicate<Product> byId = p -> p.getId().equalsIgnoreCase(id);
		return filterProduct(byId);
	}

	private Product filterProduct(Predicate<Product> strategy) {
		
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}
		
}
