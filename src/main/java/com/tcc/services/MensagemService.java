package com.tcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.domain.Mensagem;
import com.tcc.repository.MensagemRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository repo;

	public Optional<Mensagem> buscar(Integer id) {
		Optional<Mensagem> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Mensagem ainda não cadastrado! Id:" + id + ", Tipo: " + Mensagem.class.getName())));
	}
}
