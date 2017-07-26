
-- select all--
SELECT * FROM administrador;
SELECT * FROM arl;
SELECT * FROM activdadeconomica;
SELECT * FROM certificaciones;
SELECT * FROM departamento; 
SELECT * FROM contratista;
SELECT * FROM contratante;
SELECT * FROM contrato;
DELETE FROM contrato WHERE idContrato=3;
SELECT * FROM usuarios;
SELECT * FROM categoria;
SELECT * FROM requisitos;
SELECT *  FROM extras;
SELECT * FROM requisitosobligatoriosExtras;
SELECT *  FROM requisitosobligatoriossugeridos;
SELECT *  FROM imagenes;
SELECT *  FROM documentos;
SELECT * FROM finalista;
select *  from ejecuionextrassestaticosdeffinalizaciondeactivdades;
select *  from ejecuionsugeridosestaticosdeffinalizaciondeactivdades;
select *  from requisitosdeejecuionextrasdefestaticosejecucionactividades;
select *  from requisitosdeejecuiondefsugeridosestaticosejecucionactividades;
select *  from requisitosdeejecuiondefextrasestaticosprevio;
select *  from requisitosdeejecuiondefsugeridosestaticosprevio;
select *  from requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades;
select *  from requisitosdeejecuionsugeridosestaticosejecucionactividades;
select *  from requisitosdeejecuionsugeridosestaticosprevio;
select *  from documentosestaticospreviosobli;
select * from finalista;



select * from requidinadeffinalsug as re inner join requidinafinalsug as r  where re.idRequisito=r.id ;

select  * from sys.actprevsuger;
select  * from sys.actprevext;
select * from sys.actejecsug;
select * from sys.actejecext;
select * from sys.actfinsug;
select * from sys.actfinext;


-- llenar requisitos previos sugeridos --
select t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio,t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosprevio as t1 ) left join sys.requisitosdeejecuiondefsugeridosestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio=t2.idRequsito and t2.idContratante= 1
where t2.idrequisitosdeejecuiondefsugeridosestaticosprevio is null and t1.idCategoria= 1;

-- llenar requisitos ejecucion sugeridos--
select t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades, t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as t1 ) left join sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as t2 on t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades=t2.idRequisito and t2.idContratante= 1
where t2.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades is null and t1.idCategoria= 1;

-- llenar requisitos finalizacion --
select t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades, t1.requisito from (sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as t1 ) left join sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as t2 on t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades=t2.idRequisito and t2.idContratante= 1
where t2.defFinalizaactiv is null and t1.idCategoria= 1;



-- llenar requisitos previos extras 
select t1.idRequisitosDeEjecuionSugeridosextrasPrevio,t1.requisito from (sys.requisitosdeejecuionextrasestaticosprevio as t1) left join sys.requisitosdeejecuiondefextrasestaticosprevio as t2 on t1.idRequisitosDeEjecuionSugeridosextrasPrevio=t2.idRequisito and t2.idContratante= 1
where t2.idrequisitosdeejecuiondefextrasestaticosprevio is null and t1.idCategoria= 1;

-- llenar requisitos ejecucion extras
select t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades,t1.requisito from (sys.requisitosdeejecuionextrasestaticosejecucionactividades as t1) left join sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as t2 on t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades=t2.idRequisito and t2.idContratante= 2
where t2.idrequisitosdeejecuionextrasestaticosejecucionactividades is null and t1.idCategoria= 2;

-- llenar requisitos finalizacion extras
select t1.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades from (sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as t1) left join sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as t2 on t1.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades=t2.idRequisito and t2.idContratante= 2
where t2.idejecuionextrassestaticosdeffinalizaciondeactivdades is null and t1.idCategoria= 2;

select * from requisitosdeejecuionextrasestaticosejecucionactividades;
select * from requisitosdeejecuionextrasdefestaticosejecucionactividades;

select contrato.idContrato,contrato.nombreContrato,contrato.fechaInicio,contrato.idContratante,contrato.tipoContrato from contrato left join finalista on finalista.idContrato=contrato.idContrato where finalista.idContrato is  null;

-- Traer Requisitos Previos Sugeridos Definitivos --
select ro.idrequisitosdeejecuiondefsugeridosestaticosprevio,ro.idContratante,r.idCategoria, ro.idRequsito,r.requisito from sys.requisitosdeejecuiondefsugeridosestaticosprevio as ro inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r where ro.idRequsito=r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and ro.idContratante= 2 and ro.idCategoria= 1 ;

-- Traer Requisitos Ejecucion Sugeridos Definitivos --
select ro.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as ro inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r where ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and ro.idContratante= 2 and ro.idCategoria= 1 ;

-- Traer Requisitos Finalizacion Sugeridos Definitivos --
select ro.defFinalizaactiv,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as ro inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r where ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and ro.idContratante= 2 and ro.idCategoria= 1 ;


-- Traer Requisitos Previos Extras Definitivos --
select ro.idrequisitosdeejecuiondefextrasestaticosprevio, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuiondefextrasestaticosprevio as ro inner join sys.requisitosdeejecuionextrasestaticosprevio as r where ro.idRequisito=r.idRequisitosDeEjecuionSugeridosextrasPrevio and ro.idContratante= 2 and ro.idCategoria= 1;

