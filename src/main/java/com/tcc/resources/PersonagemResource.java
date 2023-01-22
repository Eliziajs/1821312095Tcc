package com.tcc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Personagem;
import com.tcc.services.PersonagemService;

@RestController
@RequestMapping(value = "/personagem")
public class PersonagemResource {

	@Autowired
	private PersonagemService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Personagem>> find(@PathVariable Integer id) {
		Optional<Personagem> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
