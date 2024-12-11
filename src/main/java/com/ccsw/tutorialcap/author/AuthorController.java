package com.ccsw.tutorialcap.author;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorialcap.author.model.Author;
import com.ccsw.tutorialcap.author.model.AuthorDto;
import com.ccsw.tutorialcap.author.model.AuthorSearchDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Author", description = "API of Author")
@RequestMapping(value = "/author")
@RestController
@CrossOrigin(origins = "*")
public class AuthorController {
	
	@Autowired
    AuthorService authorService;
	
	@Autowired
    ModelMapper mapper;
	
	//Método para recuperar un listado paginado de {@link Author}
	@Operation(summary="Find Page", description="Method that return a page of Authors")
	@PostMapping(path="")
	public Page<AuthorDto> findPage(@RequestBody AuthorSearchDto dto) {
		Page<Author> page = this.authorService.findPage(dto);

        return new PageImpl<>(page.getContent().stream().map(e -> mapper.map(e, AuthorDto.class)).collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
	}
	
	//Método para crear o actualizar un autor
	
	@Operation(summary="Save or Update", description="Method that saves or update a Author")
	@PutMapping(path = {"", "/{id}"})
	public void save (@PathVariable(name="id", required=false) Long id, @RequestBody AuthorDto dto) {
		this.authorService.save(id, dto);
	}
	
	//Método para borrar un autor
	
	@Operation(summary="Delete", description="Method that deletes a Author")
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") Long id) throws Exception {
		this.authorService.delete(id);
	}
}
