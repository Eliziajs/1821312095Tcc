package com.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcc.domain.Genero;
import com.tcc.repository.GeneroRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repo;

	public Optional<Genero> buscar(Integer id) {
		Optional<Genero> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Genero ainda não cadastrado! Id:" + id + ", Tipo: " + Genero.class.getName())));
	}
	public ResponseEntity<List<Genero>> listarTodos(){
		List<Genero> obj = repo.findAll();
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
}
