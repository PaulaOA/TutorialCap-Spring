package com.ccsw.tutorialcap.author;

import org.springframework.data.domain.Page;

import com.ccsw.tutorialcap.author.model.Author;
import com.ccsw.tutorialcap.author.model.AuthorDto;
import com.ccsw.tutorialcap.author.model.AuthorSearchDto;

public interface AuthorService {
   // Método para recuperar un listado paginado de {@link Author}
   Page<Author> findPage(AuthorSearchDto dto);
   
    //Método para crear o actualizar un {@link Author}
   void save(Long id, AuthorDto dto);
   
   //Método para crear o actualizar un {@link Author}
  void delete(Long id) throws Exception;
}
