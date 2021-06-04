package br.com.osvaldsoza;

import java.math.BigDecimal;

public class CadastrarProdutoDTO {
	
	private String nome;
	
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
