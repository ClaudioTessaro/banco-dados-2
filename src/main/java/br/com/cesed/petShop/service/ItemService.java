package br.com.cesed.petShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.petShop.Dao.ItemDAO;
import br.com.cesed.petShop.modelo.Item;

@Service
public class ItemService {

	@Autowired
	private ItemDAO dao;

	public void inserirItem(Item item) {
		dao.inserir(item);
	}

	public void inserirSemValidade(Item item) {
		dao.inserirSemValidade(item);
	}

	public void inserirSemPrecoLoja(Item item) {
		dao.inserirSemPrecoLoja(item);
	}

	public void deletarPorCodigo(Integer codigo) {
		dao.deletar(codigo);
	}

	public void alterarPrecoFornecedor(Item item, Long id) throws Exception {
		dao.atualizarPrecoFornecedor(item, id);
	}

	public void alterarPrecoLoja(Item item, Long id) throws Exception {
		dao.atualizarPrecoLoja(item, id);
	}

	public void alterarPrecoFornecedorLoja(Item item, Long id) throws Exception {
		dao.atualizarPrecoFornecedorPrecoLoja(item, id);
	}

	public void alterarDescricaoTipo(Item item, Long id) throws Exception {
		dao.atualizarDescricaoTipo(item, id);
	}

	public List<Item> buscarTodos() throws Exception {
		return dao.listarTodos();
	}

	public List<Item> buscarTodosPorDescricao(String descricao) throws Exception {
		return dao.listarTodosPorDescricao(descricao);
	}

	public List<Item> buscarTodosPorTipo(String tipo) throws Exception {
		return dao.listarTodosPorTipo(tipo);
	}

}
