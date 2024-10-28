Script para criar tabela Veiculo:

 CREATE TABLE veiculo (    id INT AUTO_INCREMENT PRIMARY KEY,    placa VARCHAR(10) NOT NULL UNIQUE,    marca VARCHAR(50) NOT NULL,    cor VARCHAR(30) NOT NULL,    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('nacional', 'importado')));
