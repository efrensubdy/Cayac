
-- select all--


SELECT * FROM planDeTrabajo;
SELECT * FROM planDeTrabajo WHERE idContratista =2 AND mes ="ENERO";
SELECT * FROM documentosestaticospreviosobli;
SELECT * FROM servicioacontratar;	
SELECT * FROM administrador;
SELECT * FROM arl;
SELECT * FROM servicioacontratar;
SELECT * FROM activdadeconomica;
SELECT * FROM certificaciones;
SELECT * FROM departamento; 
SELECT * FROM contratista;
SELECT * FROM contratante;
SELECT * FROM contrato;
DELETE FROM contrato WHERE idContrato = 25;
SELECT * FROM usuarios;
SELECT * FROM categoria;
SELECT * FROM requisitos;
SELECT *  FROM extras;
SELECT * FROM requisitosobligatoriosExtras;
SELECT *  FROM requisitosobligatoriossugeridos;
SELECT * FROM fechalimite;
DELETE FROM fechalimite WHERE idContratante=1;
SELECT *  FROM imagenes;
SELECT *  FROM documentos;
SELECT * FROM finalista;
SELECT *  FROM ejecuionextrassestaticosdeffinalizaciondeactivdades;
SELECT *  FROM ejecuionsugeridosestaticosdeffinalizaciondeactivdades;
SELECT *  FROM requisitosdeejecuionextrasdefestaticosejecucionactividades;
SELECT *  FROM requisitosdeejecuiondefsugeridosestaticosejecucionactividades;
SELECT *  FROM requisitosdeejecuiondefextrasestaticosprevio;
SELECT *  FROM requisitosdeejecuiondefsugeridosestaticosprevio;
SELECT *  FROM requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades;
SELECT *  FROM requisitosdeejecuionsugeridosestaticosejecucionactividades;
SELECT *  FROM requisitosdeejecuionsugeridosestaticosprevio;
SELECT *  FROM documentosestaticospreviosobli;
SELECT * FROM finalista;
 

SELECT *  FROM finalista INNER JOIN contratista WHERE finalista.idContratista=contratista.idContratista;

SELECT * FROM requidinadeffinalsug AS re INNER JOIN requidinafinalsug AS r  WHERE re.idRequisito=r.id ;

SELECT t1.id,t1.requisito FROM (requidinapreex AS t1) LEFT JOIN requidinadefpreext AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 1
WHERE t2.id IS NULL AND t1.idCategoria=1


SELECT  * FROM requidinapreex;

SELECT  * FROM sys.actprevsuger;
SELECT  * FROM sys.actprevext;
SELECT * FROM sys.actejecsug;
SELECT * FROM sys.actejecext;
SELECT * FROM sys.actfinsug;
SELECT * FROM finalista
UPDATE  contrato SET idFinalista = ? 
UPDATE  contrato SET idFinalista = NULL WHERE idContrato =27 
DELETE FROM contrato WHERE idContrato=21;
-- llenar requisitos previos sugeridos --
SELECT t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio,t1.requisito FROM (sys.requisitosdeejecuionsugeridosestaticosprevio AS t1 ) LEFT JOIN sys.requisitosdeejecuiondefsugeridosestaticosprevio AS t2 ON t1.idRequisitosDeEjecuionSugeridosEstaticosPrevio=t2.idRequsito AND t2.idContratante= 1
WHERE t2.idrequisitosdeejecuiondefsugeridosestaticosprevio IS NULL AND t1.idCategoria= 1;

-- llenar requisitos ejecucion sugeridos--
SELECT t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades, t1.requisito FROM (sys.requisitosdeejecuionsugeridosestaticosejecucionactividades AS t1 ) LEFT JOIN sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades AS t2 ON t1.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades=t2.idRequisito AND t2.idContratante= 1
WHERE t2.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades IS NULL AND t1.idCategoria= 1;

-- llenar requisitos finalizacion --
SELECT t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades, t1.requisito FROM (sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades AS t1 ) LEFT JOIN sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades AS t2 ON t1.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades=t2.idRequisito AND t2.idContratante= 1
WHERE t2.defFinalizaactiv IS NULL AND t1.idCategoria= 1;


