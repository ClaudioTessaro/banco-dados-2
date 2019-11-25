package br.com.cesed.petShop.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.petShop.Dao.VendaAnimalDAO;
import br.com.cesed.petShop.Dao.VendaAnimalDAO;
import br.com.cesed.petShop.modelo.VendaAnimal;
import br.com.cesed.petShop.modelo.VendaAnimal;

@Service
public class VendaAnimalService {
	
	@Autowired
	private VendaAnimalDAO dao;
	
	public List<VendaAnimal> buscarTodos() throws SQLException{
		return dao.listarTodos();
	}
	
	public List<VendaAnimal> buscarTodosPorDescricao(String descricao) throws SQLException{
		return dao.listarTodosPorDescricao(descricao);
	}
	
	public List<VendaAnimal> buscarTodosPorVendedor(String nome) throws SQLException{
		return dao.listarTodosPorNomeVendedor(nome);
	}
	
	
	public void deletar(Integer notaFiscal) throws SQLException {
		dao.deletar(notaFiscal);
	}
	
	public void inserir(VendaAnimal venda) throws SQLException {
		dao.inserir(venda);
	}
	
	public void inserirSemDesconto(VendaAnimal venda) throws SQLException {
		dao.inserirSemDesconto(venda);
	}
	
	public void alterarNota(VendaAnimal venda, Long id) {
		dao.atualizarNotaFiscal(venda, id);
	}
	
	public void alterarRegAnimal(VendaAnimal venda, Long id) {
		dao.atualizarRegAnimal(venda, id);
	}
	
	public void alterarMatricula(VendaAnimal venda, Long id) {
		dao.atualizarMatricula(venda, id);
	}
	
	public void alterarDiaMesAno(VendaAnimal venda, Long id) {
		dao.atualizarDiaMesAno(venda, id);
	}

}
