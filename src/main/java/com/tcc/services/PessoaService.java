package com.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcc.domain.Pessoa;
import com.tcc.repository.PessoaRepository;
import com.tcc.services.exception.ObjetoNaoEncontrado;

/**
 * listar todos( diretor ) buscar por id buscar por nome atualizar deletar por
 * id (diretor- nao funciona, pessoa funciona) salvar no banco de dados
 * 
 * @author EliziaJanuarioDaSilv
 *
 */

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Optional<Pessoa> buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);

		return Optional.ofNullable(obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Pessoa não cadastrada! Id:" + id + ", Tipo: " + Pessoa.class.getName())));
	}

	public ResponseEntity<List<Pessoa>> listarTodos() {
		List<Pessoa> obj = repo.findAll();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);

	}

	public Pessoa criar(Pessoa pessoa) {
	
		return repo.save(pessoa);
	}

}
