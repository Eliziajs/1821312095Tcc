package com.tcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "nascimento")
	private Date nascimento;
	@Column(name = "email")
	private String email;
	@Column(name = "login")
	private String login;
	@Column(name = "senha")
	private String senha;
	// private TipoUsuario tipoUsuario;
	// private Status status; // ver jakarta transtion

	@ManyToMany
	@JoinTable(name = "PESSOA_FILME", 
	joinColumns = @JoinColumn(name="pessoa_id"),
	inverseJoinColumns = @JoinColumn(name="filme_id"))

	private List<Filme> filmes = new ArrayList<>();

	public Pessoa() {

	}

	public Pessoa(Integer id, String nome, Date nascimento, String email, String login, String senha,
			TipoUsuario tipoUsuario, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.login = login;
		this.senha = senha;
		// this.tipoUsuario = tipoUsuario;
		// this.status = status;
	}

	public Pessoa(Integer id, String nome, Date nascimento, String email, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * public TipoUsuario getTipoUsuario() { return tipoUsuario; }
	 * 
	 * public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario =
	 * tipoUsuario; }
	 * 
	 * public Status getStatus() { return status; }
	 * 
	 * public void setStatus(Status status) { this.status = status; }
	 **/

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

}
