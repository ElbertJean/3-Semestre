
use catalogo;
select * from cd;

select cd_nome, cd_preco_venda
from cd 
where cd_preco_venda=
(select max(cd_preco_venda) from cd); 

select cd_nome, cd_preco_venda
from cd
order by cd_preco_venda desc
limit 1;

select cd_nome, max(cd_preco_venda)
from cd
group by cd_nome
having max(cd_preco_venda) = 
(select max(cd_preco_venda) from cd); 



update cd
set cd_preco_venda=1.1*cd_preco_venda
where cd_preco_venda =1;

create table cd_menor as
select cd_nome, cd_preco_venda
from cd where cd_preco_venda < 
   (select avg(cd_preco_venda) from cd);
   
   describe cd_menor;
   select * from cd;

SELECT * FROM CD_MENOR;
DROP TABLE CD_MENOR;




(select min(cd_preco_venda) from cd_menor);



Select grav_codigo,grav_nome from gravadora
    where not EXISTS (select * from CD 
     where cd.grav_codigo= gravadora.grav_codigo);


select distinct g.grav_codigo,g.grav_nome
from gravadora g, cd c
where g.grav_codigo=c.grav_codigo;

select distinct g.grav_codigo,g.grav_nome
from gravadora g, cd c
where g.grav_codigo=c.grav_codigo;

select distinct g.grav_codigo,g.grav_nome
from gravadora g inner join cd c
on g.grav_codigo=c.grav_codigo;


    Select cd_codigo, cd_nome, cd_preco_venda
    from CD
    where cd_preco_venda not in
    (select min(cd_preco_venda)
    from CD
    group by grav_codigo);
     --    (10,12,20)  in  (10,12)
                   
   select * from cd;                


  Select cd_codigo, cd_nome, cd_preco_venda
  From CD
  Where cd_preco_venda =any 
  (Select cd_preco_venda
  From CD
  Where grav_codigo=1); 
   -- (10,12,20) >  (10,20)
    --      select * from cd;         
  
  Select cd_preco_venda
  From CD
  Where grav_codigo=1;
--    (10,12,20) < (10,12) 

select distinct g.grav_codigo,g.grav_nome
from gravadora g inner join cd c
on g.grav_codigo=c.grav_codigo;


   Select cd_codigo, cd_nome, cd_preco_venda
   from CD
   where cd_preco_venda > ALL (
   select AVG(cd_preco_venda)
   from CD
   group by grav_codigo);
    --   (10,12,20)          (15,12)
   
   select AVG(cd_preco_venda)
   from CD
   group by grav_codigo;


SELECT cd_nome, cd_preco_venda,
       CASE
       WHEN cd_preco_venda < 10 then cd_preco_venda * 0.10
       WHEN cd_preco_venda >=10 and cd_preco_venda < 13 then cd_preco_venda * 0.20
      ELSE cd_preco_venda * 0.30
      END VENDA
      FROM CD;
      
      
	UPDATE CD SET cd_preco_venda =
    CASE
      WHEN cd_preco_venda < 10 then cd_preco_venda * 1.10
       WHEN cd_preco_venda >=10 and cd_preco_venda < 13 then cd_preco_venda * 1.20
      ELSE cd_preco_venda * 1.30
      END;


update cd
set cd_preco_venda=1.1*cd_preco_venda
where cd_preco_venda = (select max(cd_preco_venda) from cd);



