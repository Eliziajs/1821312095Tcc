package com.tcc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Ator;
import com.tcc.domain.Pessoa;
import com.tcc.services.AtorService;
import com.tcc.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> find(@PathVariable Integer id) {
		Optional<Pessoa> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
