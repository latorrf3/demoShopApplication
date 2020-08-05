package com.shop.models;

public class OrderDiscount {
	
	private double discountAmount;
	private String discountMsg;
	
	public OrderDiscount(double discountAmount, String discountMsg) {
	
		this.discountAmount = discountAmount;
		this.discountMsg = discountMsg;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDiscountMsg() {
		return discountMsg;
	}

	public void setDiscountMsg(String discountMsg) {
		this.discountMsg = discountMsg;
	}
	
	
	
}
