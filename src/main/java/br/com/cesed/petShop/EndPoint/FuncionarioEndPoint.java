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

import br.com.cesed.petShop.modelo.Funcionario;
import br.com.cesed.petShop.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Funcionario controller")
@Controller
@RequestMapping("/funcionario")
public class FuncionarioEndPoint {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Insere um funcionario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " cadastrado com sucesso") })
	@PostMapping
	public ResponseEntity<Void> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.inserirFuncionario(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um funcionario sem informar salario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " cadastrado com sucesso") })
	@PostMapping("/insercao-sem-salario")
	public ResponseEntity<Void> cadastrarSemSalario(@RequestBody Funcionario funcionario ) {
		funcionarioService.inserirSemSalario(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Insere um funcionario sem telefone")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " cadastrado com sucesso") })
	@PostMapping("/insercao-sem-telefone")
	public ResponseEntity<Void> cadastrarSemTelefone(@RequestBody Funcionario funcionario) {
		funcionarioService.inserirSemTelefone(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualizar nome por matricula")
	@PutMapping("/nome/{id}")
	public ResponseEntity<Void> atualizarNomePorMatricula(@RequestBody Funcionario funcionario , @PathVariable Long id)
			throws Exception {
		funcionarioService.atualizarNomePorMatricula(funcionario, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar o nome sabendo o cpf")
	@PutMapping("/nome/{cpf}")
	public ResponseEntity<Void> atualizarNomePorCpf(@RequestBody Funcionario funcionario , @PathVariable String cpf)
			throws Exception {
		funcionarioService.atualizarNomePorCpf(funcionario, cpf);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar o endereço sabendo a matricula")
	@PutMapping("/endereco/{matricula}")
	public ResponseEntity<Void> atualizarEnderecoPorMatricula(@RequestBody  Funcionario funcionario, @PathVariable Long matricula)
			throws Exception {
		funcionarioService.atualizarEnderecoPorMatricula(funcionario, matricula);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar a data de demissao por matricula")
	@PutMapping("/demissao/{matricula}")
	public ResponseEntity<Void> atualizarDemissaoPorMatricula(@RequestBody Funcionario funcionario, @PathVariable Long matricula) throws Exception {
		funcionarioService.atualizarDataDemissaoPorMatricula(funcionario, matricula);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Deletar por matricula")
	@DeleteMapping("/{matricula}")
	public ResponseEntity<Void> deletarPorRegistr(@PathVariable Integer matricula) throws Exception {
		funcionarioService.deletarPorMatricula(matricula);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Mostrar todos os funcionario")
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() throws Exception {
		List<Funcionario> funcionario  = funcionarioService.buscarTodos();
		return new ResponseEntity<List<Funcionario>>(funcionario, HttpStatus.OK);
	}

	@ApiOperation(value = "Mostrar os funcionario recebendo o nome")
	@GetMapping("/{nome}")
	public ResponseEntity<List<Funcionario>> findAllbyTpo(@PathVariable String nome) throws Exception {
		List<Funcionario> funcionario  = funcionarioService.buscarPorNome(nome);
		return new ResponseEntity<List<Funcionario>>(funcionario, HttpStatus.OK);
	}

}
