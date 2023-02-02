package com.tcc.resources;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Diretor;
import com.tcc.repository.DiretorRepository;
import com.tcc.services.DiretorService;

@RestController
@RequestMapping(value = "/diretor")
public class DiretorResource {

	@Autowired
	private DiretorService service;
	@Autowired
	private DiretorRepository repo;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Diretor>> find(@PathVariable Integer id) {
		Optional<Diretor> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Diretor>> getAll() {
		ResponseEntity<List<Diretor>> obj = service.listarTodos();
		return obj;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Diretor>> deleteById(@PathVariable Integer id) {

		try {
			repo.deleteById(id);
			return new ResponseEntity<Optional<Diretor>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Diretor>>(HttpStatus.NOT_FOUND);
		}

	}
}
