package com.food.service;
import java.util.List;
import com.food.entity.Categories;

public interface CategoriesService {
	Categories createCategories(Categories categories);	
	Categories getCategories(String catID);
	List<Categories> getAllCategories();
	Categories updateCategories(String catId, Categories categories);
	String deleteCategories(String id);
}
