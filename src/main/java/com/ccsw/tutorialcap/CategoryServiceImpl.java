package com.ccsw.tutorialcap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorialcap.category.CategoryRepository;
import com.ccsw.tutorialcap.category.model.CategoryDto;
import com.ccsw.tutorialcap.model.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
    public List<Category> findAll() {

          return (List<Category>) this.categoryRepository.findAll();
    }
	
	@Override
    public void save(Long id, CategoryDto dto) {

          Category category;

          if (id == null) {
             category = new Category();
          } else {
             category = this.categoryRepository.findById(id).orElse(null);
          }

          category.setName(dto.getName());

          this.categoryRepository.save(category);
    }
	
	@Override
    public void delete(Long id) throws Exception {

          if(this.categoryRepository.findById(id).orElse(null) == null){
             throw new Exception("Not exists");
          }

          this.categoryRepository.deleteById(id);
    }
}
