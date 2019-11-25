package br.com.cesed.petShop.EndPoint;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cesed.petShop.modelo.VendaAnimal;
import br.com.cesed.petShop.service.VendaAnimalService;
import br.com.cesed.petShop.service.VendaAnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "VendaAnimal controller")
@Controller
@RequestMapping("/venda-animal")
public class VendaAnimalEndPoint {

	@Autowired
	private VendaAnimalService service;
	
	
	@ApiOperation(value = "Mostrar todos as vendas dos Animais")
	@GetMapping
	public ResponseEntity<List<VendaAnimal>> findAll() throws Exception {
		List<VendaAnimal> animal = service.buscarTodos();
		return new ResponseEntity<List<VendaAnimal>>(animal,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens por vendedor")
	@GetMapping("/vendedor")
	public ResponseEntity<List<VendaAnimal>> findAllByVendedor(@RequestParam String vendedor) throws Exception {
		List<VendaAnimal> animal = service.buscarTodosPorVendedor(vendedor);
		return new ResponseEntity<List<VendaAnimal>>(animal,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens")
	@GetMapping("/descricao")
	public ResponseEntity<List<VendaAnimal>> findAllByDescricao(@RequestParam String descricao) throws Exception {
		List<VendaAnimal> animal = service.buscarTodosPorDescricao(descricao);
		return new ResponseEntity<List<VendaAnimal>>(animal,HttpStatus.OK);
	}
	
//	@ApiOperation(value = "Mostrar todos as vendas dos animal")
//	@GetMapping("/mes-ano")
//	public ResponseEntity<List<VendaAnimal>> findAllByMesAno(@RequestParam Integer mes, @RequestParam Integer ano) throws Exception {
//		List<VendaAnimal> animal = service.buscarTodosPorMesAno(mes, ano);
//		return new ResponseEntity<List<VendaAnimal>>(animal,HttpStatus.OK);
//	}
	
//	@ApiOperation(value = "Mostrar todos as vendas dos itens")
//	@GetMapping("/matricula-codigo")
//	public ResponseEntity<List<VendaAnimal>> findAllByMatriculaCodigo(@RequestParam Integer matricula, @RequestParam Integer codigo) throws Exception {
//		List<VendaAnimal> animal = service.buscarVendasanimalFuncionario(matricula, codigo);
//		return new ResponseEntity<List<VendaAnimal>>(animal,HttpStatus.OK);
//	}
	
	@ApiOperation(value = "Insere uma venda animal")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Venda animal cadastrado com sucesso") })
	@PostMapping
	public ResponseEntity<Void> cadastrarVendaAnimal(@RequestBody VendaAnimal venda) throws SQLException {
		service.inserir(venda);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Insere uma venda animal")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Venda animal cadastrado com sucesso") })
	@PostMapping("/sem-desconto")
	public ResponseEntity<Void> cadastrarVendaAnimalSemDesconto(@RequestBody VendaAnimal venda) throws SQLException {
		service.inserirSemDesconto(venda);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar uma venda animal")
	@PutMapping("/nota-fiscal/{id}")
	public ResponseEntity<Void> atualizarPesoDataMedicao(@RequestBody VendaAnimal venda, @PathVariable Long id) throws Exception {
		service.alterarNota(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda animal")
	@PutMapping("/animal-codigo/{id}")
	public ResponseEntity<Void> atualizarCodigoanimal(@RequestBody VendaAnimal venda, @PathVariable Long id) throws Exception {
		service.alterarRegAnimal(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda animal")
	@PutMapping("/matricula/{id}")
	public ResponseEntity<Void> atualizarMatricula(@RequestBody VendaAnimal venda, @PathVariable Long id) throws Exception {
		service.alterarMatricula(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda animal")
	@PutMapping("/dia-mes-ano/{id}")
	public ResponseEntity<Void> atualizarMesAnoDia(@RequestBody VendaAnimal venda, @PathVariable Long id) throws Exception {
		service.alterarDiaMesAno(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
