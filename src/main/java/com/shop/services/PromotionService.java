package com.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.shop.models.Promotion;

@Service
public class PromotionService {
	
	public List<Promotion> getAllPromotions() {
		List<Promotion> listOfPromotions = new ArrayList<>();
		listOfPromotions.add(new Promotion("promr10", "relative", 10.00));
		listOfPromotions.add(new Promotion("promr25", "relative", 25.00));
		listOfPromotions.add(new Promotion("promr50", "relative", 50.00));
		listOfPromotions.add(new Promotion("proma10", "absolute", 10.00, 3));
		listOfPromotions.add(new Promotion("proma20", "absolute", 20.00, 2));
		
		return listOfPromotions;
	}
	
	public Promotion getPromotionById(String promotionId) {
		
		Predicate<Promotion> byId = pr -> pr.getPromotionId().equalsIgnoreCase(promotionId);
		return filterPromotion(byId);
	}
	
	private Promotion filterPromotion(Predicate<Promotion> strategy) {
		
		return getAllPromotions().stream().filter(strategy).findFirst().orElse(null);
	}

}
