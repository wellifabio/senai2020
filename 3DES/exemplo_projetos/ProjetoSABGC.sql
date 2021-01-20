-- SABGC (Sistema para Administração Básica Geral de uma Cantina) 1.0
-- SGBD (Sistema Gerenciador de Banco de Dados): MySQL - Versão MariaDB
drop database if exists Cantina;
create database if not exists Cantina;
use Cantina;
-- CADASTRO INICIAL DE PESSOAS, USUÁRIOS E CAIXA
create table pessoas(
	pessoa_id integer primary key auto_increment,
	cpf varchar(11) not null,
	pri_nome varchar(30) not null,
	sobrenome varchar(30) not null,
	endereco varchar(30),
	bairro varchar(30),
	cidade varchar(30),
	uf varchar(2),
	tipo_pessoa varchar(10) not null,
	descricao varchar(30),
	data_cadastro date not null,
	usuario varchar(10) not null
);

insert into pessoas values
(default, '11122233344','DONA','BETE','RUA DO SENAI,1','SENAI','JAGUARIÚNA','SP','ADMIN','DONA DA ESTABELECIMENTO',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin');

create table usuarios(
	login varchar(10) not null primary key,
	pessoa_id integer,
	senha varchar(42) not null,
	tipo varchar(10) not null,
	constraint fk_user_pessoa foreign key (pessoa_id) references pessoas(pessoa_id)
);

insert into usuarios values
('admin',null,PASSWORD('admin'),'ADMIN'),
('app',null,PASSWORD('web'),'ADMIN'),
('dona',1,PASSWORD('bete'),'ADMIN');

alter table pessoas add
constraint fk_pessoa_usuario foreign key (usuario) references usuarios(login) on update cascade;

insert into pessoas values
(default, '22222233344','PROF','REENYE','RUA DO SENAI,1','SENAI','JAGUARIÚNA','SP','PROFESSOR','PROFESSOR DE INFORMÁTICA',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default, '33322233344','MARIA','DOS SANTOS','RUA DAS PEDRAS,123','CENTRO','PEDREIRA','SP','ALUNO','INFORMÁTICA',DATE_SUB(curdate(),INTERVAL 10 DAY),'dona'),
(default, '33322233344','JOSÉ','DA SILVA','RUA DA FEIRA,456','CENTRO','ARTUR NOGUEIRA','SP','ALUNO','DESENVOLVIMENTO DE SISTEMAS',DATE_SUB(curdate(),INTERVAL 10 DAY),'app'),
(default, '33322233344','AMANCIO','PEREIRA','RUA DAS ABELHAS,789','ZAMBOM','JAGUARIÚNA','SP','ALUNO','DESENVOLVIMENTO DE SISTEMAS',DATE_SUB(curdate(),INTERVAL 10 DAY),'dona');

insert into usuarios values
('reenye',2,PASSWORD('1234'),'COMUM'),
('maria',3,PASSWORD('1234'),'COMUM'),
('jose',4,PASSWORD('1234'),'COMUM');

create table telefones(
	pessoa_id integer not null,
	telefone varchar(15),
	celular varchar(15),
	constraint fk_tel_pessoa foreign key (pessoa_id) references pessoas(pessoa_id)
	on delete cascade
);

insert into telefones values
(1,'1934568979','19996589897'),
(2,null,'19996589897'),
(3,'1938548798','19996589897'),
(3,null,'19996589897'),
(4,'1937589857',null),
(5,'1938541198','19996229897'),
(5,null,'19994449897');

create table caixa(
	num_lancamento integer primary key auto_increment,
	usuario varchar(10) not null,
	descricao varchar(100),
	data date not null,
	hora time not null,
	tipo varchar(1) not null,
	forma varchar(10) not null,
	valor decimal(6,2) not null,
	constraint fk_caixa_usuario foreign key (usuario) references usuarios(login) on update cascade
);
-- CADASTRO DE PRODUTOS
create table produtos(
	produto_id integer primary key auto_increment,
	nome_prod varchar(30) not null,
	descri_prod varchar(80),
	tipo_prod varchar(15),
	img_prod varchar(50),
	qtd_estoque integer not null,
	preco decimal(5,2),
	data_cadastro date not null,
	usuario varchar(10) not null,
	constraint fk_produto_usuario foreign key (usuario) references usuarios(login) on update cascade
);
insert into produtos values
(default,'PÃO DE QUEIJO',null,'PÃO DE QUEIJO','img01.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'COXINHA','SALGADO FRITO RECHEADO COM FRANGO','SALGADO FRITO','img02.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'RISOLE','SALGADO FRITO RECHEADO COM CARNE','SALGADO FRITO','img03.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'CUMPRIDO','SALGADO FRITO RECHEADO COM PRESUNTO E QUEIJO','SALGADO FRITO','img04.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'SALSICHA','SALGADO FRITO RECHEADO COM SALSICHA','SALGADO FRITO','img05.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'RETÂNGULO','SALGADO FRITO RECHEADO SÓ COM QUEIJO','SALGADO FRITO','img06.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'ESFIHA','SALGADO ASSADO RECHEADO COM CARNE','SALGADO ASSADO','img07.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'ESFIHA DE FRANGO','SALGADO ASSADO RECHEADO COM FRANGO','SALGADO ASSADO','img08.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'XTUDO','SALGADO ASSADO RECHEADO COM CARNE, BACOM E QUEIJO','SALGADO ASSADO','img09.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'HAMBURGUER BACOM','SALGADO ASSADO RECHEADO COM HAMBURGUER, BACOM E CATUPIRY','SALGADO ASSADO','img10.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'HAMBURGUER CHEDDAR','SALGADO ASSADO RECHEADO COM HAMBURGUER E CHEDDAR','SALGADO ASSADO','img11.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'SUCO ARTIFICIAL 400ML','SUCO DIVERSAS MARCAS INDÚSTRIALIZADO','BEBIDA','img12.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'SUCO LATA 320ML','SUCO DEL VALLE SABORES','BEBIDA','img13.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'COCA COLA 200ML','MINI COCA COLA PET 200ML','BEBIDA','img14.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'REFRIGERANTE LATA 350ML','LATAS DE REFRIGERANTES DIVERSOS SABORES','BEBIDA','img15.jpg',0,null,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin');

create table preco_produtos(
	produto_id integer not null,
	preco decimal(5,2) not null,
	data_preco date not null,
	usuario varchar(10) not null,
	constraint fk_preco_prod_usuario foreign key (usuario) references usuarios(login) on update cascade,
	constraint fk_preco_produtos foreign key (produto_id) references produtos(produto_id)
);

-- Cria um gatilho que atualiza o preco do produto
create trigger tr_atualiza_preco_produto after insert
on preco_produtos
for each row
update produtos
set preco=new.preco
where produto_id = new.produto_id;

insert into preco_produtos values
(1,3.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(2,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(3,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(4,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(5,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(6,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(7,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(8,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(9,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(10,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(11,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(12,3.50,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(13,5.50,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(14,3.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(15,5.00,DATE_SUB(curdate(),INTERVAL 10 DAY),'admin');

-- CADASTRO DE CONTAS A PAGAR E COMPRAS
create table fornecedores(
	fornecedor_id integer primary key auto_increment,
	cnpj varchar(30),
	nome_fornecedor varchar(50) not null,
	data_cadastro date not null,
	usuario varchar(10) not null,
	constraint fk_fornecedor_usuario foreign key (usuario) references usuarios(login) on update cascade
);
insert into fornecedores values
(default,'12345678000101','COCA COLA',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,null,'PÃO DE QUEIJO E CIA',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,'12365487000103','PEPSICO',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin'),
(default,null,'TIO DO SALGADO',DATE_SUB(curdate(),INTERVAL 10 DAY),'admin');

create table faturas_de_compras(
	num_fatura integer primary key auto_increment,
	fornecedor_id integer,
	data_vencimento date not null,
	data_pagamento date,
	valor_fatura decimal(5,2),
	valor_efetivamente_pago decimal(5,2),
	forma_pagamento varchar(10),
	usuario varchar(10) not null,
	constraint fk_fatura_c_usuario foreign key (usuario) references usuarios(login) on update cascade,
	constraint fk_fatura_fornecedor foreign key (fornecedor_id) references fornecedores(fornecedor_id)
);
insert into faturas_de_compras values
(default,1,DATE_ADD(curdate(),INTERVAL 25 DAY),null,0,0,null,'admin'),
(default,2,curdate(),curdate(),0,50.00,'DINHEIRO','admin'),
(default,3,DATE_ADD(curdate(),INTERVAL 20 DAY),null,0,0,null,'admin'),
(default,4,curdate(),curdate(),0,110.00,'DEBITO','admin');

create table compras(
	num_compra integer primary key auto_increment,
	num_fatura integer not null,
	data_compra date not null,
	hora_compra time not null,
	valor_total decimal(5,2),
	constraint fk_compras_fatura foreign key (num_fatura) references faturas_de_compras(num_fatura)
);
insert into compras values
(default,1,DATE_SUB(curdate(),INTERVAL 5 DAY),curtime(),null),
(default,2,curdate(),curtime(),null),
(default,3,DATE_SUB(curdate(),INTERVAL 10 DAY),curtime(),null),
(default,4,curdate(),curtime(),null),
(default,3,curdate(),curtime(),null);

create table itens_compras(
	num_compra integer not null,
	produto_id integer not null,
	valor_unitario decimal(5,2) not null,
	quantidade integer not null,
	constraint fk_itens_compras foreign key (num_compra) references compras(num_compra) on delete cascade,
	constraint fk_itens_produtos foreign key (produto_id) references produtos(produto_id)
);
-- Cria um procedimento armazenado que atualiza o valor_total da compra, a quantidade de produtos em estoque e o valor da fatura
delimiter //
create procedure sp_atualizar_v_compra_qtdade_prod_e_val_fatura(ncompra integer, pid integer, qtdade decimal(5,2))
begin
update compras
set valor_total=(select sum(quantidade * valor_unitario) from itens_compras where num_compra = ncompra)
where num_compra = ncompra;
update produtos
set qtd_estoque = qtd_estoque + qtdade where produto_id = pid;
update faturas_de_compras
set valor_fatura = (select sum(valor_total) from compras where num_fatura = (select num_fatura from compras where num_compra = ncompra))
where num_fatura = (select num_fatura from compras where num_compra = ncompra);
end//
delimiter ;
-- Cria um gatilho que chama o procedimento 
create trigger tr_atualiza_valor_total_compras after insert on itens_compras
for each row
call sp_atualizar_v_compra_qtdade_prod_e_val_fatura(new.num_compra,new.produto_id,new.quantidade);
insert into itens_compras values
(1,13,2.50,22),
(1,15,2.30,48),
(2,1,1,50),
(3,12,1.50,22),
(4,2,3.00,5),
(4,3,3.00,5),
(4,4,3.00,5),
(4,5,3.00,5),
(4,7,3.00,3),
(4,8,3.00,3),
(4,9,3.00,3),
(4,10,3.00,5),
(4,11,3.00,5),
(5,12,1.20,16);

create view vw_faturas_de_compras_em_aberto as
select f.num_fatura, c.num_compra, p.nome_prod, i.quantidade, i.valor_unitario, c.valor_total, c.data_compra, f.data_vencimento, f.valor_fatura, fo.nome_fornecedor
from produtos p inner join itens_compras i on i.produto_id = p.produto_id
inner join compras c on i.num_compra = c.num_compra
inner join faturas_de_compras f on c.num_fatura = f.num_fatura
inner join fornecedores fo on f.fornecedor_id = fo.fornecedor_id
where f.data_pagamento is null;

create view vw_itens_comprados_hoje as
select i.num_compra,p.nome_prod,i.valor_unitario,i.quantidade,i.valor_unitario * quantidade as subtotal, c.data_compra as data
from itens_compras i inner join produtos p on i.produto_id = p.produto_id
inner join compras c on i.num_compra = c.num_compra where c.data_compra = curdate();

-- CADASTRO DE CONTAS A RECEBER E VENDAS
create table clientes(
	pessoa_id integer primary key,
	limite_credito decimal(5,2) not null,
	status varchar(1) not null,
	obs varchar(100),
	usuario varchar(10) not null,
	constraint fk_cliente_usuario foreign key (usuario) references usuarios(login) on update cascade
);
alter table clientes add
constraint fk_cliente_pessoa foreign key (pessoa_id) references pessoas(pessoa_id) on delete cascade;
insert into clientes values
(2,100.00,'V','Tem que ficar no pé','admin'),
(3,50.00,'V','Bom pagador','admin'),
(4,0.00,'A','Em Validação de Crédito','app'),
(5,0.00,'F','Caloteiro não Faturar','dona');

create view vw_clientes as
select p.pessoa_id, p.cpf, concat(p.pri_nome,' ',p.sobrenome) as nome,
p.tipo_pessoa as tipo, p.descricao, t.telefone, t.celular, u.login,
c.limite_credito as credito, c.status, c.obs
from clientes c inner join pessoas p on c.pessoa_id = p.pessoa_id
inner join telefones t on p.pessoa_id = t.pessoa_id
left join usuarios u on p.pessoa_id = u.pessoa_id;

create table faturas_de_vendas(
	num_fatura integer primary key auto_increment,
	pessoa_id integer not null,
	data_vencimento date not null,
	data_pagamento date,
	valor_fatura decimal(5,2),
	valor_efetivamente_pago decimal(5,2),
	forma_pagamento varchar(10) not null,
	usuario varchar(10) not null,
	constraint fk_fatura_v_usuario foreign key (usuario) references usuarios(login) on update cascade,
	constraint fk_fatura_cliente foreign key (pessoa_id) references clientes(pessoa_id)
);
insert into faturas_de_vendas values
(default,2,DATE_SUB(curdate(),INTERVAL 25 DAY),curdate(),0,28.00,'CREDITO','admin'),
(default,3,DATE_ADD(curdate(),INTERVAL 5 DAY),null,0,0,null,'admin');

create table vendas(
	num_venda integer primary key auto_increment,
	num_fatura integer,
	data_venda date not null,
	hora_venda time not null,
	valor_total decimal(5,2),
	forma_pagto varchar(10) not null,
	usuario varchar(10) not null,
	constraint fk_vendas_usuario foreign key (usuario) references usuarios(login) on update cascade,
	constraint fk_vendas_fatura foreign key (num_fatura) references faturas_de_vendas(num_fatura)
);
-- Cria um Gatilho que insere um lançamento de entrada no caixa a cada venda a vista ('DINHEIRO','CREDITO','DEBITO')
delimiter //
create trigger tr_lanca_venda_a_vista_entrada_caixa after insert on vendas
for each row
begin
	if new.num_fatura is null then
		insert into caixa values(default,'admin',concat('VENDA DIRETA N:',new.num_venda),new.data_venda,new.hora_venda,'E',new.forma_pagto,new.valor_total);
	end if;
end//
delimiter ;
insert into vendas values
(default,1,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:00:05',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:01:25',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:01:45',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:02:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:03:25',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:04:15',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:04:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:04:55',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:05:25',0,'DEBITO','admin'),
(default,2,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:06:00',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:07:25',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:07:55',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:08:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 3 DAY),'09:09:00',0,'CREDITO','admin'),
(default,1,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:00:05',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:01:00',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:01:25',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:02:15',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:02:40',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:05:25',0,'DINHEIRO','admin'),
(default,2,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:06:00',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:06:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:08:25',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:09:25',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 2 DAY),'09:09:55',0,'DINHEIRO','admin'),
(default,1,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:00:05',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:01:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:01:45',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:02:25',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:03:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:04:15',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:04:25',0,'DINHEIRO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:04:55',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:05:25',0,'DINHEIRO','admin'),
(default,2,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:06:00',0,'FATURAR','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:07:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:07:55',0,'CREDITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:08:25',0,'DEBITO','admin'),
(default,null,DATE_SUB(curdate(),INTERVAL 1 DAY),'09:09:00',0,'CREDITO','admin');

create table itens_vendas(
	num_venda integer not null,
	produto_id integer not null,
	valor_unitario decimal(5,2) not null,
	quantidade integer not null,
	constraint fk_itens_vendas foreign key (num_venda) references vendas(num_venda) on delete cascade,
	constraint fk_itens_v_produtos foreign key (produto_id) references produtos(produto_id)
);
-- Cria um gatilho que atualiza o valor total da venda ao inserir um item_venda
create trigger tr_atualiza_valor_total_venda after insert
on itens_vendas
for each row
update vendas
set valor_total=(select sum(quantidade * valor_unitario) from itens_vendas where num_venda = new.num_venda)
where num_venda = new.num_venda;
-- Cria um gatilho que atualiza o valor do caixa e o valor_fatura quando o valor_total da venda é atualizado
delimiter //
create trigger tr_atualiza_valor_caixa_e_fatura_vendas after update on vendas
for each row
begin
	if new.num_fatura is null then
		update caixa
		set valor=(select sum(valor_total) from vendas where num_venda = new.num_venda)
		where descricao = concat('VENDA DIRETA N:',new.num_venda);
	else
		update faturas_de_vendas
		set valor_fatura=(select sum(valor_total) from vendas where num_fatura = new.num_fatura)
		where num_fatura = new.num_fatura;
	end if;	
end //
delimiter ;
insert into itens_vendas values
(1,1,(select preco from produtos where produto_id =1),2),
(1,13,(select preco from produtos where produto_id =13),1),
(2,2,(select preco from produtos where produto_id =2),1),
(3,1,(select preco from produtos where produto_id =1),1),
(4,2,(select preco from produtos where produto_id =2),1),
(5,3,(select preco from produtos where produto_id =3),1),
(9,1,(select preco from produtos where produto_id =1),2),
(7,4,(select preco from produtos where produto_id =4),1),
(8,1,(select preco from produtos where produto_id =1),1),
(9,6,(select preco from produtos where produto_id =6),1),
(10,1,(select preco from produtos where produto_id =1),1),
(11,8,(select preco from produtos where produto_id =8),2),
(12,1,(select preco from produtos where produto_id =1),1),
(12,15,(select preco from produtos where produto_id =15),1),
(13,3,(select preco from produtos where produto_id =3),1),
(14,1,(select preco from produtos where produto_id =1),1),
(15,9,(select preco from produtos where produto_id =9),2),
(16,3,(select preco from produtos where produto_id =3),1),
(17,2,(select preco from produtos where produto_id =2),1),
(18,11,(select preco from produtos where produto_id =11),1),
(19,12,(select preco from produtos where produto_id =12),1),
(20,1,(select preco from produtos where produto_id =1),2),
(21,3,(select preco from produtos where produto_id =3),1),
(22,1,(select preco from produtos where produto_id =1),1),
(23,5,(select preco from produtos where produto_id =5),1),
(24,1,(select preco from produtos where produto_id =1),2),
(24,12,(select preco from produtos where produto_id =12),2),
(25,8,(select preco from produtos where produto_id =8),1),
(26,9,(select preco from produtos where produto_id =9),1),
(27,10,(select preco from produtos where produto_id =10),1),
(28,1,(select preco from produtos where produto_id =1),1),
(29,2,(select preco from produtos where produto_id =2),1),
(30,11,(select preco from produtos where produto_id =11),1),
(31,12,(select preco from produtos where produto_id =12),1),
(32,1,(select preco from produtos where produto_id =1),2),
(33,3,(select preco from produtos where produto_id =3),1),
(34,1,(select preco from produtos where produto_id =1),1),
(35,5,(select preco from produtos where produto_id =5),1),
(36,1,(select preco from produtos where produto_id =1),2),
(37,8,(select preco from produtos where produto_id =8),1),
(38,9,(select preco from produtos where produto_id =9),1),
(39,10,(select preco from produtos where produto_id =10),1);
create view vw_faturas_de_vendas_em_aberto as
select v.num_venda, v.num_fatura, v.data_venda, v.valor_total, v.forma_pagto, f.data_vencimento, p.pri_nome, f.valor_fatura, f.valor_efetivamente_pago, f.data_pagamento
from pessoas p inner join faturas_de_vendas f on p.pessoa_id = f.pessoa_id
inner join vendas v on f.num_fatura = v.num_fatura
where data_pagamento is null;
-- Inserindo uma nova venda hoje a faturar
insert into vendas values (default,2,curdate(),'09:06:00',0,'FATURAR','admin');
insert into itens_vendas values (40,1,(select preco from produtos where produto_id =1),1);
-- Inserindo lançamentos de saída no caixa conforme faturas pagas hoje.
insert into caixa values
(default, 'admin','PAGAMENTO DE FATURA DE COMPRA N:2',curdate(),curtime(),'S',(select forma_pagamento from faturas_de_compras where num_fatura = 2),(select valor_efetivamente_pago from faturas_de_compras where num_fatura = 2)),
(default, 'admin','PAGAMENTO DE FATURA DE COMPRA N:4',curdate(),curtime(),'S',(select forma_pagamento from faturas_de_compras where num_fatura = 4),(select valor_efetivamente_pago from faturas_de_compras where num_fatura = 4)),
(default, 'admin','RECEBIMENTO DE FATURA DE VENDA N:1',curdate(),curtime(),'E',(select forma_pagamento from faturas_de_vendas where num_fatura = 1),(select valor_efetivamente_pago from faturas_de_vendas where num_fatura = 1));

-- Consulta para comparar as senhas
select * from usuarios;
-- Consulta decodificando a senha
select * from usuarios where senha = PASSWORD('1234');
-- consultas diversas
select * from vw_clientes;
select * from produtos;
select * from compras;
select * from vw_itens_comprados_hoje;
select * from vw_faturas_de_compras_em_aberto;
select * from faturas_de_vendas;
select * from itens_vendas;
select * from vendas;
select * from vw_faturas_de_vendas_em_aberto;
select * from caixa;
show tables;