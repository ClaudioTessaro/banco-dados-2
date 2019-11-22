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

