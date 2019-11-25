package br.com.cesed.petShop.modelo;

import java.io.Serializable;

public class VendaItem implements Serializable {
	
	private static final long serialVersionUID = 6761095020900303839L;
	
	private Long notaFiscal;
	
	private Integer matricula;
	
	private Integer cod_item;
	
	private Integer dia;
	
	private Integer mes;
	
	private Integer ano;
	
	private double comissao;
	
	private double desconto;

	private double valorFinal;

	public Long getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public Integer getCod_item() {
		return cod_item;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public void setCod_item(Integer cod_item) {
		this.cod_item = cod_item;
	}

}
