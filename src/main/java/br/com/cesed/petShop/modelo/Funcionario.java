package br.com.cesed.petShop.modelo;

import java.io.Serializable;
import java.sql.Date;

public class Funcionario implements Serializable{

	private static final long serialVersionUID = -9221680041271395993L;
	
	private Long matricula;
	
	private String nome;
	
	private String cpf;
	
	private String endereco;
	
	private String telefone;
	
	private Double salario;
	
	private Date dtNascimento;
	
	private Date dtAdmissao;
	
	private String funcao;
	
	private Date dtDemissao;

	


	public Long getMatricula() {
		return matricula;
	}



	public String getNome() {
		return nome;
	}



	public String getCpf() {
		return cpf;
	}



	public String getEndereco() {
		return endereco;
	}



	public String getTelefone() {
		return telefone;
	}



	public Double getSalario() {
		return salario;
	}



	public Date getDtNascimento() {
		return dtNascimento;
	}



	public Date getDtAdmissao() {
		return dtAdmissao;
	}



	public String getFuncao() {
		return funcao;
	}



	public Date getDtDemissao() {
		return dtDemissao;
	}



	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public void setSalario(Double salario) {
		this.salario = salario;
	}



	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}



	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}



	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}
	
	
}