INSERT INTO usuarios VALUES (4,NULL,3,1,"activo","Contratista",NULL);
-- llenar requisitos previos extras 
SELECT t1.idRequisitosDeEjecuionSugeridosextrasPrevio,t1.requisito FROM (sys.requisitosdeejecuionextrasestaticosprevio AS t1) LEFT JOIN sys.requisitosdeejecuiondefextrasestaticosprevio AS t2 ON t1.idRequisitosDeEjecuionSugeridosextrasPrevio=t2.idRequisito AND t2.idContratante= 1
WHERE t2.idrequisitosdeejecuiondefextrasestaticosprevio IS NULL AND t1.idCategoria= 1;

-- llenar requisitos ejecucion extras
SELECT t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades,t1.requisito FROM (sys.requisitosdeejecuionextrasestaticosejecucionactividades AS t1) LEFT JOIN sys.requisitosdeejecuionextrasdefestaticosejecucionactividades AS t2 ON t1.idrequisitosdeejecuionextrasestaticosEjecucionActividades=t2.idRequisito AND t2.idContratante= 2
WHERE t2.idrequisitosdeejecuionextrasestaticosejecucionactividades IS NULL AND t1.idCategoria= 2;

-- llenar requisitos finalizacion extras
SELECT t1.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades FROM (sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades AS t1) LEFT JOIN sys.ejecuionextrassestaticosdeffinalizaciondeactivdades AS t2 ON t1.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades=t2.idRequisito AND t2.idContratante= 2
WHERE t2.idejecuionextrassestaticosdeffinalizaciondeactivdades IS NULL AND t1.idCategoria= 2;

SELECT * FROM requisitosdeejecuionextrasestaticosejecucionactividades;
SELECT * FROM requisitosdeejecuionextrasdefestaticosejecucionactividades;

SELECT contrato.idContrato,contrato.nombreContrato,contrato.fechaInicio,contrato.idContratante,contrato.tipoContrato FROM contrato LEFT JOIN finalista ON finalista.idContrato=contrato.idContrato WHERE finalista.idContrato IS  NULL;

-- Traer Requisitos Previos Sugeridos Definitivos --
SELECT ro.idrequisitosdeejecuiondefsugeridosestaticosprevio,ro.idContratante,r.idCategoria, ro.idRequsito,r.requisito FROM sys.requisitosdeejecuiondefsugeridosestaticosprevio AS ro INNER JOIN sys.requisitosdeejecuionsugeridosestaticosprevio AS r WHERE ro.idRequsito=r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND ro.idContratante= 2 AND ro.idCategoria= 1 ;

-- Traer Requisitos Ejecucion Sugeridos Definitivos --
SELECT ro.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito FROM sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades AS ro INNER JOIN sys.requisitosdeejecuionsugeridosestaticosejecucionactividades AS r WHERE ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades AND ro.idContratante= 2 AND ro.idCategoria= 1 ;

-- Traer Requisitos Finalizacion Sugeridos Definitivos --
SELECT ro.defFinalizaactiv,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito FROM sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades AS ro INNER JOIN sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades AS r WHERE ro.idRequisito=r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades AND ro.idContratante= 2 AND ro.idCategoria= 1 ;


-- Traer Requisitos Previos Extras Definitivos --
SELECT ro.idrequisitosdeejecuiondefextrasestaticosprevio, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito FROM sys.requisitosdeejecuiondefextrasestaticosprevio AS ro INNER JOIN sys.requisitosdeejecuionextrasestaticosprevio AS r WHERE ro.idRequisito=r.idRequisitosDeEjecuionSugeridosextrasPrevio AND ro.idContratante= 2 AND ro.idCategoria= 1;

