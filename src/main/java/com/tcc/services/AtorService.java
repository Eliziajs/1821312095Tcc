package com.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcc.domain.Ator;
import com.tcc.repository.AtorRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class AtorService {

	@Autowired
	private AtorRepository repo;

	public Optional<Ator> buscar(Integer id) {
		Optional<Ator> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Ator ainda não cadastrado! Id:" + id + ", Tipo: " + Ator.class.getName())));
	}
	public ResponseEntity<List<Ator>> listarTodos(){
		List<Ator> obj = repo.findAll();
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
}
