package br.com.cesed.petShop.Dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	
	void inserir(T obj) throws SQLException;
	
	void deletar(Integer id) throws SQLException;
	
	List<T> listarTodos() throws SQLException;
	
	T buscarPorId(Integer id) throws SQLException;

}
