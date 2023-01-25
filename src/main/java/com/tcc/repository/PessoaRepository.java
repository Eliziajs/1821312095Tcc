package com.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
