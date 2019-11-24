package br.com.cesed.petShop.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cesed.petShop.Util.ConexaoUtil;
import br.com.cesed.petShop.modelo.Funcionario;

public class FuncionarioDAO implements GenericDAO<Funcionario>{

	private Connection con;
	
	public void inserir(Funcionario funcionario) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Funcionario(id_matricula,nome,cpf,endereco,telefone,salario,data_nascimento,data_admissao,funcao,data_demissao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, funcionario.getMatricula());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setString(4, funcionario.getEndereco());
			statement.setString(5, funcionario.getTelefone());
			statement.setDouble(6, funcionario.getSalario());
			statement.setDate(7, (Date) funcionario.getDtNascimento());
			statement.setDate(8, (Date) funcionario.getDtAdmissao());
			statement.setString(9, funcionario.getFuncao());
			statement.setDate(10, (Date) funcionario.getDtDemissao());
			
			
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserirSemSalario(Funcionario funcionario) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Funcionario(id_matricula,nome,cpf,endereco,telefone,data_nascimento,data_admissao,funcao,data_demissao) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, funcionario.getMatricula());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setString(4, funcionario.getEndereco());
			statement.setString(5, funcionario.getTelefone());
			statement.setDate(6, (Date) funcionario.getDtNascimento());
			statement.setDate(7, (Date) funcionario.getDtAdmissao());
			statement.setString(8, funcionario.getFuncao());
			statement.setDate(9, (Date) funcionario.getDtDemissao());
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserirSemTelefone(Funcionario funcionario) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO Funcionario(id_matricula,nome,cpf,endereco,salario,data_nascimento,data_admissao,funcao,data_demissao) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, funcionario.getMatricula());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setString(4, funcionario.getEndereco());
			statement.setDouble(5, funcionario.getSalario());
			statement.setDate(6, (Date) funcionario.getDtNascimento());
			statement.setDate(7, (Date) funcionario.getDtAdmissao());
			statement.setString(8, funcionario.getFuncao());
			statement.setDate(9, (Date) funcionario.getDtDemissao());
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void deletar(Integer id) throws SQLException {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM funcionario WHERE registro_id = ?";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setLong(1, id);
			prepared.execute();
			prepared.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Funcionario> listarTodos() {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			String sql = "Select * from animal";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Funcionario func = new Funcionario();
				func.setCpf(resultados.getString("cpf"));
				func.setDtAdmissao(resultados.getDate("data_admissao"));
				func.setDtDemissao(resultados.getDate("data_demissao"));
				func.setDtNascimento(resultados.getDate("data_nascimento"));
				func.setEndereco(resultados.getString("endereco"));
				func.setMatricula(resultados.getLong("id_matricula"));
				func.setNome(resultados.getString("nome"));
				func.setSalario(resultados.getDouble("salario"));
				func.setTelefone(resultados.getString("telefone"));
				func.setFuncao(resultados.getString("funcao"));
				
				lista.add(func);
			}

			return lista;
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return null;
	}

	public Funcionario buscarPorId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Funcionario buscarPorNome(String nome) {
		try {
			con = ConexaoUtil.getInstance().getConnection();
			String sql = "Select * from animal";
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			Funcionario func = new Funcionario();
			func.setCpf(resultados.getString("cpf"));
			func.setDtAdmissao(resultados.getDate("data_admissao"));
			func.setDtDemissao(resultados.getDate("data_demissao"));
			func.setDtNascimento(resultados.getDate("data_nascimento"));
			func.setEndereco(resultados.getString("endereco"));
			func.setMatricula(resultados.getLong("id_matricula"));
			func.setNome(resultados.getString("nome"));
			func.setSalario(resultados.getDouble("salario"));
			func.setTelefone(resultados.getString("telefone"));
			func.setFuncao(resultados.getString("funcao"));
			return func;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;		
	}
	
	public void atualizarNome(Funcionario funcionario , Long matricula) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE funcionario SET nome= ? WHERE id_matricula = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, funcionario.getNome());
		statement.setLong(2, matricula);
		statement.execute();
		statement.close();

	}
	
	public void atualizarNome(Funcionario funcionario , String cpf) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE funcionario SET nome= ? WHERE cpf = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, funcionario.getNome());
		statement.setString(2, cpf);
		statement.execute();
		statement.close();

	}
	
	public void atualizarEndereco(Funcionario funcionario , Long matricula) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE funcionario SET endereco= ? WHERE id_matricula = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, funcionario.getEndereco());
		statement.setLong(2, matricula);
		statement.execute();
		statement.close();

	}
	
	public void atualizarFuncao(Funcionario funcionario , Long matricula) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE funcionario SET funcao = ? WHERE id_matricula = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, funcionario.getFuncao());
		statement.setLong(2, matricula);
		statement.execute();
		statement.close();

	}
	
	public void atualizarDataDemissao(Funcionario funcionario , Long matricula) throws Exception {
		con = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE funcionario SET data_demissao = ? WHERE id_matricula = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDate(1, (Date) funcionario.getDtDemissao());
		statement.setLong(2, matricula);
		statement.execute();
		statement.close();

	}

}
