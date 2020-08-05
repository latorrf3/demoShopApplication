package com.shop.models;

public class Item {

	private Product product;
	private int quantity;
	private double subTotal;
	
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.subTotal = this.getSubTotal(); 
	}
		
	public Item(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
		this.subTotal = this.getSubTotal();
	}

	public Item() {
		super();
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		subTotal = product.getPrice() * quantity;
		
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
