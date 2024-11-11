create database catalogo;

use catalogo;

create table gravadora(
	grav_codigo int primary key,
    grav_nome varchar(60),
    grav_endereco varchar(60),
    grav_telefone varchar(20),
    grav_contato varchar(20),
    grav_endsite varchar(80));
    
create table cd_categoria(
	cat_codigo int primary key,
    menor_preco decimal(14,2),
    maior_preco decimal(14,2));
    
create table cd(
	cd_codigo int primary key,
    cd_nome varchar(60),
    cd_preco_venda decimal(14,2),
    cd_data_lancamento date,
    grav_codigo int,
    cd_indicado int,
    foreign key(grav_codigo) references gravadora(grav_codigo),
    foreign key(cd_indicado) references cd(cd_codigo));
    
create table musica(
	mus_codigo int not null primary key,
    mus_nome varchar(60),
    mus_duracao decimal(6,2));
    
create table faixa(
	cd_codigo int,
    mus_codigo int,
    faixa_numero int,
    primary key (cd_codigo, mus_codigo),
    foreign key(cd_codigo) references cd(cd_codigo),
    foreign key(mus_codigo) references musica(mus_codigo));
    
create table autor(
	aut_codigo int not null primary key,
    aut_nome varchar(60));    
    
create table autor_musica(
	aut_codigo int,
    mus_codigo int,
    primary key (aut_codigo, mus_codigo),
    foreign key(aut_codigo) references autor(aut_codigo),
    foreign key(mus_codigo) references musica(mus_codigo));
    
-- Script DML para testes 

insert into autor values (1,'Caetano Veloso');
insert into autor values (2,'Ana Carolina');
insert into autor values (3,'Nando Reis');
insert into autor values (4,'Edi Mota');
insert into autor values (5,'Elis Regina');

insert into musica values (1,'Alegria Alegria',50);
insert into musica values (2,'Quem de nós dois',50);
insert into musica values (3,'É isso aí',50);
insert into musica values (4,'Por Onde Andei',45);
insert into musica values (5,'Fora da Lei',60);
insert into musica values (6,'Maria Maria',60);
insert into musica values (7,'Andança',60);

insert into CD_CATEGORIA values (1,5,10);
insert into CD_CATEGORIA values (2,11,20);
insert into CD_CATEGORIA values (3,21,30);

insert into gravadora values (1,'sony','a','222','joao','www.a.com.br');
insert into gravadora values (2,'eletronic','b','223','jose','www.b.com.br');
insert into gravadora values (3,'teste','b','223','jose','www.b.com.br');

insert into cd values (1,'CD1',10,NOW(),1,null);
insert into cd values (2,'CD2',12,NOW(),2,1);
insert into cd values (3,'CD3',20.00,NOW(),1,null);

insert into faixa values (1,6,1);
insert into faixa values (1,7,2);

insert into autor_musica values (5,6);
insert into autor_musica values (5,7);