package com.tcc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.domain.Diretor;
import com.tcc.domain.Filme;
import com.tcc.domain.Genero;
import com.tcc.repository.DiretorRepository;
import com.tcc.repository.FilmeRepository;
import com.tcc.repository.GeneroRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private DiretorRepository diretorRepository;
	@Autowired
	private FilmeRepository filmeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Genero gen1 = new Genero(null, "Drama Policial");
		Genero gen2 = new Genero(null, "Terror");
		
		Diretor d1 = new Diretor(null, "Tarantino");
		Diretor d2 = new Diretor(null, "Stanley");
		
		Filme f1 = new Filme(null, "Pulp Fiction", 1994, "Violento demais ", gen1, d1);
		Filme f2 = new Filme(null, "O iluminado", 1980, "vigia em um hotel no Colorado ", gen2, d2);

		gen1.getFilmes().addAll(Arrays.asList(f1));
		gen2.getFilmes().addAll(Arrays.asList(f2));
		
		d1.getFilmes().addAll(Arrays.asList(f1));
		d2.getFilmes().addAll(Arrays.asList(f2));
		// f2.getGeneros().add(Arrays.asList(gen2));
		
		generoRepository.saveAll(Arrays.asList(gen1, gen2));
		diretorRepository.saveAll(Arrays.asList(d1,d2));
		filmeRepository.saveAll(Arrays.asList(f1, f2));

	}

}
