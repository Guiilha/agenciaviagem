CREATE DATABASE IF NOT EXISTS agencia_viagem;

USE agencia_viagem;

CREATE TABLE cliente (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	telefone VARCHAR(20),
	email VARCHAR(100),
	tipo ENUM('nacional', 'estrangeiro') NOT NULL,
	cpf VARCHAR(14) UNIQUE,     	
	passaporte VARCHAR(20) UNIQUE  
);

CREATE TABLE pacote_viagem (
	id_pacote INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	destino VARCHAR(100) NOT NULL,
	duracao_dias INT,
	preco DECIMAL(10,2) NOT NULL,
	tipo varchar(100),
	descricao TEXT
);


CREATE TABLE servico_adicional (
	id_servico INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT,
	preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE pedido (
	id_pedido INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT,
	id_pacote INT,
	data_contratacao DATE NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	FOREIGN KEY (id_pacote) REFERENCES pacote_viagem(id_pacote)
);

CREATE TABLE pedido_servico (
	id_pedido INT,
	id_servico INT,
	PRIMARY KEY (id_pedido, id_servico),
	FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
	FOREIGN KEY (id_servico) REFERENCES servico_adicional(id_servico)
);

INSERT INTO cliente (nome, telefone, email, tipo, cpf) 
VALUES ('Borges', '61981781838', 'borges@hotmail.com', 'nacional', '055.900.600-99'),
('Ana Souza', '61991234567', 'ana.souza@gmail.com', 'nacional', '123.456.789-00'),
('Lucas Ferreira', '11987654321', 'lucas.f@gmail.com', 'nacional', '987.654.321-00');

INSERT INTO cliente (nome, telefone, email, tipo, passaporte) 
VALUES 
  ('Emily Johnson', '+447912345678', 'emily.j@hotmail.co.uk', 'estrangeiro', 'X1234567'),
  ('Taro Yamada', '+81312345678', 'taro.y@japan.jp', 'estrangeiro', 'JP998877');

INSERT INTO pacote_viagem (nome, destino, duracao_dias, preco, tipo, descricao) 
VALUES 
  ('Aventura na Amazônia', 'Manaus', 7, 2999.90, 'aventura', 'Exploração de trilhas e passeio de barco'),
  ('Luxo em Paris', 'Paris', 5, 9999.00, 'luxo', 'Hospedagem 5 estrelas com city tour completo'),
  ('Rota Cultural Mineira', 'Ouro Preto', 3, 1200.50, 'cultural', 'Visitas a museus e igrejas históricas'),
  ('Surpresa no Deserto', 'Dubai', 6, 7500.00, 'outro', 'Safari no deserto com jantar árabe');

INSERT INTO servico_adicional (nome, descricao, preco)
VALUES 
  ('Seguro Viagem', 'Cobertura internacional contra imprevistos', 199.99),
  ('Transfer Aeroporto', 'Transporte privativo de ida e volta', 150.00),
  ('Passeio Extra', 'Passeio turístico adicional opcional', 350.00),
  ('Refeição Especial', 'Pacote de refeições em restaurantes parceiros', 400.00);

INSERT INTO pedido (id_cliente, id_pacote, data_contratacao)
VALUES 
  (1, 2, '2025-04-22'),
  (2, 1, '2025-04-23'),
  (3, 3, '2025-04-24');

INSERT INTO pedido_servico (id_pedido, id_servico)
VALUES 
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 1),
  (3, 4);
