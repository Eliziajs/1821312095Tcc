package com.tcc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.domain.Filme;
import com.tcc.services.FilmeService;


//fazer lista:
//somente de filmes
//filmes e lista de filmes completos ( ja tem)

@Controller
@RequestMapping(value="/filme")
public class FilmeResource {
	
	@Autowired
	private FilmeService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Filme>> find(@PathVariable Integer id) {
		Optional<Filme> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}
	@GetMapping
	public ResponseEntity<List<Filme>> getAll() {
		ResponseEntity<List<Filme>> obj = service.listarTodos();
		return obj;
	}
}
