package br.com.cesed.petShop.EndPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cesed.petShop.modelo.Animal;
import br.com.cesed.petShop.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Animal controller")
@Controller
@RequestMapping("/animal")
public class AnimalEndPoint {

	@Autowired
	private AnimalService animalService;

	@ApiOperation(value = "Insere um animal")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping
	public ResponseEntity<Void> cadastrarAnimal(@RequestBody Animal animal) {
		animalService.inserirAnimal(animal);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um animal  sem informar peso, altura e data da ultima medição")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping("/insercao-sem-peso-altura-medicao")
	public ResponseEntity<Void> cadastrarAnimalSemPesoAlturaMedicao(@RequestBody Animal animal) {
		animalService.inserirSemPesoAlturaEMedicao(animal);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um animal sem preco de venda")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping("/insercao-sem-preco-venda")
	public ResponseEntity<Void> cadastrarAnimalSemPrecoVenda(@RequestBody Animal animal) {
		animalService.inserirSemPrecoVenda(animal);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um animal sem preco compra")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping("/insercao-sem-preco-compra")
	public ResponseEntity<Void> cadastrarAnimalSemPrecoCompra(@RequestBody Animal animal) {
		animalService.inserirSemPrecoCompra(animal);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um animal sem preco compra e venda")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping("/insercao-sem-preco")
	public ResponseEntity<Void> cadastrarAnimalSemPrecoCompraVenda(@RequestBody Animal animal) {
		animalService.inserirSemPrecoCompraVenda(animal);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualizar altura, peso e data de medição")
	@PutMapping("/atualiza-peso-altura-data-medicao/{id}")
	public ResponseEntity<Void> atualizarPesoAlturaDataMedicao(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarPesoAlturaMedicao(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Atualizar peso e data de medição")
	@PutMapping("/atualiza-peso-data-medicao/{id}")
	public ResponseEntity<Void> atualizarPesoDataMedicao(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarPesoDataAtualizacao(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar altura e data de medição")
	@PutMapping("/atualiza-altura-data-medicao/{id}")
	public ResponseEntity<Void> atualizarAlturaDataMedicao(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarAlturaDataMedicao(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar preco de venda")
	@PutMapping("/atualiza-preco-venda/{id}")
	public ResponseEntity<Void> atualizarVenda(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarPrecoVenda(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar preco de compra")
	@PutMapping("/atualiza-preco-compra/{id}")
	public ResponseEntity<Void> atualizarCompra(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarPrecoCompra(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar preco de compra e venda")
	@PutMapping("/atualiza-preco-compra-venda/{id}")
	public ResponseEntity<Void> atualizarCompraVenda(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarPrecoCompraVenda(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar tipo")
	@PutMapping("/atualiza-tipo/{id}")
	public ResponseEntity<Void> atualizarTipo(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarTipo(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar tipo e raca")
	@PutMapping("/atualiza-raca/{id}")
	public ResponseEntity<Void> atualizarRaca(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarRaca(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar tipo e raca")
	@PutMapping("/atualiza-tipo-raca/{id}")
	public ResponseEntity<Void> atualizarTipoRaca(@RequestBody Animal animal, @PathVariable Long id) throws Exception {
		animalService.alterarTipoRaca(animal, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar por registro")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPorRegistr(@PathVariable Integer id) throws Exception {
		animalService.deletarPorRegistro(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar por tipo")
	@DeleteMapping("/{tipo}")
	public ResponseEntity<Void> deletarPorTipo(@PathVariable String tipo) throws Exception {
		animalService.deletarPorTipo(tipo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos os animais")
	@GetMapping
	public ResponseEntity<List<Animal>> findAll() throws Exception {
		List<Animal> animal = animalService.listarTodos();
		return new ResponseEntity<List<Animal>>(animal,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos os animais por tipo")
	@GetMapping("/busca-por-tipo")
	public ResponseEntity<List<Animal>> findAllbyTpo(String tipo) throws Exception {
		List<Animal> animal = animalService.listarPorTipo(tipo);
		return new ResponseEntity<List<Animal>>(animal,HttpStatus.OK);
	}

}
