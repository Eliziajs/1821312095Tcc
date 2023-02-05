package com.tcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
	@Column(name = "tipo")
	private int tipo;
	@Column(name = "status")
	private int status; // ver jakarta transtion
	@Column(name = "dataCadastro")
	private Date dataCadastro = new Date();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PESSOA_FILME", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "filme_id"))
	private List<Filme> filmes = new ArrayList<>();

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "PESSOA_MENSAGEM", joinColumns = @JoinColumn(name = "pessoam_id"), inverseJoinColumns = @JoinColumn(name = "mensagem_id"))
	private List<Mensagem> mensagens = new ArrayList<>();

	/**public Pessoa(Integer id, String nome, Date nascimento, String email, String login, String senha, int tipo,
			int status, List<Filme> filmes, List<Mensagem> mensagens, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		this.status = status;
		this.filmes = filmes;
		this.mensagens = mensagens;
		this.dataCadastro = dataCadastro;
	}**/

	public Pessoa(List<Mensagem> mensagens) {
		super();
		this.mensagens = mensagens;
	}

	public Pessoa() {

	}

	public Pessoa(Integer id, String nome, Date nascimento, String email, String login, String senha, TipoCliente tipo,
			Status status, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo.getCod();
		this.status = status.getCod();
		this.dataCadastro = dataCadastro;

		// Para pegar o tipo int preciso acessar o getCod() - tipo.getCod()
	}
	
	public Pessoa(String nome, Date nascimento, String email, String login, String senha, TipoCliente tipo,
			Status status) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo.getCod();
		this.status = status.getCod();
		

		// Para pegar o tipo int preciso acessar o getCod() - tipo.getCod()
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

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
		// chama o metodo statico do enum
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
