package com.shop.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Item> cart;
	private List<OrderDiscount> orderDiscounts;
	private double grandTotal;


	public Cart(Cart sessionCart) {
		if (sessionCart == null && this.cart == null) {
			this.cart = new ArrayList<Item>();	
			this.orderDiscounts = new ArrayList<OrderDiscount>();
		} else {
			this.cart = sessionCart.cart;
		}
	}

	public Cart() {
		if (this.cart  == null) {
			this.cart = new ArrayList<Item>();
			this.orderDiscounts = new ArrayList<OrderDiscount>();
		}
	}

	public List<Item> getItems() {
		return cart;
	}
	
	public void setItems(List<Item> cart) {
		this.cart = cart;
	}
	
	public double getGrandTotal() {
		grandTotal = 0.00;
		
		orderDiscounts = new ArrayList<OrderDiscount>();
		
		if (cart.isEmpty()) {
			return 0.00;
		}
		
		for (int i = 0; i < cart.size(); i++) {
			grandTotal = grandTotal + cart.get(i).getSubTotal();
		}		
		
		if (grandTotal >= 100.00) {
			grandTotal = grandTotal - 5.00;
			orderDiscounts.add(new OrderDiscount(-5.00, "Absolute discount of 5.00€"));
		}
		
		if (this.getHowManyProducts() >= 5) {
			double amountDiscount = (-1) * (grandTotal * 5/100);
			grandTotal = grandTotal + amountDiscount;
			orderDiscounts.add(new OrderDiscount(amountDiscount, "Relative discount of 5%"));
		}
		
//		System.out.println(grandTotal);
		return grandTotal;
	}
	
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public Item getItemByProductId(String productId) {
		Item item = null;
		
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId().contentEquals(productId)) {
				item = cart.get(i);
				break;
			}
		}		
		return item;
	}
	
	public List<OrderDiscount> getOrderDiscounts() {
		return orderDiscounts;
	}

	public void setOrderDiscounts(List<OrderDiscount> orderDiscounts) {
		this.orderDiscounts = orderDiscounts;
	}

	public void addItem(Item item, int quantity) {		
		if (cart.isEmpty()) {
			item.setQuantity(quantity);
			cart.add(item);
		} else {
			String productId = item.getProduct().getId();
			Item cartItem = this.getItemByProductId(productId);
			if (cartItem != null) {
				cartItem.setQuantity(cartItem.getQuantity() + quantity);
			} else {
				item.setQuantity(quantity);
				cart.add(item);
			}
		}			
	}
	
	public void removeItem(Item item) {
		String productId = item.getProduct().getId();
		Item cartItem = this.getItemByProductId(productId);
		
		if (cartItem.getQuantity() == 1) {
			cart.remove(cartItem);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() - 1);
		}
	}
	
	public void removeItemByProductID(String productId) {
		Item cartItem = this.getItemByProductId(productId);
		
		if (cartItem.getQuantity() == 1) {
			cart.remove(cartItem);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() - 1);
		}
	}
	
//	public boolean hasPromotion(String productId) {
//		Item cartItem = this.getItemByProductId(productId);
//		String promotionId = cartItem.getProduct().getPromotionId();
//		
//		if (promotionId == null) {
//			return false;
//		} else {
//			return true;
//		}
//	}
	
	public int getHowManyProducts() {
		int quantity = 0;
		if (cart.isEmpty()) {
			return 0;
		} 
		for (int i = 0; i < cart.size(); i++) {
			quantity = quantity + cart.get(i).getQuantity();
		}
		return quantity;
	}
	
}
