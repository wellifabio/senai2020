drop database if exists estacionamento;
create database estacionamento;
use estacionamento;

create table veiculos(
    placa varchar(7) not null primary key,
    modelo varchar(20) not null,
	marca varchar(20),
	obs VARCHAR(256)
);
create table vagas(
	n_vaga integer not null primary key auto_increment,
	descricao varchar(40) not null,
	valor decimal(8,2) not null
);
create table registros(
    placa varchar(7) not null,
    data date not null,
    entrada time not null,
    saida time,
    n_vaga integer not null,
	constraint fk_registro_veiculo foreign key (placa) references veiculos(placa),
	constraint fk_registro_vaga foreign key (n_vaga) references vagas(n_vaga)
);

insert into veiculos values
('AAA1A11','KA','FORD',null),
('AAA1A22','FIESTA','FORD','Porta dianteira direita riscada'),
('AAA1A32','COURRIER','FORD',null),
('AAA1A34','FIESTA','FORD','Porta malas amassado'),
('AAA1A55','RANGER','FORD',null),
('ADA1A22','CG TITAN','RONDA',null),
('ADA1A24','FAN','RONDA',null),
('BBB1A11','GOL','VW',null),
('BBC1A21','POLO','VW',null),
('CCC1A11','SAVEIRO','VW',null),
('CDC1A21','VOYAGE','VW',null),
('DDD1A11','FAZER','YAMAHA','Lanterna direita quebrada'),
('DDD1A21','YBR','YAMAHA',null),
('FDF1A21','UNO','FIAT',null),
('FFF1A11','PALIO','FIAT',null),
('SAA1A11','NOVO PALIO','FIAT','Lanterna esquerda quebrada'),
('SDA1A22','TORO','FIAT',null),
('SDF1A21','FIORINO','FIAT',null),
('SDS1A20','UNO','FIAT','Porta dianteira esquerda riscada'),
('SDS1A21','FIORINO','FIAT','Porta dianteira esquerda riscada'),
('SDT1A21','PALIO','FIAT',null),
('SDX1A21','STRADA','FIAT',null),
('SSS1A00','CELTA','CHEVROLET',null),
('SSS1A11','PRISMA','CHEVROLET','Porta traseira esquerda riscada'),
('TDT1A21','CORSA','CHEVROLET',null),
('TTT1A11','ONIX','CHEVROLET','Porta traseira direita riscada'),
('XDX1A21','CORSA','CHEVROLET',null),
('XXX1A11','PRISMA','CHEVROLET',null);

insert into vagas values
(default,"Carro Sombra",12.5),
(default,"Carro Sombra",12.5),
(default,"Carro Sombra",12.5),
(default,"Carro Sombra",12.5),
(default,"Carro Sol",10),
(default,"Carro Sol",10),
(default,"Carro Sol",10),
(default,"Carro Sol",10),
(default,"Carro Sol",10),
(default,"Carro Sol",10),
(default,"Moto Sombra",5),
(default,"Moto Sombra",5),
(default,"Moto Sombra",5),
(default,"Moto Sombra",5),
(default,"Moto Sol",5),
(default,"Moto Sol",5),
(default,"Moto Sol",5),
(default,"Moto Sol",5);

