package com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.domain.Personagem;
import com.tcc.repository.PersonagemRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class PersonagemService {

	@Autowired
	private PersonagemRepository repo;

	public Optional<Personagem> buscar(Integer id) {
		Optional<Personagem> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Personagem ainda não cadastrado! Id:" + id + ", Tipo: " + Personagem.class.getName())));
	}
}
