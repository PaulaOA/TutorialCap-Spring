package com.ccsw.tutorialcap.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ccsw.tutorialcap.author.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{
	 
    //Método para recuperar un listado paginado de {@link Author}
    Page<Author> findAll(Pageable pageable);
}
