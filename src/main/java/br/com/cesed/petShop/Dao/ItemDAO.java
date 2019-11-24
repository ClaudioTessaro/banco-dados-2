package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Item;

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
			statement.setDate(6, (Date) item.getValidade());
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
			statement.setDate(5, (Date) item.getValidade());
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
		// TODO Auto-generated method stub
		return null;
	}

	public Item buscarPorId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
