package br.com.cesed.petShop.EndPoint;

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

import br.com.cesed.petShop.modelo.VendaItem;
import br.com.cesed.petShop.service.VendaItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "VendaItem controller")
@Controller
@RequestMapping("/venda-item")
public class VendaItemEndPoint {
	
	@Autowired
	private VendaItemService service;
	
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens")
	@GetMapping
	public ResponseEntity<List<VendaItem>> findAll() throws Exception {
		List<VendaItem> item = service.buscarTodos();
		return new ResponseEntity<List<VendaItem>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens por vendedor")
	@GetMapping("/vendedor")
	public ResponseEntity<List<VendaItem>> findAllByVendedor(@RequestParam String vendedor) throws Exception {
		List<VendaItem> item = service.buscarTodosPorVendedor(vendedor);
		return new ResponseEntity<List<VendaItem>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens")
	@GetMapping("/descricao")
	public ResponseEntity<List<VendaItem>> findAllByDescricao(@RequestParam String descricao) throws Exception {
		List<VendaItem> item = service.buscarTodosPorDescricao(descricao);
		return new ResponseEntity<List<VendaItem>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens")
	@GetMapping("/mes-ano")
	public ResponseEntity<List<VendaItem>> findAllByMesAno(@RequestParam Integer mes, @RequestParam Integer ano) throws Exception {
		List<VendaItem> item = service.buscarTodosPorMesAno(mes, ano);
		return new ResponseEntity<List<VendaItem>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos as vendas dos itens")
	@GetMapping("/matricula-codigo")
	public ResponseEntity<List<VendaItem>> findAllByMatriculaCodigo(@RequestParam Integer matricula, @RequestParam Integer codigo) throws Exception {
		List<VendaItem> item = service.buscarVendasItemFuncionario(matricula, codigo);
		return new ResponseEntity<List<VendaItem>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insere uma venda item")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Venda item cadastrado com sucesso") })
	@PostMapping
	public ResponseEntity<Void> cadastrarVendaItem(@RequestBody VendaItem venda) {
		service.inserir(venda);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Insere uma venda item")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Venda item cadastrado com sucesso") })
	@PostMapping("/sem-desconto")
	public ResponseEntity<Void> cadastrarVendaItemSemDesconto(@RequestBody VendaItem venda) {
		service.inserirSemDesconto(venda);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar uma venda item")
	@PutMapping("/nota-fiscal/{id}")
	public ResponseEntity<Void> atualizarPesoDataMedicao(@RequestBody VendaItem venda, @PathVariable Long id) throws Exception {
		service.alterarNota(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda item")
	@PutMapping("/item-codigo/{id}")
	public ResponseEntity<Void> atualizarCodigoItem(@RequestBody VendaItem venda, @PathVariable Long id) throws Exception {
		service.alterarItemCod(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda item")
	@PutMapping("/matricula/{id}")
	public ResponseEntity<Void> atualizarMatricula(@RequestBody VendaItem venda, @PathVariable Long id) throws Exception {
		service.alterarMatricula(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar uma venda item")
	@PutMapping("/dia-mes-ano/{id}")
	public ResponseEntity<Void> atualizarMesAnoDia(@RequestBody VendaItem venda, @PathVariable Long id) throws Exception {
		service.alterarDiaMesAno(venda, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}
