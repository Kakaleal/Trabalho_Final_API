-- Criação do db e tabelas

CREATE DATABASE ecommerce;


CREATE TABLE usuario(
  cod_usario SERIAL PRIMARY KEY,
  nome_usuario varchar(50) NOT NULL UNIQUE,
  email varchar(120) NOT NULL UNIQUE, 
  senha char(8)
);


CREATE TABLE cliente(
  cod_cliente SERIAL PRIMARY KEY,
  nome_completo varchar (50) NOT NULL,
  fk_nome_usuario varchar(50) NOT NULL UNIQUE REFERENCES usuario(nome_usuario) ON UPDATE CASCADE,
  fk_email varchar(120) NOT NULL UNIQUE REFERENCES usuario(email) ON UPDATE CASCADE,
  cpf char(11) NOT NULL UNIQUE,
  data_nascimento date NOT NULL,
  endereco varchar(200) NOT NULL
);


CREATE TABLE funcionario(
  cod_funcionario SERIAL PRIMARY KEY,
  nomeCompleto varchar(50) NOT NULL,
  cpf char(11) NOT NULL UNIQUE
);


CREATE TABLE categoria(
  cod_catergoria SERIAL PRIMARY KEY,
  nome varchar(50) NOT NULL UNIQUE,
  descricao varchar(200)
);


CREATE TABLE produto(
  cod_produto SERIAL PRIMARY KEY,
  nome varchar(50) NOT NULL UNIQUE,
  descricao varchar(200),
  qtd_em_estoque int,
  data_fabricacao date,
  valor_unitario float,
  fk_cod_catergoria int REFERENCES categoria(cod_catergoria) ON UPDATE CASCADE,
  fk_cod_funcionario int REFERENCES funcionario(cod_funcionario) ON UPDATE CASCADE
);


CREATE TABLE pedido(
  cod_pedido SERIAL PRIMARY KEY,
  fk_cod_cliente int REFERENCES cliente(cod_cliente) ON UPDATE CASCADE,
  data_pedido date NOT NULL
);


CREATE TABLE pedidoItem(
  fk_cod_pedido int NOT NULL REFERENCES pedido(cod_pedido) ON UPDATE CASCADE,
  cod_item int NOT NULL,
  fk_cod_produto int NOT NULL REFERENCES produto(cod_produto) ON UPDATE CASCADE,
  qtd_produto int NOT NULL,
  PRIMARY KEY (fk_cod_pedido, cod_item)
);


CREATE TABLE nota_fiscal(
  numero_notafiscal SERIAL PRIMARY KEY, --tbm o codigo da tabela
  fk_cod_cliente int REFERENCES cliente(cod_cliente) ON UPDATE CASCADE,
  fk_cod_pedido int REFERENCES pedido(cod_pedido) ON UPDATE CASCADE
);


-- Inserção dos dados

INSERT INTO usuario(nome_usuario, email, senha)
  VALUES ('rafaalves', 'rafaalves.s@gmail.com', 'rafa1234'),
  ('gillima', 'gil.Lima@gmail.com','gil12345'),
  ('tardin', 'tardincarol@gmail.com', '@carol78'),
  ('marcella', 'malzuguir@gmail.com', 'ma#12345'),
  ('lfita', 'lfita@gmail.com', '87654321'),
  ('dfaria', 'diegofaria13@gmail.com', 'diegofa#');


INSERT INTO cliente(nome_completo, fk_nome_usuario, fk_email, cpf, data_nascimento, endereco)
  VALUES 
  ('Rafael Alves de Souza', 'rafaalves', 'rafaalves.s@gmail.com', '15426575470', '1999-10-08', 'Rua carmelia Lucinda N:188'),
  ('Gilnei Lima da Costa', 'gillima', 'gil.Lima@gmail.com', '12423688471', '1987-07-01', 'Rua Jorge Pinto N:03'),
  ('Carolina Tardin', 'tardin', 'tardincarol@gmail.com', '38429576120', '1995-12-5', 'Rua Carmani Freitas N:732'),
  ('Marcella Alzuguir', 'marcella', 'malzuguir@gmail.com', '55729475620', '1990-04-10', 'Rua Pablo Escobar N:3445'),
  ('Leandro Fita', 'lfita', 'lfita@gmail.com', '45426577461', '1998-03-12', 'Rua Lacerda Costa N:664'),
  ('Diego Faria', 'dfaria', 'diegofaria13@gmail.com', '20124287461', '1989-04-30', 'Rua Lipp Souza N:999');


INSERT INTO funcionario(nomeCompleto, cpf)
 VALUES 
  ('Maria da Silva', '75864669040'),
  ('Joao Oliveira', '65688040061'),
  ('Juliana Neves', '94367851001'),
  ('Miguel Xavier', '31742757090'),
  ('Joana Duarte', '49293208016');


INSERT INTO categoria(nome, descricao)
  VALUES 
  ('Smartphones', 'Aparelho celular com acesso a internet'),
  ('Eletrodomésticos', 'Aparelhos domésticos eletrônicos'),
  ('Roupa', 'Camisas, calças, bermudas, vestidos, blusas e mais.'),
  ('Produtos de limpeza', 'Produtos para limpeza de ambientes'),
  ('Beleza', 'Produtos de beleza');
    

INSERT INTO produto(nome, descricao, qtd_em_estoque, data_fabricacao, valor_unitario, fk_cod_catergoria, fk_cod_funcionario)
  VALUES 
  ('Calça Jeans', 'Calça masculina reta', 20, '2020-08-30', 60.99, 3, 2),
  ('Camisa', 'Camisa gola V, branca', 15, '2020-07-26', 45.99, 3, 1),
  ('Bermuda', 'Bermuda cargo verde musgo', 45, '2020-12-06', 75.99, 3, 4),
  ('Desodorante', 'Desodorante 24h, floral, spray', 55, '2020-09-10', 9.90, 4, 4),
  ('Saia', 'Saia reta vermelha', 15, '2020-06-05', 85.99, 3, 4),
  ('Celular', 'Smartphone 5, Android, azul', 100, '2021-03-25', 805.99, 1, 4);


INSERT INTO pedido(fk_cod_cliente,data_pedido)
  VALUES 
  (1, '2021-07-25'),
  (2, '2021-08-14'),
  (3, '2021-08-18'),
  (4, '2021-09-05'),
  (5, '2021-09-05'),
  (6, '2021-09-10');


INSERT INTO pedidoItem(fk_cod_pedido, cod_item, fk_cod_produto, qtd_produto)	
  VALUES (1,1,1,5), (1,2,5,20), (1,3,3,15), (1,4,1,20), (2,1,2,30), (2,2,1,0), (3,1,1,2), (3,2,2,4), (4,1,3,12), (4,2,1,10), (5,1,3,21);


INSERT INTO nota_fiscal(fk_cod_cliente, fk_cod_pedido)
  VALUES (1,1), (2,2), (3,3), (4,4), (5,5);