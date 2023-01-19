package com.tcc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Diretor;
import com.tcc.services.DiretorService;

@RestController
@RequestMapping(value ="/diretor")
public class DiretorResource {
	
	@Autowired
	private DiretorService service;
	
	@GetMapping("/{id}")
	public ResponseEntity <Optional<Diretor>> find (@PathVariable Integer id){
		Optional<Diretor> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
