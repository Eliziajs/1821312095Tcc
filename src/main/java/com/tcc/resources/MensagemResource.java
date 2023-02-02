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

import com.tcc.domain.Mensagem;
import com.tcc.services.MensagemService;

@RestController
@RequestMapping(value = "/mensagem")
public class MensagemResource {

	@Autowired
	private MensagemService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Mensagem>> find(@PathVariable Integer id) {
		Optional<Mensagem> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Mensagem>> getAll() {
		ResponseEntity<List<Mensagem>> obj = service.listarTodos();
		return obj;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
