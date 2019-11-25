package br.com.cesed.petShop.modelo;

import java.io.Serializable;

public class VendaAnimal implements Serializable {
	
	private static final long serialVersionUID = 6761095020900303839L;
	
	private Integer notaFiscal;
	
	private Integer regAnimal;
	
	private Integer matFunc;
	
	private Integer dia;
	
	private Integer mes;
	
	private Integer ano;
	
	private double comissao;
	
	private double desconto;

	private double valorFinal;
	public int getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(int i) {
		this.notaFiscal = i;
	}

	public Integer getRegAnimal() {
		return regAnimal;
	}

	public void setRegAnimal(Integer regAnimal) {
		this.regAnimal = regAnimal;
	}

	public Integer getMatFunc() {
		return matFunc;
	}

	public void setMatFunc(Integer matFunc) {
		this.matFunc = matFunc;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
	


}
