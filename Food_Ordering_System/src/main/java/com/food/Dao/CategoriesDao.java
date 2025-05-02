package com.food.Dao;
import java.util.List;
import com.food.entity.Categories;

public interface CategoriesDao {
	Categories createCategories(Categories categories);	
	Categories getCategories(String catID);
	List<Categories> getAllCategories();
	Categories updateCategories(String catId, Categories categories);
	String deleteCategories(String id);
}
