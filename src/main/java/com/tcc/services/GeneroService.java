package com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.domain.Genero;
import com.tcc.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository repo;
	
	public Optional<Genero> buscar(Integer id) {
		Optional<Genero> obj =repo.findById(id);
		return obj;
		
	}
}

