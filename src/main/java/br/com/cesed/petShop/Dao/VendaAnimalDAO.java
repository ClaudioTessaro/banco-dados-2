package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Animal;
import br.com.cesed.petShop.modelo.VendaAnimal;

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

	public void deletar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
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
				venda.setNotaFiscal(resultados.getLong("nota_fiscal"));
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
	
	

}
