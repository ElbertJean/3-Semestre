CREATE TABLE PEDIDO
(  ped_id int primary key, 
   ped_data date,  
   ped_valor_total decimal(9,2)
);
insert into pedido values (1,'2024-3-12',0);
insert into pedido values (2,'2024-3-13',0);
insert into pedido values (3,'2024-3-14',0);

select * from information_schema.table_constraints
where table_name='pedido';

CREATE TABLE PRODUTO
(    pro_id int primary key,    
     pro_nome varchar(30) not null,    
     pro_quantidade int,    
     pro_valor decimal(9,2) 
 );

insert into produto values (1,'Caneta',100,2.50);
insert into produto values (2,'Caderno',100,5.00);
insert into produto values (3,'Lapiseira',300,10.00);

create table itempedido 
 (  ped_cod int,     
    pro_cod int, 
    ite_quantidade int,
    ite_valor decimal(7,2),     
    constraint fk_ped_cod Foreign Key(ped_cod) references pedido(ped_id),
	constraint fk_pro_cod Foreign Key (pro_cod) references produto(pro_id),
    primary key (ped_cod,pro_cod));
    

  insert into itempedido 
  values (1,1,1,2.5),(1,2,1,5.00),
  (2,3,2,20.00),(2,1,1,2.5);
  describe itempedido;


alter table pedido add cli_id int;
ALTER TABLE pedido 
ADD CONSTRAINT fk_cli_cod
FOREIGN KEY (cli_id)
REFERENCES cliente (cli_id);

insert into cliente (cli_nome,cli_data_nasc)
values ('Ana','2001-12-19');  

update pedido
set cli_id=1
where ped_id in(1,2);