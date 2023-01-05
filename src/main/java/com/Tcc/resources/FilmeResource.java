package com.tcc.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Genero;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Genero> listar() {
		
		Genero gen = new Genero(1, "Drama Policial"); 
		List<Genero> lista = new ArrayList<>();
		lista.add(gen);
		
		return lista;
	}

}
