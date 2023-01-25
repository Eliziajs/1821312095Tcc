package com.tcc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.domain.Ator;
import com.tcc.domain.Diretor;
import com.tcc.domain.Filme;
import com.tcc.domain.Genero;
import com.tcc.domain.Mensagem;
import com.tcc.domain.Personagem;
import com.tcc.domain.Pessoa;
import com.tcc.domain.Status;
import com.tcc.domain.TipoCliente;
import com.tcc.repository.AtorRepository;
import com.tcc.repository.DiretorRepository;
import com.tcc.repository.FilmeRepository;
import com.tcc.repository.GeneroRepository;
import com.tcc.repository.MensagemRepository;
import com.tcc.repository.PersonagemRepository;
import com.tcc.repository.PessoaRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private DiretorRepository diretorRepository;
	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
	private AtorRepository atorRepository;
	@Autowired
	private PersonagemRepository personagemRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private MensagemRepository mensagemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Genero gen1 = new Genero(null, "Drama Policial");
		Genero gen2 = new Genero(null, "Terror");

		Diretor d1 = new Diretor(null, "Tarantino");
		Diretor d2 = new Diretor(null, "Stanley");

		Ator ator1 = new Ator(null, "John Travolta");
		Ator ator2 = new Ator(null, "Jack Nicholson");

		Filme f1 = new Filme(null, "Pulp Fiction", 1994, "Violento demais ", gen1, d1);
		Filme f2 = new Filme(null, "O iluminado", 1980, "vigia em um hotel no Colorado ", gen2, d2);

		Personagem pers1 = new Personagem("Vicente Vegas", f1, ator1);
		Personagem pers2 = new Personagem("Personagem", f2, ator2);

		gen1.getFilmes().addAll(Arrays.asList(f1));
		gen2.getFilmes().addAll(Arrays.asList(f2));

		d1.getFilmes().addAll(Arrays.asList(f1));
		d2.getFilmes().addAll(Arrays.asList(f2));

		ator1.getPersonagem().addAll(Arrays.asList(pers1));
		ator2.getPersonagem().addAll(Arrays.asList(pers2));

		// f1.getPersonagem().add((Personagem) Arrays.asList(ator1));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		Pessoa p1 = new Pessoa(null, "Elizia", sdf.parse("20/09/1980 00:00"), "eliziajs@gmail.com", "Elizia", "$$$$$",
				TipoCliente.ADMINISTRADOR, Status.ATIVO);
		Pessoa p2 = new Pessoa(null, "João", sdf.parse("04/07/1981 00:00"), "joao@xmail.com", "joão", "$$$$$",
				TipoCliente.USUARIO, Status.ATIVO);
		Pessoa p3 = new Pessoa(null, "Jose", sdf.parse("04/07/1983 00:00"), "jose@xmail.com", "Jose", "$$$$$",
				TipoCliente.USUARIO, Status.ATIVO);
		Pessoa p4 = new Pessoa(null, "Maria", sdf.parse("20/11/1999 00:00"), "maria@xmail.com", "Elizia", "$$$$$",
				TipoCliente.USUARIO, Status.INATIVO);

		Mensagem msg1 = new Mensagem(null, "Nada a ver essa sinpse #$*:(", sdf.parse("04/12/2022 00:00"));
		Mensagem msg2 = new Mensagem(null, "Esse filme é muito sinistro", sdf.parse("10/01/2023 00:00"));

		p2.getFilmes().addAll(Arrays.asList(f1));
		p4.getFilmes().addAll(Arrays.asList(f2));

		msg1.getPessoas().addAll(Arrays.asList(p2));
		msg2.getPessoas().addAll(Arrays.asList(p3));

		p4.getMensagens().addAll(Arrays.asList(msg2));
		p1.getMensagens().addAll(Arrays.asList(msg1));


		generoRepository.saveAll(Arrays.asList(gen1, gen2));
		diretorRepository.saveAll(Arrays.asList(d1, d2));
		filmeRepository.saveAll(Arrays.asList(f1, f2));
		atorRepository.saveAll(Arrays.asList(ator1, ator2));
		personagemRepository.saveAll(Arrays.asList(pers1, pers2));
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		mensagemRepository.saveAll(Arrays.asList(msg1, msg2));

	}

}
