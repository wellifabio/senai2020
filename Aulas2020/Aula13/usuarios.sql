drop database if exists usuarios;
create database usuarios;
use usuarios;
create table pessoas(
	id_pessoa integer not null auto_increment, 
	nome varchar(40) not null,
	primary key (id_pessoa)
);
create table telefones(
	id_pessoa integer not null,
	telefone varchar(15) not null,
	constraint fk_tel_pess foreign key (id_pessoa)
	references pessoas(id_pessoa)
);
create table usuarios(
	id_pessoa integer not null,
	login varchar(10) not null,
	senha varchar(50) not null,
	constraint fk_possui foreign key (id_pessoa)
	references pessoas(id_pessoa)
);

insert into pessoas(nome) values
("Leonardo"),
("Rodolpho"),
("Jurema");
insert into pessoas(nome) values ("Marcia Souza");
insert into pessoas(nome) values ("Rodrigo vieira");
insert into pessoas values (default,"Maria Silva");

select * from pessoas;

insert into telefones(id_pessoa,telefone) values 
(1,"19 45677-7897"),
(1,"19 98787-7897");
insert into telefones values (3,"19 88888-8888");

select * from telefones;

-- Mostra somente as pessoas que possuem telefones
select p.id_pessoa, p.nome, t.telefone
from pessoas p inner join telefones t
on p.id_pessoa = t.id_pessoa;

-- Mostra a tabela da esquerda (pessoas) completa
create view vw_pessoas as
select p.id_pessoa, p.nome, t.telefone
from pessoas p left join telefones t
on p.id_pessoa = t.id_pessoa;

describe pessoas;
describe telefones;
describe usuarios;
show tables;
select * from vw_pessoas;