-- Traer Requisitos Ejecucion Extras Definitivos --
select ro.idrequisitosdeejecuionextrasestaticosejecucionactividades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as ro inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r where ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and ro.idContratante= 2 and ro.idCategoria= 1;

-- Traer Requisitos Finalizacion Extras Definitivos --
select ro.idejecuionextrassestaticosdeffinalizaciondeactivdades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito from sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as ro inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r where ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and ro.idContratante= 2 and ro.idCategoria= 1;


-- Estado Requisito Previos Sugeridos --
select DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosprevio,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,r.requisito,d.estado  from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as re inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on  re.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticospreviosobli as d  on re.idCategoria= 1 and re.idrequisitosdeejecuiondefsugeridosestaticosprevio=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;


-- Estado Requisito Previos Extras

select DISTINCT  re.idrequisitosdeejecuiondefextrasestaticosprevio,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.estado from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on  re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticospreviosextras as d  on re.idCategoria= 1 and re.idRequisito=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;

-- Estado Requisitos Ejecucion Sugeridos
select DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,r.requisito,d.estado from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as re inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticosejecsug as d  on re.idCategoria= 1 and re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;

-- Estado Requisitos Ejecucion Extras
select DISTINCT  re.idrequisitosdeejecuionextrasestaticosejecucionactividades,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito,d.estado from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticosejecext as d  on re.idCategoria= 1 and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;

-- Estado Requisitos Finalización Sugeridos
select DISTINCT  re.defFinalizaactiv,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,r.requisito,d.estado from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticosfinalisug as d  on re.idCategoria= 1 and re.defFinalizaactiv=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;

-- Estado Requisitos Finalizacion Extras
select DISTINCT  re.idejecuionextrassestaticosdeffinalizaciondeactivdades,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito,d.estado from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria= 1 and re.idContratante= 2) left join sys.documentosestaticosfinaliext as d  on re.idCategoria= 1 and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
where d.idFinalista is  null or d.idFinalista is not null;


-- *












-- Requisitos Previos sugeridos cumplidos --

select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticospreviosobli as i  on  rs.idCategoria= 1 and i.idFinalista= 1 and rs.idContratante= 2 and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is not  null;

-- Requisitos Previos sugeridos No cumplidos --
select rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosprevio as rs inner join sys.requisitosdeejecuionsugeridosestaticosprevio as r on rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticospreviosobli as i  on  rs.idCategoria= 1 and i.idFinalista= 3 and rs.idContratante= 2 and rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito where i.idFinalista is   null;


select * from finalista;
-- Requisitos Previos Extras cumplidos --
select re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.tipo from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticospreviosextras as d  on re.idCategoria=1 and d.idFinalista=1 and re.idContratante= 2 and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito
where d.idFinalista is not  null;


