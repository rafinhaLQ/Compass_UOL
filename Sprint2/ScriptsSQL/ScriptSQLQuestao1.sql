create database aplicacao;

use aplicacao;

create table produtos (
id int auto_increment,
nome varchar(50) not null,
descricao varchar(200),
quantidade int,
preco double,
primary key(id)
);