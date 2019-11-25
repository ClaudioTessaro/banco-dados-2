package br.com.cesed.petShop.modelo;

import java.io.Serializable;
import java.sql.Date;

public class Animal implements Serializable{

	private static final long serialVersionUID = 6247594137174030251L;
	
	private Integer registro;
	
	private String tipo;
	
	private Double peso;
	
	private Double altura;
	
	private Date dataUltimaMedicacao;
	
	private Date dataNascimento;
	
	private String raca;
	
	private Double precoCompra;
	
	private Double precoVenda;

	public Integer getRegistro() {
		return registro;
	}

	public String getTipo() {
		return tipo;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getAltura() {
		return altura;
	}

	public Date getDataUltimaMedicacao() {
		return dataUltimaMedicacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getRaca() {
		return raca;
	}


	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void setDataUltimaMedicacao(Date dataUltimaMedicacao) {
		this.dataUltimaMedicacao = dataUltimaMedicacao;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public String toString() {
		return "Animal [registro=" + registro + ", tipo=" + tipo + ", peso=" + peso + ", altura=" + altura
				+ ", dataUltimaMedicacao=" + dataUltimaMedicacao + ", dataNascimento=" + dataNascimento + ", raca="
				+ raca + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + "]";
	}

	
}
