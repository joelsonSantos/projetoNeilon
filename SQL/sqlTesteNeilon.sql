CREATE DATABASE projetoNeilon;

USE projetoNeilon;

CREATE TABLE cadastroDespesa (
idDespesa int(11) NOT NULL AUTO_INCREMENT UNIQUE,
tipoCobranca varchar(30) NOT NULL, 
email varchar(30) NOT NULL, 
telefone varchar (15) NOT NULL, 
moeda varchar (15) NOT NULL, 
vencimento date NOT NULL,
titularFatura varchar (30) NOT NULL,
PRIMARY KEY (idDespesa)
);

CREATE TABLE cadastroRenda(
idRenda int (11) NOT NULL AUTO_INCREMENT UNIQUE, 
origemRenda varchar(30) NOT NULL, 
valor int (11) NOT NULL, 
data date NOT NULL,
PRIMARY KEY (idRenda)
);

create table conta(
idConta int(11) not null AUTO_INCREMENT UNIQUE, 
banco int(11) not null, 
numero int(11) not null,
tipoConta int(11) not null, 
agencia int(11) not null, 
codigoOrdenacao int(11) not null, 
titularConta varchar(30) not null,
PRIMARY KEY (idConta)
);

create table pessoa(
idPessoa int (11) not null AUTO_INCREMENT UNIQUE, 
nome varchar (30) not null, 
sobrenome varchar(30) not null, 
nacionalidade varchar(30) not null, 
rg varchar(15) not null, 
cpf varchar(15) not null,
dataNascimento date not null,
escolaridade varchar(45) not null,
instituicao varchar(45) not null,
sexo varchar (20) not null,
PRIMARY KEY (idPessoa)
);

create table contatos (
idContatos int (11) not null AUTO_INCREMENT UNIQUE,
telefoneResidencial varchar(20) not null, 
celular varchar(20) not null, 
email varchar(30) not null,
telefoneComercial varchar (20) default null,
webSite varchar (60) default null,
idPessoa_fk int(11),
PRIMARY KEY (idContatos), 
FOREIGN KEY (idPessoa_fk) REFERENCES pessoa (idPessoa) ON DELETE CASCADE
);

CREATE TABLE contrato(
idContrato int(11) not null AUTO_INCREMENT UNIQUE,
dataInicio date not null,
dataFim date not null,
clubeOrigem varchar(30) not null,
idPessoa_fk int(11),
PRIMARY KEY (idContrato),
FOREIGN KEY (idPessoa_fk) REFERENCES pessoa (idPessoa) ON DELETE CASCADE
);


CREATE TABLE endereco(
idEndereco int(11) not null AUTO_INCREMENT UNIQUE,
rua varchar(30) not null,
numero varchar(30) not null,
bairro varchar(30) not null,
cidade varchar(30) not null,
estado varchar(30) not null,
pais varchar(30) not null,
complemento varchar(30),
cep varchar(30) not null,
idPessoa_fk int(11) not null,
PRIMARY KEY (idEndereco),
FOREIGN KEY (idPessoa_fk) REFERENCES pessoa (idPessoa) ON DELETE CASCADE
);

CREATE TABLE jogador(
idJogador int(11) not null AUTO_INCREMENT UNIQUE, 
categoria varchar (15) not null,
nomeEmpresario varchar(30) not null,
posicao varchar(15) not null,
peso double not null,
altura double not null,
assiatencia int(11) DEFAULT NULL,
mediaGols double DEFAULT NULL,
idPessoa_fk int(11) not null,
PRIMARY KEY (idjogador),
FOREIGN KEY (idPessoa_fk) REFERENCES pessoa(idPessoa) ON DELETE CASCADE
);

CREATE TABLE informacoesMedicas(
idInfMedica int(11) not null AUTO_INCREMENT UNIQUE,
dataUltimaRevisao date not null,
dataProximaRevisao date not null,
restricaoMedicamento LONGTEXT, 
informacoesMedica LONGTEXT,
tipoSanguinio varchar(15),
idJogador_fk int(11),
PRIMARY KEY(idInfMedica),
FOREIGN KEY (idJogador_fk) REFERENCES jogador (idJogador) ON DELETE CASCADE
);

CREATE TABLE patrocinador(
idPatrocinador int(11) not null AUTO_INCREMENT UNIQUE,
razaoSocial varchar(30) not null,
cmpj varchar(30) not null,
inscricaoEstadual varchar(30) not null,
inscricaoMunicipal varchar(30) not null,
idEndereco_fk int(11),
idContatos_fk int(11),
PRIMARY KEY (idPatrocinador)
FOREIGN KEY (idEndereco_fk) REFERENCES endereco (idEndereco) ON DELETE CASCADE,
FOREIGN KEY (idContatos_fk) REFERENCES contatos (idContatos) ON DELETE CASCADE
);

CREATE TABLE socioTorcedor(
idSocioTorcedor int(11) not null AUTO_INCREMENT UNIQUE, 
modalidadeTorcedor varchar(30) not null,
dataFiliacao date not null,
formaPagamento varchar(30) not null,
idPessoa_fk int(11),
primary key (idSocioTorcedor),
foreign key (idPessoa_fk) REFERENCES pessoa (idPessoa) ON DELETE CASCADE
);
