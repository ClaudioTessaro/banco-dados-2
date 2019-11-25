package br.com.cesed.petShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.petShop.Dao.VendaItemDAO;
import br.com.cesed.petShop.modelo.VendaItem;

@Service
public class VendaItemService {
	
	@Autowired
	private VendaItemDAO dao;
	
	public List<VendaItem> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public List<VendaItem> buscarTodosPorDescricao(String descricao){
		return dao.buscarTodosPorDescricao(descricao);
	}
	
	public List<VendaItem> buscarTodosPorVendedor(String nome){
		return dao.buscarTodosPorVendedor(nome);
	}
	
	public List<VendaItem> buscarTodosPorMesAno(Integer mes, Integer ano){
		return dao.buscarTodosPorAnoMes(ano, mes);
	}
	
	public List<VendaItem> buscarVendasItemFuncionario(Integer matricula, Integer codigo){
		return dao.buscarTodosVendedorItem(matricula, codigo);
	}
	
	public void deletar(Integer notaFiscal) {
		dao.deletarVenda(notaFiscal);
	}
	
	public void inserir(VendaItem venda) {
		dao.inserir(venda);
	}
	
	public void inserirSemDesconto(VendaItem venda) {
		dao.inserirSemDesconto(venda);
	}
	
	public void alterarNota(VendaItem venda, Long id) {
		dao.atualizarNotaFiscal(venda, id);
	}
	
	public void alterarItemCod(VendaItem venda, Long id) {
		dao.atualizarItemCodigo(venda, id);
	}
	
	public void alterarMatricula(VendaItem venda, Long id) {
		dao.atualizarMatricula(venda, id);
	}
	
	public void alterarDiaMesAno(VendaItem venda, Long id) {
		dao.atualizarDiaMesAno(venda, id);
	}

}
