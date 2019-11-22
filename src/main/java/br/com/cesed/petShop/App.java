package br.com.cesed.petShop;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cesed.petShop.Util.ConexaoUtil;

public class App {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		System.out.println(connection);
		
	}

}
