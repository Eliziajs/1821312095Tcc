package com.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcc.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
