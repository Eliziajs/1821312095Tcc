package com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcc.domain.Filme;
import com.tcc.repository.FilmeRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository repo;
	
	public Optional<Filme> buscar(@PathVariable Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				" Filme ainda não cadastrado! Id:" + id + ", Tipo: " + Filme.class.getName())));

	}
}