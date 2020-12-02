drop database if exists pedidos;
create database pedidos;
use pedidos;
create table usuarios(
    id integer not null primary key auto_increment,
    login varchar(40) not null unique
);
create table produtos(
    id_prod integer not null primary key auto_increment,
    nome varchar(40) not null,
    preco decimal(10,2) not null,
    imagem varchar(40)
);
create table pedidos(
    numero integer not null primary key auto_increment,
    id_user integer not null,
    data date not null,
    hora time not null,
    status varchar(20) not null,
    constraint fk_faz foreign key (id_user) references usuarios(id)
);
create table itens(
    n_pedido integer not null,
    id_prod integer not null,
    quantidade integer,
    constraint fk_possui_ped foreign key (n_pedido) references pedidos(numero) on delete cascade,
    constraint fk_possui_prod foreign key (id_prod) references produtos(id_prod),
    primary key (n_pedido,id_prod)
);

insert into usuarios values
(default,"Mariana Rocha"),
(default,"Márcio Garcia"),
(default,"Luciana Gimenes"),
(default,"André Aguiar");

insert into produtos values
(default,"Coxinha",5.5,null),
(default,"Suco Bioleve",3.5,null),
(default,"Pão de Queijo",4.5,null),
(default,"Hamburgão",6,null),
(default,"Refri Lata",6,null);

insert into pedidos values
(default,1,curdate()-2,curtime()+30,"Concluido"),
(default,2,curdate()-2,curtime()-50,"Concluido"),
(default,3,curdate()-1,curtime()+10,"Concluido"),
(default,1,curdate()-1,curtime()-30,"Pendente"),
(default,4,curdate()-1,curtime(),"Pendente"),
(default,3,curdate(),curtime()-30,"Aberto"),
(default,2,curdate(),curtime()-20,"Aberto"),
(default,4,curdate(),curtime(),"Aberto");

insert into itens values
(1,3,1),
(1,2,1),
(2,1,1),
(2,3,2),
(3,4,1),
(4,5,1),
(4,3,1),
(5,3,1),
(5,2,1),
(6,1,1),
(6,3,2),
(7,4,1),
(8,4,1),
(8,5,1);

-- Visão que mostra todos os pedidos com detalhes dos produtos
create view vw_pedidos_all as
select p.numero, u.login, p.data, p.hora, i.id_prod, pr.nome, pr.preco, i.quantidade, pr.preco * i.quantidade as subtotal, p.status
from pedidos p
inner join usuarios u on p.id_user = u.id
inner join itens i on p.numero = i.n_pedido
inner join produtos pr on i.id_prod = pr.id_prod
order by p.numero;

-- Visão que mostra todos os pedidos com detalhes dos produtos
create view vw_pedidos_total_all as
select p.numero, u.login, p.data, p.hora, sum(i.quantidade) as n_itens, sum(pr.preco * i.quantidade) as total, p.status
from pedidos p
inner join usuarios u on p.id_user = u.id
inner join itens i on p.numero = i.n_pedido
inner join produtos pr on i.id_prod = pr.id_prod
group by p.numero
order by p.numero;

-- Queries para obter informações das tabelas
select * from usuarios;
select * from produtos;
select * from vw_pedidos_all;
select * from vw_pedidos_total_all;

-- Queries para verificar os pedidos pelo Status e ajudar verificar o caixa
select * from vw_pedidos_all where status like "Pendente";
select * from vw_pedidos_all where status like "Aberto";
select *, sum(total) as total_dia from vw_pedidos_total_all where status like "Concluido" group by data;

show tables;
