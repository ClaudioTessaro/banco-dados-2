package br.com.cesed.petShop.modelo;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable{

	private static final long serialVersionUID = 6761095020900303839L;
	
	private Long id;
	
	private String descricao;
	
	private Double precoFornecedor;
	
	private Double precoLoja;
	
	private String tipo;
	
	private Date validade;
	
	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoFornecedor() {
		return precoFornecedor;
	}

	public void setPrecoFornecedor(Double precoFornecedor) {
		this.precoFornecedor = precoFornecedor;
	}

	public Double getPrecoLoja() {
		return precoLoja;
	}

	public void setPrecoLoja(Double precoLoja) {
		this.precoLoja = precoLoja;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", descricao=" + descricao + ", precoFornecedor=" + precoFornecedor + ", precoLoja="
				+ precoLoja + ", tipo=" + tipo + ", validade=" + validade + ", quantidade=" + quantidade + "]";
	}

	
}
