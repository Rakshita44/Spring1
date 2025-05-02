package com.food.service;
import java.util.List;
import com.food.entity.Food;

public interface FoodService {
	Food createFood(Food food);	
	Food getFood(String foodID);
	//List<Food> getFoodByCategoryId(String categoryId);
	List<Food> getAllFoods();
	Food updateFood(String fId, Food fd);
	String deleteFood(String id);}
