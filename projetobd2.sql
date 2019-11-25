---Criando o banco de dados
create database pet_shop;

--- Criando a animal
create table animal(
	registro_id serial PRIMARY KEY NOT NULL,
	tipo VARCHAR(15),
	peso NUMERIC(10,2),
	altura NUMERIC(10,2),
	data_ultima_medicao TIMESTAMP without time zone,
	raca VARCHAR(15),
	preco_compra Money,
	preco_venda Money,
	data_nascimento TIMESTAMP without time zone NOT NULL
);

--- Criando a tabela funcionario
create table funcionario(
	id_matricula serial PRIMARY KEY NOT NULL,
	nome varchar(45),
	cpf varchar(15),
	endereco varchar(45),
	telefone varchar(15),
	salario money,
	data_nascimento TIMESTAMP without time zone,
	data_admissao TIMESTAMP without time zone,
	funcao varchar(45),
	data_demissao TIMESTAMP without time zone	
);

---- Criando a tabela item
create table item(
	codigo serial PRIMARY KEY NOT NULL,
	descricao varchar(45),
	tipo varchar(45),
	preco_fornecedor money,
	preco_loja money,
	validade TIMESTAMP without time zone,
	quantidade integer
);

---Criando a tabela venda animal
create table venda_animal(
	nota_fiscal serial PRIMARY KEY NOT NULL,
	registro_animal integer NOT NULL,
	matricula_funcionario integer NOT NULL,
	dia integer,
	mes integer,
	ano integer,
	comissao money,
	desconto numeric(10,2),
	valor_final numeric(10,2),
	CONSTRAINT fk_registro_animal_nota_fiscal FOREIGN KEY (registro_animal)
		REFERENCES animal (registro_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_matricula_funcionario_nota_fiscal FOREIGN KEY (matricula_funcionario)
		REFERENCES funcionario (id_matricula) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION	
);

--- Criando a tabela venda item
create table venda_item(
	nota_fiscal serial PRIMARY KEY NOT NULL,
	cod_item integer NOT NULL,
	matricula_funcionario integer NOT NULL,
	dia integer,
	mes integer,
	ano integer,
	comissao money,
	desconto numeric(10,2),
	valor_final numeric(10,2),
	CONSTRAINT fk_codigo_item_nota_fiscal_item FOREIGN KEY (cod_item)
		REFERENCES item (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_matricula_funcionario_nota_fiscal_item FOREIGN KEY (matricula_funcionario)
		REFERENCES funcionario (id_matricula) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION	
);

CREATE FUNCTION add_sal_func() RETURNS trigger AS $add_sal_func$
	BEGIN
		IF new.funcao = 'caixa' THEN
				new.salario := 1500.00;
		ELSEIF new.funcao = 'veterinário' THEN
			 new.salario := 2500.00;
		ELSEIF new.funcao = 'atendente' THEN
			 new.salario := 1000.00;
		ELSEIF new.funcao = 'cuidador' THEN
			 new.salario := 1700.00;
		END IF;
		RETURN new;
	END;

$add_sal_func$ LANGUAGE plpgsql;

CREATE TRIGGER tgr_SalarioFunc
BEFORE INSERT OR UPDATE ON funcionario
FOR EACH ROW EXECUTE PROCEDURE add_sal_func();

CREATE FUNCTION rem_qtd() RETURNS trigger AS $rem_qtd$
BEGIN
	UPDATE item SET quantidade = quantidade - 1 WHERE new.cod_item = item.codigo;
	RETURN NULL;
END;
$rem_qtd$ LANGUAGE plpgsql;

CREATE TRIGGER tgr_RemQtd
AFTER INSERT ON venda_item
FOR EACH ROW EXECUTE PROCEDURE rem_qtd();

CREATE FUNCTION valorFinalAnimal() RETURNS trigger AS $valorFinalAnimal$
DECLARE
	preco_venda_res Money;
BEGIN
	SELECT (preco_venda) into preco_venda_res FROM animal WHERE new.registro_animal = animal.registro_id;
	new.valor_final := preco_venda_res - (preco_venda_res*(new.desconto/100));
	new.comissao := new.valor_final*0.05;
	RETURN new;
END;
$valorFinalAnimal$ LANGUAGE plpgsql;

CREATE TRIGGER tgr_ValorFinalAnimal
BEFORE INSERT OR UPDATE ON venda_animal
FOR EACH ROW EXECUTE PROCEDURE valorFinalAnimal();

CREATE FUNCTION valorFinalItem() RETURNS trigger AS $valorFinalItem$
DECLARE
	preco_loja_res Money;
BEGIN
	SELECT (preco_venda) into preco_loja_res FROM item WHERE new.cod_item = item.codigo;
	new.valor_final := preco_loja_res - (preco_loja_res*(new.desconto/100));
	new.comissao := new.valor_final*0.02;
	RETURN new;
END;
$valorFinalItem$ LANGUAGE plpgsql;

CREATE TRIGGER tgr_ValorFinalItem
BEFORE INSERT OR UPDATE ON venda_item
FOR EACH ROW EXECUTE PROCEDURE valorFinalItem();



