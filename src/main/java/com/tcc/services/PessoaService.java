package com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.domain.Ator;
import com.tcc.domain.Pessoa;
import com.tcc.repository.AtorRepository;
import com.tcc.repository.PessoaRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Optional<Pessoa> buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Pessoa ainda não cadastrado! Id:" + id + ", Tipo: " + Pessoa.class.getName())));
	}
}
