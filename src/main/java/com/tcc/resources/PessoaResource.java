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

import com.tcc.domain.Pessoa;
import com.tcc.repository.PessoaRepository;
import com.tcc.services.PessoaService;

//fazer lista:
//somente pessoas

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService service;
	@Autowired
	private PessoaRepository repo;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> find(@PathVariable Integer id) {
		Optional<Pessoa> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll() {
		ResponseEntity<List<Pessoa>> obj = service.listarTodos();
		return obj;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> deleteById(@PathVariable Integer id) {

		try {
			repo.deleteById(id);
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}

	}
}
