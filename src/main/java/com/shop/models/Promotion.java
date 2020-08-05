package com.shop.models;

public class Promotion {

	private String promotionId;
	private String promotionType;
	private double discount;
	private int quantity;
	
	public Promotion(String promotionId, String promotionType, double discount, int quantity) {
		super();
		this.promotionId = promotionId;
		this.promotionType = promotionType;
		this.discount = discount;
		this.quantity = quantity;
	}

	public Promotion(String promotionId, String promotionType, double discount) {
		super();
		this.promotionId = promotionId;
		this.promotionType = promotionType;
		this.discount = discount;
	}

	public String getPromotionId() {
		return promotionId;
	}
	
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	
	public String getPromotionType() {
		return promotionType;
	}
	
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
