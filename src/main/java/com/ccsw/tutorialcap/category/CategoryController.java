package com.ccsw.tutorialcap.category;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorialcap.CategoryService;
import com.ccsw.tutorialcap.category.model.CategoryDto;
import com.ccsw.tutorialcap.model.Category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Category", description="API of Category")
@RestController
@RequestMapping(value="/category")
@CrossOrigin(origins="*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	ModelMapper mapper;
	
	//Método para recuperar todas las categorías
	@Operation(summary="Find", description="Method that return a list of Categories")
	@GetMapping(path="")
	public List<CategoryDto> findAll() {
		
		List<Category> categories = this.categoryService.findAll();
		
		return categories.stream().map(e-> mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
	}
	
	//Método para crear o actualizar una categoría
	@Operation(summary="Save or Update", description="Method that saves or updates a Category")
	//Dos rutas, una para crear y otra para modificar
	@PutMapping(path= {"","/{id}"})
	public void save(@PathVariable(name="id", required=false)Long id, @RequestBody CategoryDto dto) {
		this.categoryService.save(id, dto);
	}
	
	//Método para borrar una categoría
	@Operation(summary="Delete", description="Method that deletes a Category")
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id")Long id) throws Exception {
		
		this.categoryService.delete(id);
	}
}
