CREATE DATABASE AV1;

USE AV1;
CREATE TABLE Pessoa (
id INT NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
dataNascimento date NOT NULL,
cpf varchar(11) NOT NULL,
sexo enum ('MASCULINO', 'FEMININO'),
PRIMARY KEY ( id ) );

CREATE TABLE Motorista (
pessoa_id INT NOT NULL,
numeroCNH varchar(255) NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE Funcionario (
pessoa_id INT NOT NULL,
matricula varchar(255),
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE Aluguel (
id INT NOT NULL AUTO_INCREMENT,
pessoa_id INT NOT NULL,
dataPedido date,
dataEntrega date,
dataDevolucao date,
valorTotal double,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa(id),
PRIMARY KEY ( id ) );

