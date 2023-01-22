package com.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.domain.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
	

}
