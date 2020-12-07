drop database if exists revendedor;
create database revendedor;
use revendedor;

case when saida <> "null" then hour(timediff(saida,entrada)) else hour(timediff(curtime(),entrada)) end as total_horas, 
case when saida <> "null" then hour(timediff(saida,entrada)) * valor else hour(timediff(curtime(),entrada)) * valor end as total
from registros;

select * from vw_registros;
show tables;
