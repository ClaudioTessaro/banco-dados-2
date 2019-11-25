package br.com.cesed.petShop.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.petShop.Dao.FuncionarioDAO;
import br.com.cesed.petShop.modelo.Funcionario;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioDAO dao;
	
	public List<Funcionario> buscarTodos(){
		return dao.listarTodos();
	}
	
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		dao.inserir(funcionario);
	}
	
	public void inserirSemSalario(Funcionario funcionario) {
		dao.inserirSemSalario(funcionario);
	}
	
	public void inserirSemTelefone(Funcionario funcionario) {
		dao.inserirSemTelefone(funcionario);
	}
	
	public void atualizarNomePorMatricula(Funcionario funcionario, Long matricula) throws Exception {
		dao.atualizarNome(funcionario, matricula);
	}
	
	public void atualizarNomePorCpf(Funcionario funcionario, String cpf) throws Exception {
		dao.atualizarNome(funcionario, cpf);
	}
	
	public void atualizarEnderecoPorMatricula(Funcionario funcionario, Long matricula) throws Exception {
		dao.atualizarEndereco(funcionario, matricula);
	}
	
	public void atualizarFuncaoPorMatricula(Funcionario funcionario, Long matricula) throws Exception {
		dao.atualizarFuncao(funcionario, matricula);
	}
	
	public void atualizarDataDemissaoPorMatricula(Funcionario funcionario, Long matricula) throws Exception{
		dao.atualizarDataDemissao(funcionario, matricula);
	}
	
	public void deletarPorMatricula(Integer matricula) throws SQLException {
		dao.deletar(matricula);
	}

}
