drop database if exists obras;
create database obras CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use obras;
-- Criação das tabelas e relacionamentos
create table servicos(
	id_servico integer not null primary key auto_increment,
	nome_obra varchar(50) not null,
	descricao varchar(256) not null,
	localizacao varchar(256) not null,
	tempo_estimado_horas integer not null,
	img_antes varchar(50),
	img_depois varchar(50)
);
create table profissionais(
	cpf varchar(11) primary key not null,
	nome varchar(50) not null,
	funcao_principal varchar(50) not null,
	valor_hora_servico decimal(8,2) not null,
	foto varchar(50)
);
create table ordens_de_servico(
	num_os integer not null primary key auto_increment,
	id_servico integer not null,
	profissional varchar(11) not null,
	data_inicio date not null,
	data_conclusao date,
	tempo_total_horas integer,
	constraint fk_os_profissionais foreign key (id_servico) references servicos(id_servico),
	constraint fk_os_servicos foreign key (profissional) references profissionais(cpf) on update cascade
);
-- Visões
create view vw_todas_os as
select o.num_os, o.id_servico, s.nome_obra, p.funcao_principal, p.nome, o.data_inicio, o.data_conclusao,
s.tempo_estimado_horas, p.valor_hora_servico, s.tempo_estimado_horas * p.valor_hora_servico as custo_estimado
from ordens_de_servico o inner join servicos s on o.id_servico = s.id_servico
inner join profissionais p on o.profissional = p.cpf
order by o.id_servico;
create view vw_profissionais_disponiveis as
Select * from profissionais where cpf not in (select profissional from ordens_de_servico where data_conclusao <> "null");
create view vw_servicos_concluidos as
select 	s.id_servico, s.nome_obra, s.descricao, s.localizacao, o.tempo_total_horas, p.nome, p.funcao_principal,
	o.tempo_total_horas * p.valor_hora_servico as custo_do_servico,
	s.img_antes, s.img_depois, p.foto, o.data_conclusao
from servicos s inner join ordens_de_servico o on s.id_servico = o.id_servico
inner join profissionais p on o.profissional = p.cpf
where o.data_conclusao <> "null"
order by o.data_conclusao;

-- População com dados para testes
insert into servicos values
(default,"Pintura Garagem","95 metros de paredes, material(tintas) já comprada pelo proprietário","Condomínio Quinta do Conte BL03 AP21, Jaguariúna - SP", 8,null,null),
(default,"Reforma Banheiro","Troca completa do piso, revestimento utencílios","Avenida Brasil, 41, Centrom, Jaguariúna - SP", 80,null,null),
(default,"Reparo em Descarga","Valvula do vaso sanitário com problemas","Rua Silva Bueno, 25, Centro, Jaguariúna - SP", 4,null,null),
(default,"Instalar Iluminação","Instalar iluminação no Jardim","Rua Marcos Bueno, 25, Centro, Jaguariúna - SP", 4,null,null);
insert into profissionais values
("22200033322","Marcelo Silva","Pedreiro",30,null),
("22211133322","Severina Silva","Ajudante Geral",30,null),
("11122233344","Jair Silva","Eletricista",35,null),
("55566677788","Adolfo Souza","Ajudante Geral",25,null),
("22211100022","Mariana Mattos","Faxineira",30,null),
("99900011122","Suzana Melo","Encanador",35,null),
("33344455566","Beatriz Oliveira","Pedreiro",30,null),
("77788899900","Paulo Bial","Decorador",50,null);
insert into ordens_de_servico values
(default, 1,"55566677788",curdate()-2,curdate()-2,8),
(default, 2,"77788899900",curdate()-1,null,null),
(default, 2,"33344455566",curdate()-1,null,null),
(default, 3,"99900011122",curdate(),curdate(),4),
(default, 3,"11122233344",curdate(),null,4);
select * from servicos;
select * from profissionais;
select * from ordens_de_servico;
select * from vw_todas_os;
select * from vw_profissionais_disponiveis;
select * from vw_servicos_concluidos;
show tables;
