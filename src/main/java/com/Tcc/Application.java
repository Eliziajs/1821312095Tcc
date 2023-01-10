package com.tcc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.domain.Genero;
import com.tcc.repository.GeneroRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GeneroRepository generoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Genero gen1 = new Genero(null, "Drama Policial");
		Genero gen2 = new Genero(null, "Terror");

		generoRepository.saveAll(Arrays.asList(gen1, gen2));

	}

}
