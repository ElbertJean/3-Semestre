use venda;
create table departamento
(dep_id int primary key,
 dep_descricao varchar(30));

create table funcionario
(fun_cod int primary key,
 fun_nome varchar(20),
 fun_sal decimal(10,2),
 dep_id int references departamento (dep_id));

create table telefone2
(tel_codigo int primary key,
 func_cod int references funcionario(func_cod),
 tel_numero int );

insert into departamento values (1,'RH');
insert into departamento values (2,'Vendas');
insert into departamento values (3,'Informática');
insert into departamento values (4,'Compras');

insert into funcionario values (1,'Paulo',4000.00,1);
insert into funcionario values (2,'Maria',1500.00,2);
insert into funcionario values (3,'João',4000.00,1);
insert into funcionario values (4,'Laura',5000.00,2);
insert into funcionario values (5,'Ana',6000.00,3);
insert into funcionario values (6,'Maria',null,null);


insert into telefone2 values (1,1,39231546);
insert into telefone2 values (2,2,97858999);

commit;