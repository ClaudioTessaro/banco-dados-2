package br.com.cesed.petShop.Dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void inserir(T obj) throws Exception;
	
	void atualizar(T obj) throws Exception;
	
	void deletar(Integer id) throws Exception;
	
	List<T> listarTodos() throws Exception;
	
	T buscarPorId(Integer id) throws Exception;

}
