Aplicação modelo: BD + FullStack + Mobile
Controle e administração de acessos
A documentação apresenta o MER/DER do banco de dados, bastante simples,
com apenas duas entidades (três tabelas) e relacionamentos
Um diagrama de classes da camada Model MVC
Um diagrama de casos de uso

O Banco de dados foi desenvolvido para o SGBD MySQL
O Back-End está em PHP "sem utilização de framework", parcialmente orientado a objeto e MVC
Os controles atendem a requisições "REST Full", porém dependendo das configurações do
servidor Apache, em hospedagens gratúitas, por exemplo, pode apresentar erro de CORS
"Permissões de acesso aos métodos PUT, DELETE ou OTHERS, para solucionar, basta utilizar
os verbos GET e POST tradicionais.
O Front-End está utilizando apenas HTML, CSS e JavaScript "xhtml e fetch, sem utilização de FraneWork"
O App "Mobile" está desenvolvido em ionic v3, possui funcionalidades reduzidas, somente
lista os dados do próprio usuário se este estiver configurado no banco de dados como comum e lista os
dados de todos os usuários, se estiver cadastrado como adm.

O objetivo deste projeto é estudar um ambiente de programação web x mobile de ponta a ponta.
Sem foco nas linguagens, mas na infra-estrutura, servidores de banco de dados, aplicação,
programação em camadas MVC, lógica e fluxo de dados.