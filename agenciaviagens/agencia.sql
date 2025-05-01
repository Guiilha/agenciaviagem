CREATE DATABASE agenciaviagens;

USE agenciaviagens;

CREATE TABLE cliente (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	telefone VARCHAR(20),
	email VARCHAR(100),
	tipo ENUM('nacional', 'estrangeiro') NOT NULL,
	cpf VARCHAR(14) UNIQUE,     	
	passaporte VARCHAR(20) UNIQUE  
);

CREATE TABLE servico_adicional (
	id_servico INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT,
	preco DECIMAL(10,2) NOT NULL
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

INSERT INTO cliente (nome, telefone, email, tipo, cpf) VALUES 
('Fernanda Oliveira', '11987654321', 'fernanda.oliveira@outlook.com', 'nacional', '123.456.789-01'),
('Roberto Santos', '21976543210', 'roberto.santos@yahoo.com', 'nacional', '234.567.890-12'),
('Juliana Costa', '31965432109', 'juliana.costa@gmail.com', 'nacional', '345.678.901-23');

INSERT INTO cliente (nome, telefone, email, tipo, passaporte) VALUES 
('Michael Johnson', '+12015551234', 'michael.johnson@usa.com', 'estrangeiro', 'US12345678'),
('Emma Schmidt', '+491511234567', 'emma.schmidt@germany.de', 'estrangeiro', 'DE87654321');

INSERT INTO pacote_viagem (nome, destino, duracao_dias, preco, tipo, descricao) VALUES 
('Serra Gaúcha', 'Gramado', 4, 3200.00, 'romântico', 'Passeios pelos pontos turísticos de Gramado e Canela'),
('Caribe Brasileiro', 'Fernando de Noronha', 7, 8500.00, 'luxo', 'Hospedagem em resort à beira-mar com mergulhos inclusos'),
('Cultura Japonesa', 'São Paulo', 3, 1800.00, 'cultural', 'Tour pelo bairro da Liberdade e experiências gastronômicas');

INSERT INTO servico_adicional (nome, descricao, preco) VALUES 
('Aluguel de Carro', 'Carro econômico por período da viagem', 450.00),
('Fotógrafo Profissional', 'Sessão fotográfica durante passeios', 600.00),
('Jantar Temático', 'Experiência gastronômica especial', 350.00);

INSERT INTO pedido (id_cliente, id_pacote, data_contratacao) VALUES 
(2, 1, '2025-06-15'),
(1, 3, '2025-06-18'),
(4, 2, '2025-06-20');

INSERT INTO pedido_servico (id_pedido, id_servico) VALUES 
(1, 1),
(1, 3),
(2, 2),
(3, 1),
(3, 2);
