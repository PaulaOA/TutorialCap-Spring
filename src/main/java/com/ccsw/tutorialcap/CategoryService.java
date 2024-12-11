package com.ccsw.tutorialcap;

import java.util.List;

import com.ccsw.tutorialcap.category.model.CategoryDto;
import com.ccsw.tutorialcap.model.Category;

public interface CategoryService {
	//Método para recuperar todas las categorías
	List<Category> findAll();
	
	//Método para crear o actualizar una categoría
	void save (Long id, CategoryDto dto);
	
	//Método para borrar una categoría
	void delete (Long id) throws Exception;

}
