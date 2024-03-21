-- Criação da tabela usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

-- Criação da tabela carrinhos
CREATE TABLE IF NOT EXISTS carrinhos (
    id INTEGER PRIMARY KEY,
    idCliente INTEGER,
    total REAL,
    usuario_id INTEGER,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id)
);

-- Criação da tabela produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    valor REAL NOT NULL,
    carrinho_id INTEGER,
    FOREIGN KEY(carrinho_id) REFERENCES carrinhos(id)
);


-- Inserção de dados fictícios na tabela usuarios
INSERT INTO usuarios(id, login, password, role) VALUES
(1, 'user1', 'password1', 'ROLE_USER'),
(2, 'user2', 'password2', 'ROLE_USER');

-- Inserção de dados fictícios na tabela carrinhos
INSERT INTO carrinhos(id, idCliente, total, usuario_id) VALUES
(1, 1, 100.0, 1),
(2, 2, 200.0, 2);

-- Inserção de dados fictícios na tabela produtos
INSERT INTO produtos(id, nome, valor, carrinho_id) VALUES
(1, 'carne', 50.0, 1),
(2, 'leite', 50.0, 1),
(3, 'toalha', 100.0, 2),
(4, 'cerveja', 100.0, 2);