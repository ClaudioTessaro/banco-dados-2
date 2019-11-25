package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Animal;

@Repository
public class AnimalDAO implements GenericDAO<Animal> {

	private Connection con;

	public void inserir(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id,tipo, peso, altura, data_ultima_medicao, raca, preco_compra, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setDouble(3, animal.getPeso());
			statement.setDouble(4, animal.getAltura());
			statement.setDate(5, animal.getDataUltimaMedicacao());
			statement.setString(6, animal.getRaca());
			statement.setDouble(7, animal.getPrecoCompra());
			statement.setDouble(8, animal.getPrecoVenda());
			statement.setDate(9, animal.getDataNascimento());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemPesoAlturaEMedicacao(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id, tipo, raca, preco_compra, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setString(3, animal.getRaca());
			statement.setDouble(4, animal.getPrecoCompra());
			statement.setDouble(5, animal.getPrecoVenda());
			statement.setDate(6, animal.getDataNascimento());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemPrecoVenda(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_compra, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setString(3, animal.getRaca());
			statement.setDouble(4, animal.getPrecoCompra());
			statement.setDate(5,animal.getDataNascimento());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemPrecoCompra(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_venda, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setDouble(3, animal.getPeso());
			statement.setDouble(4, animal.getAltura());
			statement.setDate(5, (Date) animal.getDataUltimaMedicacao());
			statement.setString(6, animal.getRaca());
			statement.setDouble(7, animal.getPrecoVenda());
			statement.setDate(8, animal.getDataNascimento());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemPrecoCompraEVenda(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, data_nascimento) VALUES(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setDouble(3, animal.getPeso());
			statement.setDouble(4, animal.getAltura());
			statement.setDate(5, animal.getDataUltimaMedicacao());
			statement.setString(6, animal.getRaca());
			statement.setDate(7, animal.getDataNascimento());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirSemDataNascimento(Animal animal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO ANIMAL(registro_id, tipo, peso, altura, data_ultima_medicao, raca, preco_compra, preco_venda) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setDouble(3, animal.getPeso());
			statement.setDouble(4, animal.getAltura());
			statement.setDate(5, animal.getDataUltimaMedicacao());
			statement.setString(6, animal.getRaca());
			statement.setDouble(7, animal.getPrecoCompra());
			statement.setDouble(8, animal.getPrecoVenda());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizar(Animal obj) {
		// TODO Auto-generated method stub

	}

	public void deletar(Integer id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM animal WHERE registro_id = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setLong(1, id);
			prepared.execute();
			prepared.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deletarPorTipo(String tipo) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM animal WHERE tripo = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setString(1, tipo);
			prepared.execute();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Animal> listarTodos() {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Animal> lista = new ArrayList<Animal>();
			String sql = "Select * from animal";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
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
				lista.add(ani);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}
	
	public List<Animal> listarTodosPorTipo(String tipo) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Animal> lista = new ArrayList<Animal>();
			String sql = "Select * from animal where tipo = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, tipo);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
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
				lista.add(ani);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}

	public Animal buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizarPesoAlturaMedicao(Animal animal, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE animal SET peso = ?, altura = ?, data_ultima_medicao = ? WHERE registro_id = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, animal.getPeso());
		statement.setDouble(2, animal.getAltura());
		statement.setDate(3, animal.getDataUltimaMedicacao());
		statement.setLong(4, id);

		statement.execute();

		statement.close();

	}

	public void atualizarPesoDataAtualizacao(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET peso = ?, data_ultima_medicao = ? WHERE registro_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, animal.getPeso());
			statement.setDate(2, animal.getDataUltimaMedicacao());
			statement.setLong(3, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarAlturaDataMedicao(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET altura = ?, data_ultima_medicao = ? WHERE registro_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, animal.getAltura());
			statement.setDate(2, animal.getDataUltimaMedicacao());
			statement.setLong(3, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarVenda(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET preco_venda = ? WHERE registro_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, animal.getPrecoVenda());
			statement.setLong(2, id);
			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarCompra(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET preco_compra = ? WHERE registro_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, animal.getPrecoCompra());
			statement.setLong(2, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarCompraVenda(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET preco_compra = ?, preco_venda =? WHERE registro_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, animal.getPrecoCompra());
			statement.setDouble(2, animal.getPrecoVenda());
			statement.setLong(3, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarTipo(Animal animal, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE animal SET tipo = ? WHERE registro_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, animal.getTipo());
			statement.setLong(2, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarRaca(Animal animal, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE animal SET raca = ? WHERE registro_id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setLong(2, id);
		statement.execute();
		statement.close();

	}

	public void atualizarTipoRaca(Animal animal, Long id) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE animal SET raca = ?, tipo = ? WHERE registro_id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, animal.getRaca());
		statement.setString(2, animal.getTipo());
		statement.setLong(3, id);
		statement.execute();
		statement.close();

	}

}
