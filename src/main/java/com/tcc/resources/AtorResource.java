package com.tcc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Ator;
import com.tcc.services.AtorService;

@RestController
@RequestMapping(value = "/ator")
public class AtorResource {

	@Autowired
	private AtorService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ator>> find(@PathVariable Integer id) {
		Optional<Ator> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
