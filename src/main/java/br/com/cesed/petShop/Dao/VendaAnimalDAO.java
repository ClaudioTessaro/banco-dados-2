package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.VendaAnimal;
import br.com.cesed.petShop.modelo.VendaItem;

@Repository
public class VendaAnimalDAO implements GenericDAO<VendaAnimal>{
	private Connection con;

	public void inserir(VendaAnimal obj) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO venda_animal(nota_fiscal, registro_animal,matricula_funcionario,dia,mes,ano,comissao,desconto,valor_final) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, obj.getNotaFiscal());
			statement.setInt(2, obj.getRegAnimal());
			statement.setInt(3, obj.getMatFunc());
			statement.setInt(4, obj.getDia());
			statement.setInt(5, obj.getMes());
			statement.setInt(6, obj.getAno());
			statement.setDouble(7, obj.getComissao());
			statement.setDouble(8, obj.getDesconto());
			statement.setDouble(9, obj.getValorFinal());
			
			statement.execute();

			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void inserirSemDesconto(VendaAnimal obj) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO venda_animal(nota_fiscal, registro_animal,matricula_funcionario,dia,mes,ano,comissao,valor_final) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, obj.getNotaFiscal());
			statement.setInt(2, obj.getRegAnimal());
			statement.setInt(3, obj.getMatFunc());
			statement.setInt(4, obj.getDia());
			statement.setInt(5, obj.getMes());
			statement.setInt(6, obj.getAno());
			statement.setDouble(7, obj.getComissao());
			statement.setDouble(8, obj.getDesconto());
			statement.setDouble(9, obj.getValorFinal());
			
			statement.execute();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(Integer id) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM venda_animal WHERE nota_fiscal = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setInt(1, id);
			prepared.execute();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<VendaAnimal> listarTodos() throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaAnimal> lista = new ArrayList<VendaAnimal>();
			String sql = "Select * from venda_animal";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaAnimal venda = new VendaAnimal();
				venda.setNotaFiscal(resultados.getInt("nota_fiscal"));
				venda.setMatFunc(resultados.getInt("matricula_funcionario"));
				venda.setRegAnimal(resultados.getInt("registro_animal"));
				venda.setAno(resultados.getInt("ano"));
				venda.setMes(resultados.getInt("mes"));
				venda.setDia(resultados.getInt("dia"));
				venda.setComissao(resultados.getDouble("comissao"));
				venda.setDesconto(resultados.getDouble("desconto"));
				venda.setValorFinal(resultados.getDouble("valor_final"));
				lista.add(venda);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}
	
	public List<VendaAnimal> listarTodosPorDescricao(String tipo) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaAnimal> lista = new ArrayList<VendaAnimal>();
			String sql = "Select * from venda_animal where tipo = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, tipo);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaAnimal venda = new VendaAnimal();
				venda.setNotaFiscal(resultados.getInt("nota_fiscal"));
				venda.setMatFunc(resultados.getInt("matricula_funcionario"));
				venda.setRegAnimal(resultados.getInt("registro_animal"));
				venda.setAno(resultados.getInt("ano"));
				venda.setMes(resultados.getInt("mes"));
				venda.setDia(resultados.getInt("dia"));
				venda.setComissao(resultados.getDouble("comissao"));
				venda.setDesconto(resultados.getDouble("desconto"));
				venda.setValorFinal(resultados.getDouble("valor_final"));
				lista.add(venda);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}

	public List<VendaAnimal> listarTodosPorNomeVendedor(String nomeVendedor) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaAnimal> lista = new ArrayList<VendaAnimal>();
			String sql = "Select * from venda_animal where tipo = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, nomeVendedor);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaAnimal venda = new VendaAnimal();
				venda.setNotaFiscal(resultados.getInt("nota_fiscal"));
				venda.setMatFunc(resultados.getInt("matricula_funcionario"));
				venda.setRegAnimal(resultados.getInt("registro_animal"));
				venda.setAno(resultados.getInt("ano"));
				venda.setMes(resultados.getInt("mes"));
				venda.setDia(resultados.getInt("dia"));
				venda.setComissao(resultados.getDouble("comissao"));
				venda.setDesconto(resultados.getDouble("desconto"));
				venda.setValorFinal(resultados.getDouble("valor_final"));
				lista.add(venda);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}

	
	public VendaAnimal buscarPorId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void atualizarNotaFiscal(VendaAnimal venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_animal SET nota_fiscal = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getNotaFiscal());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarRegAnimal(VendaAnimal venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_animal SET cod_item = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getRegAnimal());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarMatricula(VendaAnimal venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_animal SET matricula_funcionario = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getMatFunc());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void atualizarDiaMesAno(VendaAnimal venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_animal SET dia = ?, mes = ? , ano = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getDia());
			statement.setLong(2, venda.getMes());
			statement.setLong(3, venda.getAno());
			statement.setLong(4, id);
			statement.execute();
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
