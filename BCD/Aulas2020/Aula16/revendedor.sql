drop database if exists revendedor;
create database revendedor character set UTF8 collate utf8_bin;
use revendedor;
-- Criação das tabelas
create table mercadorias(
	id_merc integer not null primary key auto_increment,
	nome varchar(50) not null,
	descricao varchar(256) not null,
	valor decimal(8,2),
	quantidade integer not null
);
create table compras(
	n_compra integer not null primary key auto_increment,
	data_compra date not null,
	fornecedor varchar(50),
	obs varchar(256)
);
create table vendas(
	n_venda integer not null primary key auto_increment,
	data_venda date not null,
	cliente varchar(50),
	obs varchar(256)
);
create table itens_compras(
	n_compra integer not null,
	id_merc integer not null,
	quantidade integer not null,
	custo decimal(8,2) not null,
	constraint pk_itens_compras primary key (n_compra,id_merc),
	constraint fk_itens_compras foreign key (n_compra) references compras(n_compra),
	constraint fk_itens_c_merc foreign key (id_merc) references mercadorias(id_merc)
);
create table itens_vendas(
	n_venda integer not null,
	id_merc integer not null,
	quantidade integer not null,
	preco decimal(8,2) not null,
	constraint pk_itens_vendas primary key (n_venda,id_merc),
	constraint fk_itens_vendas foreign key (n_venda) references vendas(n_venda),
	constraint fk_itens_v_merc foreign key (id_merc) references mercadorias(id_merc)
);

-- Gatilhos e Views
-- gatilho que atualiza a quantidade de produtos em estoque sempre que uma compra é inserida
create trigger tg_atualiza_estoque_quantidade after insert on itens_compras
for each row
update mercadorias
set quantidade = quantidade + new.quantidade
where id_merc = new.id_merc; 
-- gatilho que atualiza a quantidade de produtos em estoque e o valor do produto para 75% do preço, sempre que uma venda é inserida
create trigger tg_atualiza_estoque_quantidade_e_valor after insert on itens_vendas
for each row
update mercadorias
set quantidade = quantidade - new.quantidade,
valor = new.preco * 0.75 
where id_merc = new.id_merc;
-- Visões com relatórios de compras e vendas
create view vw_compras_detalhadas as
select  i.n_compra, i.id_merc, m.nome, i.quantidade, i.custo, i.custo * i.quantidade as subtotal
from itens_compras i inner join mercadorias m on i.id_merc = m.id_merc;
create view vw_compras_total as
select  c.n_compra, c.data_compra, c.fornecedor, c.obs, sum(i.custo * i.quantidade) as total
from itens_compras i inner join compras c on i.n_compra = c.n_compra group by c.n_compra;
create view vw_vendas_detalhadas as
select v.data_venda, v.n_venda, v.cliente, m.id_merc, m.nome, i.preco, i.quantidade, i.preco * i.quantidade as subtotal
from vendas v inner join itens_vendas i on v.n_venda = i.n_venda
inner join mercadorias m on i.id_merc = m.id_merc order by v.data_venda;
create view vw_vendas_total as
select v.data_venda, v.n_venda, v.cliente, sum(i.preco * i.quantidade) as total
from vendas v inner join itens_vendas i on v.n_venda = i.n_venda
inner join mercadorias m on i.id_merc = m.id_merc group by v.cliente, v.data_venda order by v.data_venda;
create view vw_mercadorias_subtotais as
select *, valor * quantidade as subtotal from mercadorias;
create view vw_mercadorias_total_estoque as
select sum(valor * quantidade) as ValorTotalEstoque from mercadorias;

