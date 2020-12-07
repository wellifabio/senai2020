drop database if exists solicitacoes;
create database solicitacoes;
use solicitacoes;

Create table Funcionarios(
	Cod_Func numeric(4)     not null,   
	Nome_Func varchar(50) not null,
	Sexo char(1) not null,            
	Cidade varchar(30),
	Estado varchar(2),
	constraint pk_func_1 primary key(Cod_Func)
);

Create table Departamentos(
	Cod_Depto numeric(4) not null,
	Nome_Depto varchar(50) not null,
	constraint pk_dep_1 primary key(Cod_Depto)
); 

Create table Produtos(
	Cod_Produto numeric(4) not null,  
	Nome_produto varchar(50) not null,
	constraint pk_prod_1 primary key(Cod_Produto)
);

Create table Solicitacao(
	Num_Sol numeric(4) not null,     
	Data_sol date null,
	Cod_Depto numeric(4) not null,           
	Cod_Func  numeric(4) not null,
	constraint pk_sol_1 primary key(Num_Sol),
	constraint fk_sol_dep_1 Foreign Key(Cod_Depto) references Departamentos(Cod_Depto),
	constraint fk_sol_fun_1 Foreign Key(Cod_Func) references Funcionarios(Cod_Func)
);

Create table ItensSolicitacao(
	Num_Sol numeric(4) not null,
	Cod_Produto numeric(4) not null,
	Qtde numeric(4) not null,
	Valor numeric(12,2) not null,
	constraint pk_itens_sol primary key(Num_Sol, cod_produto),
	constraint fk_itens_sol_1 foreign Key(Num_Sol) references Solicitacao(Num_Sol),
	constraint fk_itens_prod_1 Foreign Key(Cod_Produto) references Produtos(Cod_Produto)
);

insert into Departamentos values
(1000,"Vendas"),
(2000,"Compras"),
(2001,"Recursos Humanos");
insert into Funcionarios values
(100,"Jose Pedro","M","Sumare","SP"),
(150,"Ana Pereira","F","Nova Odessa","SP"),
(200,"Maria da Silva","F","Londrina","PR"),
(300,"Joao Antonio","M","Campinas","SP");
insert into Produtos values
(125,"Parafuso"),
(135,"Arruela"),
(145,"Difusor"),
(155,"Paralama");
insert into Solicitacao values
(1000,"2018/12/01",1000,100),
(1001,"2018/03/13",2001,200),
(1005,"2018/02/10",2001,150),
(1010,"2019/02/22",2000,100),
(1020,"2019/03/23",1000,200),
(1040,"2019/03/24",2001,300);
insert into ItensSolicitacao values
(1000,125,2,4.36),
(1000,145,1,85),
(1001,135,3,2.12),
(1001,155,2,522),
(1010,145,2,170),
(1010,135,2,1.06),
(1020,125,1,2.18),
(1020,145,2,170),
(1040,155,3,783),
(1005,125,1,50),
(1005,145,3,54.5);
-- Coluna Valor representa o valor total do item (Não é necessário multiplicar pela quantidade)

select * from Departamentos;
select * from Funcionarios;
select * from Produtos;
select * from Solicitacao;
select * from ItensSolicitacao;
show tables;

-- 1.(4,0) Escreva um select para mostrar o nome do funcionário que mais fez solicitações (em Reais).
-- Então, você deverá mostrar o nome do funcionário e seu respectivo valor total, em Reais.
select * from ItensSolicitacao;
select max(valor) from ItensSolicitacao;

Select f.Nome_Func, sum(i.valor) as Total
from ItensSolicitacao i
inner join Solicitacao s on s.Num_Sol = i.Num_Sol
inner join Funcionarios f on s.Cod_Func = f.Cod_Func
group by f.Cod_Func
order by Total desc;

Select f.Nome_Func, sum(i.valor) as Total
from ItensSolicitacao i
inner join Solicitacao s on s.Num_Sol = i.Num_Sol
inner join Funcionarios f on s.Cod_Func = f.Cod_Func
group by f.Cod_Func
order by Total desc limit 1;

-- 2.(1,0) Escreva um comando select para mostrar os nomes e datas dos departamentos que requisitaram Parafuso e Difusor.
select d.Nome_Depto, s.Data_sol from Departamentos d
left join Solicitacao s on d.Cod_Depto = s.Cod_Depto
inner join ItensSolicitacao i on s.Num_Sol = i.Num_Sol
where i.Cod_Produto = 125 OR i.Cod_Produto = 145;

-- 3.(1,0) Escreva um comando select para mostrar os nomes dos produtos vendidos em Fevereiro de 2018?
select p.Nome_produto from Produtos p
inner join  ItensSolicitacao i on i.Cod_Produto = p.Cod_Produto
inner join Solicitacao s on s.Num_Sol = i.Num_Sol
where Year(s.Data_sol) = "2018" AND month(s.Data_sol) = "02";

-- testes
select * from ItensSolicitacao;
select max(valor) from ItensSolicitacao;
Select Year(curdate()) as ano;
Select month(curdate()) as mes;