-- Requisitos Previos Extras No cumplidos --
select * from (sys.requisitosdeejecuiondefextrasestaticosprevio as re inner join sys.requisitosdeejecuionextrasestaticosprevio as r on re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticospreviosextras as d  on re.idCategoria=1 and d.idFinalista=1 and re.idContratante= 2 and re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito
where d.idFinalista is  null;


-- Requisitos Ejecucion sugeridos cumplidos -
select rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,i.tipo from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as rs inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticosejecsug as i  on  rs.idCategoria= 1 and i.idFinalista= 1 and rs.idContratante= 2 and rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito where i.idFinalista is not  null;

-- Requisitos Ejecucion sugeridos No cumplidos -
select * from (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades as rs inner join sys.requisitosdeejecuionsugeridosestaticosejecucionactividades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticosejecsug as i  on  rs.idCategoria= 1 and i.idFinalista= 1 and rs.idContratante= 2 and rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito where i.idFinalista is  null;


-- Requisitos Ejecucion Extras cumplidos -
select re.idrequisitosdeejecuionextrasestaticosejecucionactividades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticosejecext as d  on re.idCategoria=1 and d.idFinalista=1 and re.idContratante= 2 and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
where d.idFinalista is not  null;

-- Requisitos Ejecucion Extras No cumplidos -
select * from (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades as re inner join sys.requisitosdeejecuionextrasestaticosejecucionactividades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticosejecext as d  on re.idCategoria=1 and d.idFinalista=2 and re.idContratante= 2 and re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
where d.idFinalista is  null;



-- Requisitos Finalizacion Sugeridos cumplidos -
select rs.defFinalizaactiv,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,i.tipo from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as rs inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticosfinalisug as i  on  rs.idCategoria= 1 and i.idFinalista= 1 and rs.idContratante= 2 and rs.defFinalizaactiv=i.idRequisito where i.idFinalista is not  null;

-- Requisitos Finalizacion Sugeridos No  cumplidos -
select * from (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades as rs inner join sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades as r on rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades and rs.idCategoria= 1 and rs.idContratante= 2) left join sys.documentosestaticosfinalisug as i  on  rs.idCategoria= 1 and i.idFinalista= 1 and rs.idContratante= 2 and rs.defFinalizaactiv=i.idRequisito where i.idFinalista is  null;



-- Requisitos Finalizacion Extras cumplidos --
select re.idejecuionextrassestaticosdeffinalizaciondeactivdades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticosfinaliext as d  on re.idCategoria=1 and d.idFinalista=1 and re.idContratante= 2 and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
where d.idFinalista is not  null;


-- Requisitos Finalizacion Extras No cumplidos --
select * from (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades as re inner join sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades as r on re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades and re.idCategoria=1 and re.idContratante=2) left join sys.documentosestaticosfinaliext as d  on re.idCategoria=1 and d.idFinalista=1 and re.idContratante= 2 and re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
where d.idFinalista is null;

-- --------------------------------------------------------------------------------------------------------

-- llenar requisitos previos sugeridos Dinamicos --
select t1.id,t1.requisito from (sys.requidinapresug as t1 ) left join sys.requidinadefpresug as t2 on t1.id=t2.idRequisito and t2.idContratante= 2
where t2.id is null and t1.idCategoria= 1;

-- llenar requisitos ejecucion sugeridos Dinamicos--
select t1.id,t1.requisito from (sys.requidinaejecsug as t1 ) left join sys.requidinadefejecsug as t2 on t1.id=t2.idRequisito and t2.idContratante= 2
where t2.id is null and t1.idCategoria= 1;

-- llenar requisitos finalizacion Dinamicos --
select t1.id,t1.requisito from (sys.requidinafinalsug as t1 ) left join sys.requidinadeffinalsug as t2 on t1.id=t2.idRequisito and t2.idContratante= 2
where t2.id is null and t1.idCategoria= 1;


-- llenar requisitos previos Dinamicos extras 
select t1.id,t1.requisito from (sys.requidinapreex as t1) left join sys.requidinadefpreext as t2 on t1.id=t2.idRequisito and t2.idContratante= 1
where t2.id is null and t1.idCategoria= 1;
-- llenar requisitos ejecución Dinamicos extras 
select t1.id,t1.requisito from (sys.requidinaejecext as t1) left join sys.requidinadefejecext as t2 on t1.id=t2.idRequisito and t2.idContratante= 1
where t2.id is null and t1.idCategoria= 1;

-- llenar requisitos finalizacion Dinamicos extras 
select t1.id,t1.requisito from (sys.requidinafinalext as t1) left join sys.requidinadeffinalext as t2 on t1.id=t2.idRequisito and t2.idContratante= 1
where t2.id is null and t1.idCategoria= 1;




-- Definitivos Dinamicos Previos Sugeridos --
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.requidinadefpresug as ro inner join sys.requidinapresug as r where ro.idRequisito=r.id and ro.idContratante= 1 and ro.idCategoria= 1 ;


-- Definitivos Dinamicos Ejecucion Sugeridos --
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.requidinadefejecsug as ro inner join sys.requidinaejecsug as r where ro.idRequisito=r.id and ro.idContratante= 1 and ro.idCategoria= 1 ;


-- Definitivos Dinamicos Finalizacion Sugeridos --
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito from sys.requidinadeffinalsug as ro inner join sys.requidinafinalsug as r where ro.idRequisito=r.id and ro.idContratante= 1 and ro.idCategoria= 1 ;

-- Definitivos Dinamicos Previos Extras
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from sys.requidinadefpreext as ro inner join sys.requidinapreex as r where ro.idRequisito=r.id  and ro.idContratante= 1 and ro.idCategoria= 1;


--  Definitivos Dinamicos Ejecucion Extras
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from sys.requidinadefejecext as ro inner join sys.requidinaejecext as r where ro.idRequisito=r.id  and ro.idContratante= 1 and ro.idCategoria= 1;

--  Definitivos Dinamicos Finalizacion Extras
select ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  from sys.requidinadeffinalext as ro inner join sys.requidinafinalext as r where ro.idRequisito=r.id  and ro.idContratante= 1 and ro.idCategoria= 1;


SELECT * from sys.finalista inner join sys.contratista where finalista.idContratista=contratista.idContratista;


-- Estado Previos sugeridos --
select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadefpresug as rdps inner join sys.requidinapresug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 ;


-- Estado Ejecucion sugeridos --
select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadefejecsug as rdps inner join sys.requidinaejecsug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 ;

-- Estado Finalizacion sugeridos --
select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadeffinalsug as rdps inner join sys.requidinafinalsug as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 ;



select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadefpreext as rdps inner join sys.requidinapreex as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 ;


select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadefejecext as rdps inner join sys.requidinaejecext as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 ;


select rdps.id,rps.requisito,rdps.idCategoria from sys.finalista as f  inner join sys.contratista as c inner join sys.usuarios as u inner join sys.requidinadeffinalext as rdps inner join sys.requidinafinalext as rps  where  f.idContratista=c.idContratista and c.idContratista=u.idContratista and u.idCategoria=rdps.idCategoria and rdps.idRequisito=rps.id and u.idCategoria=1 and f.idFinalista=3 and c.idContratante=2 ;