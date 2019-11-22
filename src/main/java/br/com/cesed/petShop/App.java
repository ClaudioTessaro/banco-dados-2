package br.com.cesed.petShop;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.cesed.petShop.Dao.AnimalDAO;
import br.com.cesed.petShop.modelo.Animal;

public class App {
	
	public static void main(String[] args) throws SQLException {
		Animal animal = new Animal();
		animal.setRegistro(2);
		animal.setAltura(1.3);
		animal.setPeso(10.0);
		animal.setDataNascimento(Date.valueOf(LocalDate.now()));
		animal.setDataUltimaMedicacao(Date.valueOf(LocalDate.now()));
		animal.setPrecoCompra(100.0);
		animal.setPrecoVenda(150.0);
		animal.setRaca("teste");
		animal.setTipo("teste");
		
		AnimalDAO animalDAO = new AnimalDAO();
		
		System.out.println(animalDAO.listarTodos());
		
	}

}
