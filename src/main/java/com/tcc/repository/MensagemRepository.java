package com.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.domain.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {

}