-- População do Banco de Dados com dados de teste
insert into mercadorias values
(default,"Chileno","Chileno xing ling",0,0),
(default,"Sandálias Havaianas","Sandálias Havaianas Básicas",0,0),
(default,"Sandálias Ipanema","Sandálias Ipanema Básicas",0,0),
(default,"Sandálias Femininas","Sandálias Femininas Básicas",0,0),
(default,"Bermuda Masculina","Bermuda Masculina Adulto",0,0),
(default,"Bermuda Masculina","Bermuda Masculina Infantil",0,0),
(default,"Bermuda Feminina","Bermuda Feminina Adulto",0,0),
(default,"Bermuda Feminina","Bermuda Feminina Infantil",0,0),
(default,"Camiseta Feminina","Camiseta Feminina Básica",0,0),
(default,"Camiseta Feminina","Camiseta Feminina Baby Look",0,0),
(default,"Camiseta Masculina","Camiseta Masculina Básica",0,0),
(default,"Camiseta Masculina","Camiseta Masculina Gola Polo",0,0);
select * from mercadorias;
insert into compras values
(default,curdate() - 5,"Galeria Pagé",null),
(default,curdate() - 5,"Lojão do Brás","Bons descontos se falar com Xineizinho"),
(default,curdate() - 4,null, null),
(default,curdate() - 4,"Mercado Livre, Internet", null);
select * from compras;
insert into itens_compras values
(1,2,10,7.5),
(1,3,10,7.5),
(1,5,5,14.5),
(1,9,5,15),
(2,1,15,3.5),
(2,6,10,10),
(2,10,10,14.5),
(2,11,10,15),
(3,4,5,14.5),
(3,7,10,15),
(3,8,10,10),
(3,12,15,15),
(4,4,10,14.5),
(4,7,5,15),
(4,8,5,10),
(4,12,15,15);
select * from itens_compras;
select * from vw_mercadorias_total_estoque;
insert into vendas values
(default,curdate() - 4,"Sirlei",null),
(default,curdate() - 4,"Tião pé de bode","Fiado, disse que paga quando puder"),
(default,curdate() - 3,"Abreu", "Bom pagador"),
(default,curdate() - 3,"Francisco", "Pediu pra colocar na conta do Abreu"),
(default,curdate() - 3,null, null),
(default,curdate() - 3,null, null),
(default,curdate() - 3,null, null),
(default,curdate() - 2,"Zuleica", null),
(default,curdate() - 2,null, null),
(default,curdate() - 2,"Tia Flor", null),
(default,curdate() - 1,"Pedro", "Enteado da tia flor"),
(default,curdate() - 1,"Cidão", null),
(default,curdate(),"Roberto", null);
select * from vendas;
insert into itens_vendas values
(1,1,1,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(1,7,1,(select custo from itens_compras where id_merc = 7 order by custo desc limit 1) * 3),
(1,10,2,(select custo from itens_compras where id_merc = 10 order by custo desc limit 1) * 3),
(2,2,3,(select custo from itens_compras where id_merc = 2 order by custo desc limit 1) * 3),
(2,3,1,(select custo from itens_compras where id_merc = 3 order by custo desc limit 1) * 3),
(3,4,3,(select custo from itens_compras where id_merc = 4 order by custo desc limit 1) * 3),
(3,6,2,(select custo from itens_compras where id_merc = 6 order by custo desc limit 1) * 3),
(4,1,1,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(4,9,4,(select custo from itens_compras where id_merc = 9 order by custo desc limit 1) * 3),
(5,1,1,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(5,10,3,(select custo from itens_compras where id_merc = 10 order by custo desc limit 1) * 3),
(6,2,1,(select custo from itens_compras where id_merc = 2 order by custo desc limit 1) * 3),
(6,5,2,(select custo from itens_compras where id_merc = 5 order by custo desc limit 1) * 3),
(6,12,4,(select custo from itens_compras where id_merc = 12 order by custo desc limit 1) * 3),
(7,1,1,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(7,10,1,(select custo from itens_compras where id_merc = 10 order by custo desc limit 1) * 3),
(8,7,3,(select custo from itens_compras where id_merc = 7 order by custo desc limit 1) * 3),
(8,12,5,(select custo from itens_compras where id_merc = 10 order by custo desc limit 1) * 3),
(9,2,1,(select custo from itens_compras where id_merc = 2 order by custo desc limit 1) * 3),
(9,3,5,(select custo from itens_compras where id_merc = 3 order by custo desc limit 1) * 3),
(9,4,1,(select custo from itens_compras where id_merc = 4 order by custo desc limit 1) * 3),
(10,8,2,(select custo from itens_compras where id_merc = 8 order by custo desc limit 1) * 3),
(11,1,2,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(11,9,1,(select custo from itens_compras where id_merc = 9 order by custo desc limit 1) * 3),
(12,2,3,(select custo from itens_compras where id_merc = 2 order by custo desc limit 1) * 3),
(12,11,2,(select custo from itens_compras where id_merc = 11 order by custo desc limit 1) * 3),
(12,12,7,(select custo from itens_compras where id_merc = 12 order by custo desc limit 1) * 3),
(13,1,1,(select custo from itens_compras where id_merc = 1 order by custo desc limit 1) * 3),
(13,10,4,(select custo from itens_compras where id_merc = 10 order by custo desc limit 1) * 3);
select * from itens_vendas;
select * from vw_compras_total;
select * from vw_compras_detalhadas;
select * from vw_vendas_total;
select * from vw_vendas_detalhadas;
select * from vw_mercadorias_subtotais;
select * from vw_mercadorias_total_estoque;
show tables;
