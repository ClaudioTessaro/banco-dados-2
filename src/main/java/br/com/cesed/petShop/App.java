package br.com.cesed.petShop;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.cesed.petShop.Dao.AnimalDAO;
import br.com.cesed.petShop.Dao.VendaAnimalDAO;
import br.com.cesed.petShop.modelo.Animal;
import br.com.cesed.petShop.modelo.VendaAnimal;

public class App {
	
	public static void main(String[] args) throws SQLException {
//		Animal animal = new Animal();
//		animal.setRegistro(2);
//		animal.setAltura(1.3);
//		animal.setPeso(10.0);
//		animal.setDataNascimento(Date.valueOf(LocalDate.now()));
//		animal.setDataUltimaMedicacao(Date.valueOf(LocalDate.now()));
//		animal.setPrecoCompra(100.0);
//		animal.setPrecoVenda(150.0);
//		animal.setRaca("teste");
//		animal.setTipo("teste");
//		
//		AnimalDAO animalDAO = new AnimalDAO();
//		
//		System.out.println(animalDAO.listarTodos());
		
		VendaAnimal venda = new VendaAnimal();
		
		venda.setAno(2019);
		venda.setComissao(40.00);
		venda.setDesconto(5);
		venda.setDia(25);
		venda.setMatFunc(9);
		venda.setMes(11);
		venda.setNotaFiscal(99);
		venda.setValorFinal(100.00);
		
		VendaAnimalDAO vendaDAO = new VendaAnimalDAO();
		
		vendaDAO.inserir(venda);
		
		System.out.println(vendaDAO.listarTodos());
		
	}

}
