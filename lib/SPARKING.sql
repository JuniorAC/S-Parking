CREATE DATABASE SPARKING;
USE SPARKING;


CREATE TABLE FUNCIONARIO(
	CPF INT PRIMARY KEY, 	
 	NOME VARCHAR(50), 
 	TELEFONE INT,
 	ENDERECO CHAR(100),
 	USUARIO VARCHAR(50),
 	SENHA VARCHAR(50),
 	CARGO VARCHAR(15));

CREATE TABLE CLIENTE(
	CPF INT PRIMARY KEY,  
	NOME VARCHAR(50),
  	TELEFONE INT,
  	ENDERECO CHAR(100),
  	CODCLIENTE INT);
  
CREATE TABLE VEICULO(
 	PLACA CHAR(7)PRIMARY KEY,
	CPFDONO INT,
 	COR VARCHAR(15),
 	AVARIAS INT,
	FOREIGN KEY (CPFDONO) REFERENCES CLIENTE(CPF));

CREATE TABLE VAGA(
  	NUMERO INT AUTO_INCREMENT PRIMARY KEY,
  	PISO INT,
  	TIPOVAGA VARCHAR(50),
  	DISPONIBILIDADE INT);

 CREATE TABLE ENTRADA(
   	CODIGO INT AUTO_INCREMENT PRIMARY KEY,
   	PLACAVEIC VARCHAR(8),
   	DATAENTRADA DATE,
   	HORAENTRADA DATE,
   	FOREIGN KEY (PLACAVEIC) REFERENCES VEICULO(PLACA));

CREATE TABLE SAIDA(
  	CODIGO INT AUTO_INCREMENT PRIMARY KEY,
  	PLACAVEIC VARCHAR(8),
  	DATASAIDA DATE,
  	HORASAIDA DATE,
  	FOREIGN KEY (PLACAVEIC) REFERENCES VEICULO(PLACA));

   
   
INSERT INTO FUNCIONARIO (CPF, NOME, TELEFONE, ENDERECO, USUARIO, SENHA, CARGO) VALUES

(1,'JUNIOR',970707070,'RUA BLA 15','USER1','aaa','GERENTE'),

(2,'FERNANDO',970707070,'RUA BLA 32','USER2','aaa','GERENTE'),

(3,'BRUNO',970707070,'RUA BLA 66','USER3','aaa','FUNCIONARIO');

SELECT * FROM FUNCIONARIO;