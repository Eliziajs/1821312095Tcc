package com.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tcc.domain.Diretor;
import com.tcc.repository.DiretorRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class DiretorService {

	@Autowired
	DiretorRepository repo;

	public Optional<Diretor> buscar(Integer id) {
		Optional<Diretor> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Diretor ainda não cadastrado! Id:" + id + ", Tipo: " + Diretor.class.getName())));

	}

	public ResponseEntity<List<Diretor>> listarTodos() {
		List<Diretor> obj = repo.findAll();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);

	}
	
}
