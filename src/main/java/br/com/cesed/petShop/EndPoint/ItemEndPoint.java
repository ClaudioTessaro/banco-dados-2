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

import br.com.cesed.petShop.modelo.Item;
import br.com.cesed.petShop.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Item controller")
@Controller
@RequestMapping("/item")
public class ItemEndPoint {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "Insere um item")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Item cadastrado com sucesso") })
	@PostMapping
	public ResponseEntity<Void> cadastrarItem(@RequestBody Item item) {
		itemService.inserirItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um item sem validade")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Item cadastrado com sucesso") })
	@PostMapping("/item-sem-validade")
	public ResponseEntity<Void> cadastrarItemSemValidade(@RequestBody Item item) {
		itemService.inserirSemValidade(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um animal sem preco de venda")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal cadastrado com sucesso") })
	@PostMapping("/item-sem-preco-loja")
	public ResponseEntity<Void> cadastraItemSemPrecoLoja(@RequestBody Item item) {
		itemService.inserirSemPrecoLoja(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@ApiOperation(value = "Atualizar preço por fornecedor sabendo o código")
	@PutMapping("/preco-fornecedor/{codigo}")
	public ResponseEntity<Void> atualizarPrecoFornecedor(@RequestBody Item item, @PathVariable Long codigo) throws Exception {
		itemService.alterarPrecoFornecedor(item, codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar preço por loja e fornecedor sabendo o código")
	@PutMapping("/preco-fornecedor-loja/{codigo}")
	public ResponseEntity<Void> atualizarPrecoFornecedorLoja(@RequestBody Item item, @PathVariable Long codigo) throws Exception {
		itemService.alterarPrecoLoja(item, codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Atualizar descrição e tipo")
	@PutMapping("/descricao-tipo/{codigo}")
	public ResponseEntity<Void> atualizarDescricaoTipo(@RequestBody Item item, @PathVariable Long codigo) throws Exception {
		itemService.alterarDescricaoTipo(item, codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar por codigo")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletarPorCodigo(@PathVariable Integer codigo) throws Exception {
		itemService.deletarPorCodigo(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos os itens")
	@GetMapping
	public ResponseEntity<List<Item>> findAll() throws Exception {
		List<Item> item = itemService.buscarTodos();
		return new ResponseEntity<List<Item>>(item,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mostrar todos os itens")
	@GetMapping("/dados")
	public ResponseEntity<List<Item>> findAllDados(String descricao) throws Exception {
		List<Item> item = itemService.buscarTodosPorDescricao(descricao);
		return new ResponseEntity<List<Item>>(item,HttpStatus.OK);
	}
		
	@ApiOperation(value = "Mostrar todos os itens de um tipo")
	@GetMapping("/tipo")
	public ResponseEntity<List<Item>> findAllbyTpo(String tipo) throws Exception {
		List<Item> animal = itemService.buscarTodosPorTipo(tipo);
		return new ResponseEntity<List<Item>>(animal,HttpStatus.OK);
	}

}
