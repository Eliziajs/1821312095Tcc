package com.tcc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Genero;
import com.tcc.services.GeneroService;

@RestController
@RequestMapping(value = "/genero")
public class GeneroResource {

	@Autowired
	private GeneroService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Genero>> find(@PathVariable Integer id) {
		Optional<Genero> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Genero>> getAll() {
		ResponseEntity<List<Genero>> obj = service.listarTodos();
		return obj;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
