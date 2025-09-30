
-- Criação do banco de dados
CREATE DATABASE control_games;
USE control_games;

-- Tabela de desenvolvedores
CREATE TABLE desenvolvedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_empresa VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

-- Tabela de clientes/usuários
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    idade INT
);

-- Tabela de jogos
CREATE TABLE jogos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    desenvolvedora_id INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(50),
    faixa_etaria VARCHAR(5),
    valor DECIMAL(10,2) NOT NULL,
    quantidadeVendida INT DEFAULT 0,
    data_lancamento DATE,
    FOREIGN KEY (desenvolvedora_id) REFERENCES desenvolvedores(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabela de compras (histórico de jogos adquiridos pelos clientes)
CREATE TABLE compras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    jogo_id INT NOT NULL,
    quantidade INT DEFAULT 1,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (jogo_id) REFERENCES jogos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Índices para otimização
CREATE INDEX idx_jogo_desenv ON jogos(desenvolvedora_id);
CREATE INDEX idx_compra_cliente ON compras(cliente_id);
CREATE INDEX idx_compra_jogo ON compras(jogo_id);

-- Inserindo desenvolvedores
INSERT INTO desenvolvedores(nome_empresa, email, senha)
VALUES 
('Scott Cawthon', 'info@scottcawthon.com', '63527b3290e1e132dd7eb485e5d35284'),
('Naughty Dog', 'info@naughtydog.com', '8840f8fcbce3bf7b7127413222ecb6a2'),
('Rockstar Games', 'info@rockstargames.com', '8b02dd10d623770d6a60224e4c5da3e0'),
('Portable Moose', 'info@portablemoose.com', 'b39d1e4bea385398762904e88b4b8a6b'),
('Toby Fox', 'info@tobyfox.com', '93792ba93b36e1a23e166df959250ade');

-- Inserindo clientes
INSERT INTO clientes (nome, idade, email, senha)
VALUES 
('Priscila Simões', 43, 'priscilass@gmail.com', 'c6669418b6998dd4290f46290e76ea2c'),
('Leandro Ribeiro', 19, 'ribeiroleandro@gmail.com', '5ea8b6b15f65cd69f5a88ae4d848a350'),
('Giovana Souza', 27, 'gigisouza@gmail.com', 'c51f41b9ab452b8d24661488ae1121fe'),
('Marcos Luiz', 23, 'luizma@gmail.com', 'ee207fb143baccc3980cb2537bb1a1c4'),
('Camila Andrade', 32, 'andradeka@gmail.com', '356eee0eec7a749c70b73ab1109d0b08');

-- Inserindo jogos com a referência do desenvolvedor
INSERT INTO jogos (desenvolvedora_id, nome, descricao, categoria, data_lancamento, valor, faixa_etaria)
VALUES 
(1, 'Five Nights at Freddys 4', 'Neste último capítulo da história original de Five Nights at Freddys, você deve mais uma vez se defender contra Freddy Fazbear, Chica, Bonnie, Foxy e coisas ainda piores que se escondem nas sombras.', 'Suspense, Terror, MiniGames', '2015-06-23', 16.59, '14'),
(2, 'The Last of Us', 'Em uma civilização devastada, em que infectados e sobreviventes veteranos estão à solta, Joel, um protagonista abatido, é contratado para tirar uma garota de 14 anos, Ellie, de uma zona de quarentena militar.', 'Ação, Aventura', '2013-06-14', 249.90, '18'),
(3, 'Red Dead Redemption 2', 'O jogo é um prequel de Red Dead Redemption, se passando no ano de 1899, em regiões do oeste, meio-oeste e sul dos EUA. Nele, você está na pele do fora da lei Arthur Morgan, que precisa lidar com o declínio do Velho Oeste.', 'Ação, Aventura', '2018-10-26', 248.90, '18'),
(4, 'Sally Face', 'Mergulhe em uma Aventura sinistra sobre um garoto com o rosto protético e um passado trágico. Desvende os sinistros mistérios da história de Sally para encontrar a verdade oculta por segredos sombrios.', 'Aventura', '2016-08-16', 48.90, '18'),
(5, 'Undertale', 'Undertale é um RPG que usa uma perspectiva de cima para baixo. Nele, o jogador controla uma criança e completa objetivos para progredir na história. Ele explora um mundo subterrâneo repleto de cidades e cavernas.', 'RPG, Aventura', '2015-09-15', 19.99, 'L');

DELIMITER //

CREATE TRIGGER atualiza_quantidade_vendida
AFTER INSERT ON Compras
FOR EACH ROW
BEGIN
    UPDATE Jogos
    SET quantidadeVendida = quantidadeVendida + NEW.quantidade
    WHERE id = NEW.jogo_id;
END;
//

DELIMITER ;


-- Inserindo compras dos clientes (substituindo Clientes_has_Jogos)
INSERT INTO compras (cliente_id, jogo_id, quantidade)
VALUES
(1, 3, 1),
(1, 5, 1),
(2, 3, 1),
(2, 4, 1),
(3, 4, 1),
(4, 1, 1),
(4, 5, 1),
(5, 3, 1);

select * from desenvolvedores;
select * from jogos;
select * from compras;

