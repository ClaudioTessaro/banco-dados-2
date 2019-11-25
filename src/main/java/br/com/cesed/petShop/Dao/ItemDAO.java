package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Item;

@Repository
public class ItemDAO implements GenericDAO<Item> {

	private Connection con;

	public void inserir(Item item) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Item(codigo, descricao,tipo,preco_fornecedor,preco_loja,validade,quantidade) VALUES(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, item.getId());
			statement.setString(2, item.getDescricao());
			statement.setString(3, item.getTipo());
			statement.setDouble(4, item.getPrecoFornecedor());
			statement.setDouble(5, item.getPrecoLoja());
			statement.setDate(6,  item.getValidade());
			statement.setInt(7, item.getQuantidade());
			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemValidade(Item item) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Item(codigo, descricao,tipo,preco_fornecedor,preco_loja,quantidade) VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, item.getId());
			statement.setString(2, item.getDescricao());
			statement.setString(3, item.getTipo());
			statement.setDouble(4, item.getPrecoFornecedor());
			statement.setDouble(5, item.getPrecoLoja());
			statement.setInt(6, item.getQuantidade());
			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemPrecoLoja(Item item) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Item(codigo, descricao,tipo,preco_fornecedor,validade,quantidade) VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, item.getId());
			statement.setString(2, item.getDescricao());
			statement.setString(3, item.getTipo());
			statement.setDouble(4, item.getPrecoFornecedor());
			statement.setDate(5,  item.getValidade());
			statement.setInt(6, item.getQuantidade());
			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deletar(Integer id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM item WHERE codigo = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setLong(1, id);
			prepared.execute();
			prepared.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void atualizarPrecoFornecedor(Item item, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE item SET preco_fornecedor = ? WHERE codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, item.getPrecoFornecedor());
		statement.setDouble(2, id);
		statement.execute();
		statement.close();

	}
	
	public void atualizarPrecoLoja(Item item, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE item SET preco_loja = ? WHERE codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, item.getPrecoLoja());
		statement.setDouble(2, id);
		statement.execute();
		statement.close();

	}
	
	public void atualizarPrecoFornecedorPrecoLoja(Item item, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE item SET preco_fornecedor = ?, preco_loja = ? WHERE codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, item.getPrecoFornecedor());
		statement.setDouble(2, item.getPrecoLoja());
		statement.setDouble(3, id);
		statement.execute();
		statement.close();

	}
	
	public void atualizarDescricaoTipo(Item item, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE item SET descricao = ?, tipo = ? WHERE codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, item.getDescricao());
		statement.setString(2, item.getTipo());
		statement.setDouble(3, id);
		statement.execute();
		statement.close();

	}
	

	public List<Item> listarTodos() throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Item> lista = new ArrayList<Item>();
			String sql = "Select * from item";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Item item = new Item();
				item.setId(resultados.getLong("codigo"));
				item.setDescricao(resultados.getString("descricao"));
				item.setTipo(resultados.getString("tipo"));
				item.setPrecoFornecedor(resultados.getDouble("preco_fornecedor"));
				item.setPrecoLoja(resultados.getDouble("preco_loja"));
				item.setQuantidade(resultados.getInt("quantidade"));
				item.setValidade(resultados.getDate("validade"));
				lista.add(item);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}
	
	public List<Item> listarTodosPorDescricao(String descricao) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Item> lista = new ArrayList<Item>();
			String sql = "Select * from item where descricao = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, descricao);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Item item = new Item();
				item.setId(resultados.getLong("codigo"));
				item.setDescricao(resultados.getString("descricao"));
				item.setTipo(resultados.getString("tipo"));
				item.setPrecoFornecedor(resultados.getDouble("preco_fornecedor"));
				item.setPrecoLoja(resultados.getDouble("preco_loja"));
				item.setQuantidade(resultados.getInt("quantidade"));
				item.setValidade(resultados.getDate("validade"));
				lista.add(item);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}
	
	public List<Item> listarTodosPorTipo(String tipo) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Item> lista = new ArrayList<Item>();
			String sql = "Select * from item where tipo = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, tipo);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Item item = new Item();
				item.setId(resultados.getLong("codigo"));
				item.setDescricao(resultados.getString("descricao"));
				item.setTipo(resultados.getString("tipo"));
				item.setPrecoFornecedor(resultados.getDouble("preco_fornecedor"));
				item.setPrecoLoja(resultados.getDouble("preco_loja"));
				item.setQuantidade(resultados.getInt("quantidade"));
				item.setValidade(resultados.getDate("validade"));
				lista.add(item);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}

	public Item buscarPorId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
