-- 1. (1,0) Liste os CDs que possuem a data de lançamento maior que 01/06/2014 e o preço de venda maior
-- que 30.50 ordenados pelo nome. Exiba: (cd_nome,cd_preco_venda,cd_data_lançamento).

select cd_nome, cd_preco_venda, cd_data_lancamento
from cd
where cd_data_lancamento > '2014-06-01'
and cd_preco_venda > 30.50
order by cd_nome;

-- 2. (2,0) Liste apenas as que não possuem CDs relacionados. Exiba: (grav_nome).

select g.grav_nome 
from gravadora g
left join cd c on g.grav_codigo = c.grav_codigo
where c.grav_codigo is null;

-- 3. (2,0) Exibir a quantidade de músicas que cada autor possui, lista também os autores que não possuem
-- músicas. Exiba:(Aut_Nome,Quantidade).

select a.aut_nome, count(am.mus_codigo) as Quantidade
from autor a
left join autor_musica am on a.aut_codigo = am.aut_codigo
group by a.aut_codigo, a.aut_nome;

-- 4.(1,0) Exiba o nome do CD mais caro.

select cd_nome, cd_preco_venda
from cd
where cd_preco_venda = (select max(cd_preco_venda) from cd);

-- 5.(2,0) Crie uma view para listar o nome do autor responsável pela música Pais e Filhos.

create view vw_autor_musica_pais_e_filhos AS
select a.aut_nome
from autor a
join autor_musica am on a.aut_codigo = am.aut_codigo
join musica m on am.mus_codigo = m.mus_codigo
where m.mus_nome = 'Pais e Filhos';


-- 6. (2,0) Exiba a duração correspondente ao CD de nome “ CD1”.

select m.mus_nome, m.mus_duracao
from cd c
join faixa f on c.cd_codigo = f.cd_codigo
join musica m on f.mus_codigo = m.mus_codigo
where c.cd_nome = 'CD1';

