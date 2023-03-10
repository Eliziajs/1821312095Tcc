package com.tcc.domain;

public enum Status {

	ATIVO(1, "administrador"),
	INATIVO(2, "editor"), 
	REMOVIDO(3, "usuário");

	private int cod;
	private String descricao;

	private Status(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;

	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (Status x : Status.values()) {
			if (cod.equals(x.getCod()))
				return x;

		}
		throw new IllegalArgumentException("Código Inválido" + cod);
	}

}
