package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.VendaItem;

@Repository
public class VendaItemDAO {

	private Connection con;

	public List<VendaItem> buscarTodos() {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaItem> lista = new ArrayList<VendaItem>();
			String sql = "Select * FROM venda_item vi, Funcionario f, Item i "
					+ "where f.id_matricula = vi.matricula_funcionario and vi.cod_item = i.codigo;";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaItem venda = new VendaItem();
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
				venda.setMatricula(resultados.getInt("matricula_funcionario"));
				venda.setCod_item(resultados.getInt("cod_item"));
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

	public List<VendaItem> buscarTodosPorDescricao(String descricao) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaItem> lista = new ArrayList<VendaItem>();
			String sql = "Select * FROM venda_item vi, Funcionario f, Item i "
					+ "where i.descricao = ?;";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, descricao);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaItem venda = new VendaItem();
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
				venda.setMatricula(resultados.getInt("matricula_funcionario"));
				venda.setCod_item(resultados.getInt("cod_item"));
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

	public List<VendaItem> buscarTodosPorVendedor(String vendedor) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaItem> lista = new ArrayList<VendaItem>();
			String sql = "Select * FROM venda_item vi, Funcionario f, Item i "
					+ "where f.nome = ?;";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, vendedor);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaItem venda = new VendaItem();
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
				venda.setMatricula(resultados.getInt("matricula_funcionario"));
				venda.setCod_item(resultados.getInt("cod_item"));
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

	public List<VendaItem> buscarTodosPorAnoMes(Integer ano, Integer mes) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaItem> lista = new ArrayList<VendaItem>();
			String sql = "Select * FROM venda_item vi, Funcionario f, Item i "
					+ "where vi.ano = ? and vi.mes = ?;";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, ano);
			preparador.setInt(2, mes);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaItem venda = new VendaItem();
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
				venda.setMatricula(resultados.getInt("matricula_funcionario"));
				venda.setCod_item(resultados.getInt("cod_item"));
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

	public List<VendaItem> buscarTodosVendedorItem(Integer matricula, Integer item) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<VendaItem> lista = new ArrayList<VendaItem>();
			String sql = "Select * FROM venda_item vi, Funcionario f, Item i "
					+ "where f.id_matricula = ? and i.codigo = ?;";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, matricula);
			preparador.setInt(2, item);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				VendaItem venda = new VendaItem();
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
				venda.setMatricula(resultados.getInt("matricula_funcionario"));
				venda.setCod_item(resultados.getInt("cod_item"));
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
	
	public void deletarVenda(Integer notaFiscal) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM venda_item WHERE nota_fiscal = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setInt(1, notaFiscal);
			prepared.execute();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(VendaItem venda) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO public.venda_item(" + 
					"	nota_fiscal, cod_item, matricula_funcionario, dia, mes, ano, comissao, desconto, valor_final)" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getNotaFiscal());
			statement.setInt(2, venda.getCod_item());
			statement.setInt(3, venda.getMatricula());
			statement.setInt(4, venda.getDia());
			statement.setInt(5, venda.getMes());
			statement.setInt(6, venda.getAno());
			statement.setDouble(7, venda.getComissao());
			statement.setDouble(8, venda.getDesconto());
			statement.setDouble(9, venda.getValorFinal());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirSemDesconto(VendaItem venda) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO public.venda_item(" + 
					"	nota_fiscal, cod_item, matricula_funcionario, dia, mes, ano, comissao, valor_final)" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getNotaFiscal());
			statement.setInt(2, venda.getCod_item());
			statement.setInt(3, venda.getMatricula());
			statement.setInt(4, venda.getDia());
			statement.setInt(5, venda.getMes());
			statement.setInt(6, venda.getAno());
			statement.setDouble(7, venda.getComissao());
			statement.setDouble(8, venda.getValorFinal());

			statement.execute();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarNotaFiscal(VendaItem venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_item SET nota_fiscal = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getNotaFiscal());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarItemCodigo(VendaItem venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_item SET cod_item = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getCod_item());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarMatricula(VendaItem venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_item SET matricula_funcionario = ? WHERE nota_fiscal = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, venda.getMatricula());
			statement.setLong(2, id);

			statement.execute();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void atualizarDiaMesAno(VendaItem venda, Long id) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE venda_item SET dia = ?, mes = ? , ano = ? WHERE nota_fiscal = ?";

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
