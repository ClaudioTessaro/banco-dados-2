package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Animal;

public class AnimalDAO implements GenericDAO<Animal> {

	private Connection con;

	public void inserir(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_compra, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setDouble(3, animal.getPeso());
		statement.setDouble(4, animal.getAltura());
		statement.setDate(5, (Date) animal.getDataUltimaMedicacao());
		statement.setString(6, animal.getRaca());
		statement.setDouble(7, animal.getPrecoCompra());
		statement.setDouble(8, animal.getPrecoVenda());
		statement.setDate(9, (Date) animal.getDataNascimento());

		statement.execute();

		con.close();

	}

	public void inserirSemPesoAlturaEMedicacao(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, raca, preco_compra, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setString(3, animal.getRaca());
		statement.setDouble(4, animal.getPrecoCompra());
		statement.setDouble(5, animal.getPrecoVenda());
		statement.setDate(6, (Date) animal.getDataNascimento());

		statement.execute();

		con.close();

	}

	public void inserirSemPrecoVenda(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_compra, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setString(3, animal.getRaca());
		statement.setDouble(4, animal.getPrecoCompra());
		statement.setDate(5, (Date) animal.getDataNascimento());

		statement.execute();

		con.close();

	}

	public void inserirSemPrecoCompra(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setDouble(3, animal.getPeso());
		statement.setDouble(4, animal.getAltura());
		statement.setDate(5, (Date) animal.getDataUltimaMedicacao());
		statement.setString(6, animal.getRaca());
		statement.setDouble(7, animal.getPrecoVenda());
		statement.setDate(8, (Date) animal.getDataNascimento());

		statement.execute();

		con.close();

	}

	public void inserirSemPrecoCompraEVenda(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setDouble(3, animal.getPeso());
		statement.setDouble(4, animal.getAltura());
		statement.setDate(5, (Date) animal.getDataUltimaMedicacao());
		statement.setString(6, animal.getRaca());
		statement.setDate(7, (Date) animal.getDataNascimento());

		statement.execute();

		con.close();

	}
	
	public void inserirSemDataNascimento(Animal animal) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_compra, preco_venda) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setDouble(3, animal.getPeso());
		statement.setDouble(4, animal.getAltura());
		statement.setDate(5, (Date) animal.getDataUltimaMedicacao());
		statement.setString(6, animal.getRaca());
		statement.setDouble(7, animal.getPrecoCompra());
		statement.setDouble(8, animal.getPrecoVenda());

		statement.execute();

		con.close();

	}

	public void atualizar(Animal obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deletar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Animal> listarTodos() throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		List<Animal> lista = new ArrayList<Animal>();
		String sql = "Select * from animal";
		PreparedStatement preparador = con.prepareStatement(sql);
		ResultSet resultados = preparador.executeQuery();
		while(resultados.next()) {
			Animal ani = new Animal();
			ani.setAltura(resultados.getDouble("altura"));
			ani.setDataNascimento(resultados.getDate("data_nascimento"));
			ani.setDataUltimaMedicacao(resultados.getDate("data_ultima_medicao"));
			ani.setPeso(resultados.getDouble("peso"));
			ani.setPrecoCompra(resultados.getDouble("preco_compra"));
			ani.setPrecoVenda(resultados.getDouble("preco_venda"));
			ani.setRaca(resultados.getString("raca"));
			ani.setRegistro(resultados.getInt("registro_id"));
			ani.setTipo(resultados.getString("tipo"));
		}
		
		return lista;
	}

	public Animal buscarPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