-- Traer Requisitos Ejecucion Extras Definitivos --
SELECT ro.idrequisitosdeejecuionextrasestaticosejecucionactividades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito FROM sys.requisitosdeejecuionextrasdefestaticosejecucionactividades AS ro INNER JOIN sys.requisitosdeejecuionextrasestaticosejecucionactividades AS r WHERE ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosEjecucionActividades AND ro.idContratante= 2 AND ro.idCategoria= 1;

-- Traer Requisitos Finalizacion Extras Definitivos --
SELECT ro.idejecuionextrassestaticosdeffinalizaciondeactivdades, ro.idContratante,ro.idCategoria, ro.idRequisito,r.requisito FROM sys.ejecuionextrassestaticosdeffinalizaciondeactivdades AS ro INNER JOIN sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades AS r WHERE ro.idRequisito=r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades AND ro.idContratante= 2 AND ro.idCategoria= 1;


-- Estado Requisito Previos Sugeridos --
SELECT DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosprevio,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,r.requisito,d.estado  FROM (sys.requisitosdeejecuiondefsugeridosestaticosprevio AS re INNER JOIN sys.requisitosdeejecuionsugeridosestaticosprevio AS r ON  re.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticospreviosobli AS d  ON re.idCategoria= 1 AND re.idrequisitosdeejecuiondefsugeridosestaticosprevio=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;


-- Estado Requisito Previos Extras

SELECT DISTINCT  re.idrequisitosdeejecuiondefextrasestaticosprevio,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.estado FROM (sys.requisitosdeejecuiondefextrasestaticosprevio AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosprevio AS r ON  re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticospreviosextras AS d  ON re.idCategoria= 1 AND re.idRequisito=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;

-- Estado Requisitos Ejecucion Sugeridos
SELECT DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,r.requisito,d.estado FROM (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades AS re INNER JOIN sys.requisitosdeejecuionsugeridosestaticosejecucionactividades AS r ON  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticosejecsug AS d  ON re.idCategoria= 1 AND re.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;

-- Estado Requisitos Ejecucion Extras
SELECT DISTINCT  re.idrequisitosdeejecuionextrasestaticosejecucionactividades,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito,d.estado FROM (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosejecucionactividades AS r ON  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticosejecext AS d  ON re.idCategoria= 1 AND re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;

-- Estado Requisitos Finalización Sugeridos
SELECT DISTINCT  re.defFinalizaactiv,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,r.requisito,d.estado FROM (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades AS re INNER JOIN sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades AS r ON  re.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticosfinalisug AS d  ON re.idCategoria= 1 AND re.defFinalizaactiv=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;

-- Estado Requisitos Finalizacion Extras
SELECT DISTINCT  re.idejecuionextrassestaticosdeffinalizaciondeactivdades,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito,d.estado FROM (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades AS r ON  re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticosfinaliext AS d  ON re.idCategoria= 1 AND re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
WHERE d.idFinalista IS  NULL OR d.idFinalista IS NOT NULL;


-- *

SELECT DISTINCT  re.idrequisitosdeejecuiondefsugeridosestaticosprevio,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,r.requisito,d.estado  FROM (sys.requisitosdeejecuiondefsugeridosestaticosprevio AS re INNER JOIN sys.requisitosdeejecuionsugeridosestaticosprevio AS r ON  re.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND re.idCategoria= 1 AND re.idContratante= 2) LEFT JOIN sys.documentosestaticospreviosobli AS d  ON re.idCategoria= 1 AND re.idrequisitosdeejecuiondefsugeridosestaticosprevio=d.idRequisito
WHERE d.idFinalista IS NOT NULL;

 -- def.idContratante,re.idCategoria,re.requisito,re.apodo, d.idRequisito, d.idFinalista
SELECT DISTINCT *   FROM (requidinadefpresug AS def INNER JOIN requidinapresug AS re ON def.idRequisito=re.id AND re.idCategoria = 1 AND def.idContratante=2)LEFT JOIN documentosDinamicosPrevios AS d ON def.idCategoria=1 AND d.idFinalista=3  AND def.id=d.idRequisito
WHERE d.idFinalista IS  NULL 
GROUP BY d.idRequisito; 

SELECT DISTINCT *   FROM (requidinadefpresug AS def INNER JOIN requidinapresug AS re ON def.idRequisito=re.id AND re.idCategoria = 1 AND def.idContratante=2)LEFT JOIN documentosDinamicosPrevios AS d ON def.idCategoria=1 AND d.idFinalista=3  AND def.id=d.idRequisito
WHERE d.idFinalista IS  NULL AND re.apodo != "MATRIZ DE PELIGROS"
GROUP BY d.idRequisito; 
SELECT * FROM finalista;
SELECT * FROM contratista;
SELECT * FROM  documentosDinamicosPrevios

DELETE FROM documentosDinamicosPrevios WHERE id =1 OR id=2;



DELETE 

SELECT rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo FROM (requisitosdeejecuiondefsugeridosestaticosprevio AS rs INNER JOIN requisitosdeejecuionsugeridosestaticosprevio AS r ON rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND rs.idCategoria= ? AND rs.idContratante= ?) LEFT JOIN documentosestaticospreviosobli AS i  ON  rs.idCategoria= ? AND i.idFinalista= ? AND rs.idContratante= ? AND rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito WHERE i.idFinalista IS   NULL;

SELECT * FROM requidinadefpresug AS def INNER JOIN requidinapresug AS re ON def.idRequisito=re.id AND re.idCategoria = 1; 


-- Requisitos Previos sugeridos cumplidos --

SELECT rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo FROM (sys.requisitosdeejecuiondefsugeridosestaticosprevio AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosprevio AS r ON rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticospreviosobli AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 1 AND rs.idContratante= 2 AND rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito WHERE i.idFinalista IS NOT  NULL;

-- Requisitos Previos sugeridos No cumplidos --
SELECT rs.idrequisitosdeejecuiondefsugeridosestaticosprevio,i.idFinalista,r.requisito,r.idRequisitosDeEjecuionSugeridosEstaticosPrevio,i.tipo FROM (sys.requisitosdeejecuiondefsugeridosestaticosprevio AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosprevio AS r ON rs.idRequsito =r.idRequisitosDeEjecuionSugeridosEstaticosPrevio AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticospreviosobli AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 3 AND rs.idContratante= 2 AND rs.idrequisitosdeejecuiondefsugeridosestaticosprevio=i.idRequisito WHERE i.idFinalista IS   NULL;


SELECT * FROM finalista;
-- Requisitos Previos Extras cumplidos --
SELECT re.idrequisitosdeejecuiondefextrasestaticosprevio,d.idFinalista,r.idRequisitosDeEjecuionSugeridosextrasPrevio,r.requisito,d.tipo FROM (sys.requisitosdeejecuiondefextrasestaticosprevio AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosprevio AS r ON re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticospreviosextras AS d  ON re.idCategoria=1 AND d.idFinalista=1 AND re.idContratante= 2 AND re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito
WHERE d.idFinalista IS NOT  NULL;


-- Requisitos Previos Extras No cumplidos --
SELECT * FROM (sys.requisitosdeejecuiondefextrasestaticosprevio AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosprevio AS r ON re.idRequisito =r.idRequisitosDeEjecuionSugeridosextrasPrevio AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticospreviosextras AS d  ON re.idCategoria=1 AND d.idFinalista=1 AND re.idContratante= 2 AND re.idrequisitosdeejecuiondefextrasestaticosprevio=d.idRequisito
WHERE d.idFinalista IS  NULL;


-- Requisitos Ejecucion sugeridos cumplidos -
SELECT rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades,i.tipo FROM (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosejecucionactividades AS r ON rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticosejecsug AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 1 AND rs.idContratante= 2 AND rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito WHERE i.idFinalista IS NOT  NULL;

-- Requisitos Ejecucion sugeridos No cumplidos -
SELECT * FROM (sys.requisitosdeejecuiondefsugeridosestaticosejecucionactividades AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosejecucionactividades AS r ON rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosEjecucionActividades AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticosejecsug AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 1 AND rs.idContratante= 2 AND rs.idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades=i.idRequisito WHERE i.idFinalista IS  NULL;


-- Requisitos Ejecucion Extras cumplidos -
SELECT re.idrequisitosdeejecuionextrasestaticosejecucionactividades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosEjecucionActividades,r.requisito FROM (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosejecucionactividades AS r ON re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticosejecext AS d  ON re.idCategoria=1 AND d.idFinalista=1 AND re.idContratante= 2 AND re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
WHERE d.idFinalista IS NOT  NULL;

-- Requisitos Ejecucion Extras No cumplidos -
SELECT * FROM (sys.requisitosdeejecuionextrasdefestaticosejecucionactividades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosejecucionactividades AS r ON re.idRequisito =r.idrequisitosdeejecuionextrasestaticosEjecucionActividades AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticosejecext AS d  ON re.idCategoria=1 AND d.idFinalista=2 AND re.idContratante= 2 AND re.idrequisitosdeejecuionextrasestaticosejecucionactividades=d.idRequisito
WHERE d.idFinalista IS  NULL;



-- Requisitos Finalizacion Sugeridos cumplidos -
SELECT rs.defFinalizaactiv,i.idFinalista,r.requisito,r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades,i.tipo FROM (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades AS r ON rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticosfinalisug AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 1 AND rs.idContratante= 2 AND rs.defFinalizaactiv=i.idRequisito WHERE i.idFinalista IS NOT  NULL;

-- Requisitos Finalizacion Sugeridos No  cumplidos -
SELECT * FROM (sys.ejecuionsugeridosestaticosdeffinalizaciondeactivdades AS rs INNER JOIN sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades AS r ON rs.idRequisito =r.idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades AND rs.idCategoria= 1 AND rs.idContratante= 2) LEFT JOIN sys.documentosestaticosfinalisug AS i  ON  rs.idCategoria= 1 AND i.idFinalista= 1 AND rs.idContratante= 2 AND rs.defFinalizaactiv=i.idRequisito WHERE i.idFinalista IS  NULL;



-- Requisitos Finalizacion Extras cumplidos --
SELECT re.idejecuionextrassestaticosdeffinalizaciondeactivdades,d.idFinalista,r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades,r.requisito FROM (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades AS r ON re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticosfinaliext AS d  ON re.idCategoria=1 AND d.idFinalista=1 AND re.idContratante= 2 AND re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
WHERE d.idFinalista IS NOT  NULL;


-- Requisitos Finalizacion Extras No cumplidos --
SELECT * FROM (sys.ejecuionextrassestaticosdeffinalizaciondeactivdades AS re INNER JOIN sys.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades AS r ON re.idRequisito =r.idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades AND re.idCategoria=1 AND re.idContratante=2) LEFT JOIN sys.documentosestaticosfinaliext AS d  ON re.idCategoria=1 AND d.idFinalista=1 AND re.idContratante= 2 AND re.idejecuionextrassestaticosdeffinalizaciondeactivdades=d.idRequisito
WHERE d.idFinalista IS NULL;

-- --------------------------------------------------------------------------------------------------------

-- llenar requisitos previos sugeridos Dinamicos --
SELECT t1.id,t1.requisito FROM (sys.requidinapresug AS t1 ) LEFT JOIN sys.requidinadefpresug AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 2
WHERE t2.id IS NULL AND t1.idCategoria= 1;

-- llenar requisitos ejecucion sugeridos Dinamicos--
SELECT t1.id,t1.requisito FROM (sys.requidinaejecsug AS t1 ) LEFT JOIN sys.requidinadefejecsug AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 2
WHERE t2.id IS NULL AND t1.idCategoria= 1;

-- llenar requisitos finalizacion Dinamicos --
SELECT t1.id,t1.requisito FROM (sys.requidinafinalsug AS t1 ) LEFT JOIN sys.requidinadeffinalsug AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 2
WHERE t2.id IS NULL AND t1.idCategoria= 1;


-- llenar requisitos previos Dinamicos extras 
SELECT t1.id,t1.requisito FROM (sys.requidinapreex AS t1) LEFT JOIN sys.requidinadefpreext AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 1
WHERE t2.id IS NULL AND t1.idCategoria= 1;
-- llenar requisitos ejecución Dinamicos extras 
SELECT t1.id,t1.requisito FROM (sys.requidinaejecext AS t1) LEFT JOIN sys.requidinadefejecext AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 1
WHERE t2.id IS NULL AND t1.idCategoria= 1;

-- llenar requisitos finalizacion Dinamicos extras 
SELECT t1.id,t1.requisito FROM (sys.requidinafinalext AS t1) LEFT JOIN sys.requidinadeffinalext AS t2 ON t1.id=t2.idRequisito AND t2.idContratante= 1
WHERE t2.id IS NULL AND t1.idCategoria= 1;




-- Definitivos Dinamicos Previos Sugeridos --
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito FROM sys.requidinadefpresug AS ro INNER JOIN sys.requidinapresug AS r WHERE ro.idRequisito=r.id AND ro.idContratante= 1 AND ro.idCategoria= 1 ;


-- Definitivos Dinamicos Ejecucion Sugeridos --
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito FROM sys.requidinadefejecsug AS ro INNER JOIN sys.requidinaejecsug AS r WHERE ro.idRequisito=r.id AND ro.idContratante= 1 AND ro.idCategoria= 1 ;


-- Definitivos Dinamicos Finalizacion Sugeridos --
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito FROM sys.requidinadeffinalsug AS ro INNER JOIN sys.requidinafinalsug AS r WHERE ro.idRequisito=r.id AND ro.idContratante= 1 AND ro.idCategoria= 1 ;

-- Definitivos Dinamicos Previos Extras
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  FROM sys.requidinadefpreext AS ro INNER JOIN sys.requidinapreex AS r WHERE ro.idRequisito=r.id  AND ro.idContratante= 1 AND ro.idCategoria= 1;


--  Definitivos Dinamicos Ejecucion Extras
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  FROM sys.requidinadefejecext AS ro INNER JOIN sys.requidinaejecext AS r WHERE ro.idRequisito=r.id  AND ro.idContratante= 1 AND ro.idCategoria= 1;

--  Definitivos Dinamicos Finalizacion Extras
SELECT ro.id,ro.idContratante,r.idCategoria, ro.idRequisito,r.requisito  FROM sys.requidinadeffinalext AS ro INNER JOIN sys.requidinafinalext AS r WHERE ro.idRequisito=r.id  AND ro.idContratante= 1 AND ro.idCategoria= 1;


SELECT * FROM sys.finalista INNER JOIN sys.contratista WHERE finalista.idContratista=contratista.idContratista;


-- Estado Previos sugeridos --
SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadefpresug AS rdps INNER JOIN sys.requidinapresug AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 ;


-- Estado Ejecucion sugeridos --
SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadefejecsug AS rdps INNER JOIN sys.requidinaejecsug AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 ;

-- Estado Finalizacion sugeridos --
SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadeffinalsug AS rdps INNER JOIN sys.requidinafinalsug AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 ;



SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadefpreext AS rdps INNER JOIN sys.requidinapreex AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 ;


SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadefejecext AS rdps INNER JOIN sys.requidinaejecext AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 ;


SELECT rdps.id,rps.requisito,rdps.idCategoria FROM sys.finalista AS f  INNER JOIN sys.contratista AS c INNER JOIN sys.usuarios AS u INNER JOIN sys.requidinadeffinalext AS rdps INNER JOIN sys.requidinafinalext AS rps  WHERE  f.idContratista=c.idContratista AND c.idContratista=u.idContratista AND u.idCategoria=rdps.idCategoria AND rdps.idRequisito=rps.id AND u.idCategoria=1 AND f.idFinalista=3 AND c.idContratante=2 ;






SELECT servicioacontratar.id,servicioacontratar.nombre,servicioacontratar.tipo FROM  servicioacontratar LEFT JOIN  contratista ON contratista.idservicioAContratar=servicioacontratar.id WHERE contratista.idservicioAContratar IS NOT  NULL AND servicioacontratar.idContratante = 2;