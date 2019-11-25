package br.com.cesed.petShop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.petShop.Dao.AnimalDAO;
import br.com.cesed.petShop.modelo.Animal;

@Service
public class AnimalService implements Serializable{

	private static final long serialVersionUID = 1758486733401228811L;

	@Autowired
	private AnimalDAO animalDAO;
	
	public void inserirAnimal(Animal animal) {
		animalDAO.inserir(animal);
	}
	
	public void inserirSemPesoAlturaEMedicao(Animal animal) {
		animalDAO.inserirSemPesoAlturaEMedicacao(animal);
	}
	
	public void inserirSemPrecoVenda(Animal animal) {
		animalDAO.inserirSemPrecoVenda(animal);
	}
	
	public void inserirSemPrecoCompra(Animal animal) {
		animalDAO.inserirSemPrecoCompra(animal);
	}
	
	public void inserirSemPrecoCompraVenda(Animal animal) {
		animalDAO.inserirSemPrecoCompraEVenda(animal);
	}
	
	public void inserirSemDataNascimento(Animal animal) {
		animalDAO.inserirSemDataNascimento(animal);
	}
	
	public void alterarPesoAlturaMedicao(Animal animal, Long id) throws Exception {
		animalDAO.atualizarPesoAlturaMedicao(animal, id);
	}
	
	public void alterarPesoDataAtualizacao(Animal animal, Long id) {
		animalDAO.atualizarPesoDataAtualizacao(animal, id);
	}
	
	public void alterarAlturaDataMedicao(Animal animal, Long id) {
		animalDAO.atualizarAlturaDataMedicao(animal, id);
		
	}
	
	public void alterarPrecoVenda(Animal animal, Long id) {
		animalDAO.atualizarVenda(animal, id);
	}
	
	public void alterarPrecoCompra(Animal animal, Long id) {
		animalDAO.atualizarCompra(animal, id);
	}
	
	public void alterarPrecoCompraVenda(Animal animal, Long id) {
		animalDAO.atualizarCompraVenda(animal, id);
	}
	
	public void alterarTipo(Animal animal, Long id) {
		animalDAO.atualizarTipo(animal, id);
	}
	
	public void alterarRaca(Animal animal, Long id) throws Exception {
		animalDAO.atualizarRaca(animal, id);
	}
	
	public void alterarTipoRaca(Animal animal, Long id) throws Exception {
		animalDAO.atualizarTipoRaca(animal, id);
	}
	
	public void deletarPorRegistro(Integer registro) {
		animalDAO.deletar(registro);
	}
	
	public void deletarPorTipo(String tipo) {
		animalDAO.deletarPorTipo(tipo);
	}
	
	public List<Animal> listarTodos(){
		return animalDAO.listarTodos();
	}
	
	public List<Animal> listarPorTipo(String tipo){
		return animalDAO.listarTodosPorTipo(tipo);
	}
	
}

