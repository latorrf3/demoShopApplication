package com.shop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.models.Cart;
import com.shop.models.Item;
import com.shop.services.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	@GetMapping("/")
	public String cartIndex(HttpSession session) {
		
		if (session.getAttribute("grandTotal") == null) {
				session.setAttribute("grandTotal", 0.00);
		}
		
		session.setAttribute("currency", "€");
		System.out.println("You are in the cart");
		return "/cart";
	}
	
	@GetMapping("/buy/{productId}")
	public String buy(@PathVariable("productId") String productId, HttpSession session, ModelMap modelMap) {
		modelMap.put("title", "Cart");
		modelMap.put("action", "cart"); 
		
		Cart cart = new Cart((Cart) session.getAttribute("cart"));
		
		cart.addItem(new Item(productService.getProductById(productId)), 1);
		
		session.setAttribute("cart", cart);
		session.setAttribute("grandTotal", cart.getGrandTotal());
		
		System.out.println("Buying product " + productId);
		return "cart";
	}

	@GetMapping("/remove/{productId}")
	public String remove(@PathVariable("productId") String productId, HttpSession session) {
		
		Cart cart = new Cart((Cart) session.getAttribute("cart"));

		cart.removeItemByProductID(productId);
		
		session.setAttribute("cart", cart);
		
		System.out.println("Removing product " + productId);
		return "/cart";
	}

}