insert into registros values
("AAA1A11",curdate()-2,date_add(now(),interval - 5 hour),date_add(now(),interval - 3 hour),1),
("BBB1A11",curdate()-2,date_add(now(),interval - 5 hour),date_add(now(),interval - 4 hour),2),
("SSS1A00",curdate()-2,date_add(now(),interval - 4 hour),date_add(now(),interval - 2 hour),3),
("CCC1A11",curdate()-2,date_add(now(),interval - 4 hour),date_add(now(),interval - 1 hour),4),
("DDD1A11",curdate()-2,date_add(now(),interval - 3 hour),date_add(now(),interval - 1 hour),15),
("SSS1A11",curdate()-2,date_add(now(),interval - 2 hour),date_add(now(),interval - 1 hour),6),
("TTT1A11",curdate()-2,date_add(now(),interval - 1 hour),curtime(),7),
("XXX1A11",curdate()-2,curtime(),date_add(now(),interval + 3 hour),8),
("FFF1A11",curdate()-2,date_add(now(),interval + 1 hour),date_add(now(),interval + 3 hour),9),
("DDD1A11",curdate()-2,date_add(now(),interval + 1 hour),date_add(now(),interval + 2 hour),18),
("AAA1A22",curdate()-2,date_add(now(),interval + 2 hour),date_add(now(),interval + 4 hour),1),
("AAA1A32",curdate()-2,date_add(now(),interval + 3 hour),date_add(now(),interval + 4 hour),2),
("AAA1A34",curdate()-2,date_add(now(),interval + 4 hour),date_add(now(),interval + 5 hour),9),
("AAA1A55",curdate()-1,date_add(now(),interval - 5 hour),date_add(now(),interval - 3 hour),8),
("BBC1A21",curdate()-1,date_add(now(),interval - 5 hour),date_add(now(),interval - 4 hour),7),
("SDS1A20",curdate()-1,date_add(now(),interval - 4 hour),date_add(now(),interval - 2 hour),6),
("CDC1A21",curdate()-1,date_add(now(),interval - 4 hour),date_add(now(),interval - 1 hour),10),
("DDD1A21",curdate()-1,date_add(now(),interval - 3 hour),date_add(now(),interval - 1 hour),11),
("SDS1A21",curdate()-1,date_add(now(),interval - 2 hour),date_add(now(),interval - 1 hour),3),
("TDT1A21",curdate()-1,date_add(now(),interval - 1 hour),curtime(),2),
("XDX1A21",curdate()-1,curtime(),date_add(now(),interval + 3 hour),1),
("FDF1A21",curdate()-1,date_add(now(),interval + 1 hour),date_add(now(),interval + 3 hour),10),
("AAA1A11",curdate()-1,date_add(now(),interval + 1 hour),date_add(now(),interval + 2 hour),2),
("ADA1A22",curdate()-1,date_add(now(),interval + 2 hour),date_add(now(),interval + 4 hour),14),
("ADA1A22",curdate()-1,date_add(now(),interval + 3 hour),date_add(now(),interval + 4 hour),15),
("ADA1A24",curdate()-1,date_add(now(),interval + 4 hour),date_add(now(),interval + 6 hour),16),
("AAA1A55",curdate(),date_add(now(),interval - 5 hour),date_add(now(),interval - 3 hour),9),
("BBC1A21",curdate(),date_add(now(),interval - 5 hour),date_add(now(),interval - 4 hour),8),
("SDS1A20",curdate(),date_add(now(),interval - 4 hour),date_add(now(),interval - 2 hour),1),
("CDC1A21",curdate(),date_add(now(),interval - 4 hour),date_add(now(),interval - 1 hour),2),
("DDD1A21",curdate(),date_add(now(),interval - 3 hour),date_add(now(),interval - 1 hour),15),
("SDS1A21",curdate(),date_add(now(),interval - 2 hour),null,4),
("SDT1A21",curdate(),date_add(now(),interval - 1 hour),curtime(),5),
("SDX1A21",curdate(),curtime(),null,6),
("SDF1A21",curdate(),date_add(now(),interval - 1 hour),null,7),
("SAA1A11",curdate(),curtime(),null,8),
("SDA1A22",curdate(),date_add(now(),interval - 2 hour),null,9),
("AAA1A11",curdate(),curtime(),null,10),
("ADA1A24",curdate(),date_add(now(),interval - 1 hour),null,11);

create view vw_registros as
select r.n_vaga, r.placa, v.modelo, r.data, r.entrada, r.saida, va.valor,
case when r.saida <> "null" then hour(timediff(r.saida,r.entrada)) else hour(timediff(curtime(),r.entrada)) end as total_horas, 
case when r.saida <> "null" then hour(timediff(r.saida,r.entrada)) * valor 
else case when hour(timediff(curtime(),r.entrada)) < 1 then 1 * va.valor
else hour(timediff(curtime(),r.entrada)) * va.valor
end end as total,
va.descricao
from registros r inner join veiculos v on r.placa = v.placa
inner join vagas va on r.n_vaga = va.n_vaga
order by r.data, va.descricao, r.entrada;

create view vw_estacionados_agora as
select r.n_vaga, r.placa, v.modelo, r.data, r.entrada, r.saida, va.valor,
case when r.saida <> "null" then hour(timediff(r.saida,r.entrada)) else hour(timediff(curtime(),r.entrada)) end as total_horas, 
case when r.saida <> "null" then hour(timediff(r.saida,r.entrada)) * valor 
else case when hour(timediff(curtime(),r.entrada)) < 1 then 1 * va.valor
else hour(timediff(curtime(),r.entrada)) * va.valor
end end as total,
va.descricao, v.obs
from registros r inner join veiculos v on r.placa = v.placa
inner join vagas va on r.n_vaga = va.n_vaga
where r.saida is null
order by r.data, va.descricao, r.entrada;


select * from veiculos;
select * from vagas;
select * from registros;
select * from vw_registros;
select * from vw_estacionados_agora;
show tables;
