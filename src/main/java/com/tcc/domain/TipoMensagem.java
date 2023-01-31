package com.tcc.domain;

public enum TipoMensagem {

		COMENTARIO(1, "comentario"), RESPOSTA(2, "resposta"), DENUNCIA(3, "DENUNCIA");

		private int cod;
		private String descricao;

		private TipoMensagem(int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;

		}

		public int getCod() {
			return cod;
		}

		public String getDescricao() {
			return descricao;
		}

		public static TipoMensagem toEnum(Integer cod) {
			if (cod == null)
				return null;
			for (TipoMensagem x : TipoMensagem.values()) {
				if (cod.equals(x.getCod()))
					return x;
			}
			throw new IllegalArgumentException("Código Inválido" + cod);
		}


}
