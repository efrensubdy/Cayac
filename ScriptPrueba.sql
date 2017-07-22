CREATE TABLE `arl` (
  `id` int(11) NOT NULL,
  `nameArl` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `ciudad` (
  `id_ciudad` int(11) NOT NULL,
  `nombre_ciu` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL,
  `nombreDepa` varchar(45) NOT NULL,
  `idCiu` int(11) NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  KEY `fk_departamento_ciudad_idx` (`idCiu`),
  CONSTRAINT `fk_departamento_ciudad` FOREIGN KEY (`idCiu`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activdadeconomica` (
  `codigoCIIU` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `nivelDeRiesgo` int(11) NOT NULL,
  PRIMARY KEY (`codigoCIIU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contratante` (
  `idContratante` int(11) NOT NULL,
  `nombreEmpresa` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `departamento` int(11) NOT NULL,
  `fecha_Creacion` date NOT NULL,
  `fecha_Actualizacion` date NOT NULL,
  `codigoCIIU` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `representanteLegal` varchar(45) NOT NULL,
  PRIMARY KEY (`idContratante`),
  KEY `contra_AcTI_idx` (`codigoCIIU`),
  CONSTRAINT `contra_AcTI` FOREIGN KEY (`codigoCIIU`) REFERENCES `activdadeconomica` (`codigoCIIU`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contrato` (
  `idContrato` int(11) NOT NULL AUTO_INCREMENT,
  `nombreContrato` varchar(45) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `idContratante` int(11) NOT NULL,
  `tipoContrato` varchar(45) NOT NULL,
  PRIMARY KEY (`idContrato`),
  KEY `Contrato_Contratante_idx` (`idContratante`),
  CONSTRAINT `Contrato_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contratista` (
  `idContratista` int(11) NOT NULL,
  `nombreEmpresa` varchar(45) NOT NULL,
  `nit` varchar(45) NOT NULL,
  `codigoCIIU` int(11) NOT NULL,
  `nombreGerente` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `arl` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `duracion` varchar(45) NOT NULL,
  `departamento` int(11) NOT NULL,
  `fecha_Creacion` date NOT NULL,
  `fecha_modificacion` date NOT NULL,
  `password` varchar(45) NOT NULL,
  `idContratante` int(11) NOT NULL,
  `personaContacto` varchar(45) NOT NULL,
  `cargoPer` varchar(45) NOT NULL,
  `telefonoCon` varchar(45) NOT NULL,
  `emailContacto` varchar(45) NOT NULL,
  `idContrato` int(11) NOT NULL,
  PRIMARY KEY (`idContratista`),
  KEY `fk_Contratista_Departamento_idx` (`departamento`),
  KEY `fk_Contratista_Arl_idx` (`arl`),
  KEY `fk_Contratista_Actividad_idx` (`codigoCIIU`),
  KEY `FK_Contratista_Contratante_idx` (`idContratante`),
  KEY `fk_Contratista_Contrato_idx` (`idContrato`),
  CONSTRAINT `fk_Contratista_Actividad` FOREIGN KEY (`codigoCIIU`) REFERENCES `activdadeconomica` (`codigoCIIU`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratista_Arl` FOREIGN KEY (`arl`) REFERENCES `arl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contratista_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratista_Contrato` FOREIGN KEY (`idContrato`) REFERENCES `contrato` (`idContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contratista_Departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `Categoriatipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `usuarios` (
  `idUsuarios` int(11) NOT NULL,
  `idContratante` int(11) DEFAULT NULL,
  `idContratista` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`),
  KEY `fk_usuario_Contratante_idx` (`idContratante`),
  KEY `fk_usuario_Contratista_idx` (`idContratista`),
  KEY `fk_usuario_Categoria_idx` (`idCategoria`),
  CONSTRAINT `fk_usuario_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `requisitos` (
  `idrequisitos` int(11) NOT NULL,
  `requisisto` varchar(500) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idrequisitos`),
  KEY `fk_requisito_categoria_idx` (`idCategoria`),
  CONSTRAINT `fk_requisito_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `extras` (
  `idExtras` int(11) NOT NULL,
  `Extrascol` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idExtras`),
  KEY `Extra_Categorioa_idx` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `requisitosobligatoriossugeridos` (
  `idRequisitosObligatorios` int(11) NOT NULL auto_increment,
  `idContratante` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idRequisito` int(11) NOT NULL,
  PRIMARY KEY (`idRequisitosObligatorios`),
  KEY `RequisitoObligatori_Categorial_idx` (`idCategoria`),
  KEY `RequisitoObligatorio_Requisito_idx` (`idRequisito`),
  KEY `RequisitoObligatorio_Contratante_idx` (`idContratante`),
  CONSTRAINT `RequisitoObligatori_Categorial` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoObligatorio_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoObligatorio_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requisitos` (`idrequisitos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosobligatoriosextras` (
  `idRequisitosObligatoriosExtras` int(11) NOT NULL auto_increment,
  `idContratante` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idRequisito` int(11) NOT NULL,
  PRIMARY KEY (`idRequisitosObligatoriosExtras`),
  KEY `RequisitoExtra_Categoria_idx` (`idCategoria`),
  KEY `RequisitoExtra_Extra_idx` (`idRequisito`),
  KEY `RequsitoExtra_Contratante_idx` (`idContratante`),
  CONSTRAINT `RequisitoExtra_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoExtra_Extra` FOREIGN KEY (`idRequisito`) REFERENCES `extras` (`idExtras`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequsitoExtra_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `fechalimite` (
  `idfechalimite` int(11) NOT NULL,
  `fechaLimite` date NOT NULL,
  `idContratante` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idfechalimite`),
  KEY `FechaLimite_Categoria_idx` (`idCategoria`),
  KEY `FechaLimite_Contratante_idx` (`idContratante`),
  CONSTRAINT `FechaLimite_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FechaLimite_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `imagenes` (
  `idImagenes` int(11) NOT NULL,
  `idRequisitoSugerido` int(11) NOT NULL,
  `contenido` varchar(145) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `fechaActualizacion` date NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `idContratista` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idImagenes`,`idRequisitoSugerido`),
  KEY `contenido_requisito_idx` (`idRequisitoSugerido`),
  KEY `Imagen_contratista_idx` (`idContratista`),
  CONSTRAINT `Imagen_contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contenido_requisito` FOREIGN KEY (`idRequisitoSugerido`) REFERENCES `requisitosobligatoriossugeridos` (`idRequisitosObligatorios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `documentos` (
  `idDocumentos` int(11) NOT NULL,
  `idRequisitoSugerido` int(11) NOT NULL,
  `contenido` varchar(145) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `fechaActualizacion` date NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `idContratista` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idDocumentos`,`idRequisitoSugerido`),
  KEY `documento_requisito_idx` (`idRequisitoSugerido`),
  KEY `doc_idContratista_idx` (`idContratista`),
  CONSTRAINT `doc_idContratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `documento_requisito` FOREIGN KEY (`idRequisitoSugerido`) REFERENCES `requisitosobligatoriosextras` (`idRequisitosObligatoriosExtras`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `finalista` (
  `idFinalista` int(11) NOT NULL auto_increment,
  `idContratista` int(11) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `fechaModificacion` date NOT NULL,
  `estado` varchar(45) not null,
  PRIMARY KEY (`idFinalista`,`idContratista`,`fechaCreacion`),
  KEY `Finalista_Contratista_idx` (`idContratista`),
  CONSTRAINT `Finalista_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionsugeridosestaticosprevio` (
  `idRequisitosDeEjecuionSugeridosEstaticosPrevio` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idRequisitosDeEjecuionSugeridosEstaticosPrevio`),
  KEY `RESEP_CATEGORIA_idx` (`idCategoria`),
  CONSTRAINT `RESEP_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosprevio` (
  `idRequisitosDeEjecuionSugeridosextrasPrevio` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idRequisitosDeEjecuionSugeridosextrasPrevio`),
  KEY `REEEP_CATEGORIA_idx` (`idCategoria`),
  CONSTRAINT `REEEP_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `requisitosdeejecuionsugeridosestaticosejecucionactividades` (
  `idrequisitosdeejecuionsugeridosestaticosEjecucionActividades` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionsugeridosestaticosEjecucionActividades`),
  KEY `ecucionEstatica_Categoria_idx` (`idCategoria`),
  CONSTRAINT `ecucionEstatica_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosejecucionactividades` (
  `idrequisitosdeejecuionextrasestaticosEjecucionActividades` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionextrasestaticosEjecucionActividades`),
  KEY `ecucionEstaticaExtra_Categoria_idx` (`idCategoria`),
  CONSTRAINT `ecucionEstaticaExtra_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades` (
  `idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades`),
  KEY `FinalizacionActEstatica_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `FinalizacionActEstatica_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosfinalizaciondeactivdades` (
  `idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades` int(11) NOT NULL AUTO_INCREMENT,
  `requisito` varchar(45) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades`),
  KEY `FinalizacionActEstaticaExtra_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `FinalizacionActEstaticaExtra_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





INSERT INTO ARL VALUES (1,"Sura"); 
INSERT INTO ARL VALUES (2,"Bolivar");
INSERT INTO ARL VALUES (3,"Equidad");
INSERT INTO ARL VALUES(4,"Aurora");
INSERT INTO ARL VALUES (5,"Colpatria");
INSERT INTO ARL VALUES (6,"Positiva");
INSERT INTO ARL VALUES (7,"Liberty");
INSERT INTO ARL VALUES (8,"Mapfre");
INSERT INTO ARL VALUES (9,"Bolivar");
INSERT INTO ARL VALUES (10,"Alfa");




insert into ciudad values (1, "Bogotá");
insert into ciudad values(2,"Rioacha");
insert into ciudad values(3,"Santa Marta");
insert into ciudad values(4,"San Jose del Guaviare");
insert into ciudad values (5,"Tunja");
insert into ciudad values(6,"Cali");
insert into ciudad values(7,"Leticia");
insert into ciudad values (8,"Villavicencio");
insert into ciudad values (9,"Medellín");
insert into ciudad values(10,"Cartagena");
insert into ciudad values(11,"Cauca");
insert into ciudad values (12,"Manizales");
insert into ciudad values (13,"Florencia");
insert into ciudad values (14,"Yopal");
insert into ciudad values (15,"Valledupar");

insert into ciudad values (16,"Quibdo"); 
insert into ciudad values (17,"Monteria"); 
insert into ciudad values (18,"Inirida");
insert into ciudad values (19,"Neiva"); 
insert into ciudad values (20,"Pasto"); 
insert into ciudad values (21,"Cucuta"); 
insert into ciudad values (22,"Mocoa");
insert into ciudad values (23,"Armenia");
insert into ciudad values (24,"Pereira");
insert into ciudad values (25,"San Andrés");
insert into ciudad values (26,"Bucaramanga");
insert into ciudad values (27,"Sincelejo");
insert into ciudad values (28,"Ibague");
insert into ciudad values (29,"Mitu");
insert into ciudad values (30,"Puerto Carreño");
insert into ciudad values (31,"Cauca");

insert into Departamento values (1,"Bogotá D.C",1);
insert into departamento values(2,"La Guajira",2);
insert into departamento values(3,"Magdalena",3);
insert into departamento values(4,"Guaviare",4);
insert into departamento values(5,"Boyaca",5);
insert into departamento values(6,"Valle del Cauca",5);
insert into departamento values(7,"Amazonas",7);
insert into departamento values(8,"Meta",8);
insert into departamento values (9,"Antioquia",9);
insert into departamento values (11,"Cuaca",11);
insert into departamento values (12,"Caldas",12);
insert into departamento values (13,"Caqueta",13);
insert into departamento values (14,"Casanare",14);
insert into departamento values (15,"Cesar",15);
insert into departamento values (16,"Choco",16);
insert into departamento values (17,"Cordoba",17);
insert into departamento values (18,"Guanía",18);
insert into departamento values (19,"Huila",19);
insert into departamento values (20,"Nariño",20);
insert into departamento values (21,"Norte de Santander",21);
insert into departamento values (22,"Putumayo",22);
insert into departamento values (23,"Quindio",23);
insert into departamento values (24,"Risaralda",24);
insert into departamento values (25,"San Andrés",25);
insert into departamento values (26,"Santander",26);
insert into departamento values (27,"Sucre",27);
insert into departamento values (28,"Tolima",28);
insert into departamento values (29,"Vaupes",29);
insert into departamento values (30,"Vichada",30);
insert into departamento values (31,"Popayan",31);






INSERT INTO CATEGORIA VALUES (1,"CATEGORIA 1");
INSERT INTO CATEGORIA VALUES (2,"CATEGORIA 2");
INSERT INTO CATEGORIA VALUES (3,"CATEGORIA A");
INSERT INTO CATEGORIA VALUES (4,"CATEGORIA B");



INSERT INTO extras VALUES (1,"LAVAR ROPA",1);

INSERT INTO EXTRAS VALUES (2,"SECAR ROPA",1);

INSERT INTO EXTRAS VALUES (3,"ELEGIR HERRAMIENTA",2);

INSERT INTO EXTRAS VALUES(6,"LAVAR CEPILLO",2);

INSERT INTO EXTRAS VALUES (4,"TERMINAR MATRICES",3);

INSERT INTO EXTRAS VALUES (5,"TOMAR DECISIONES",4);


INSERT INTO REQUISITOS VALUES (1,"LAVAR JABON",1);

INSERT INTO REQUISITOS VALUES (2,"SECAR SHAMPOO",1);

INSERT INTO REQUISITOS VALUES (3,"ELEGIR HERRA",2);

INSERT INTO REQUISITOS VALUES (4,"TERMINAR SUMA",3);

INSERT INTO REQUISITOS VALUES (5,"TOMAR AGUA",4);

select * from requisitos;

select * from usuarios;

SELECT t1.idrequisitos, t1.requisisto 
FROM (sys.requisitos as t1 inner join sys.usuarios t3 on t3.idCategoria=t1.idCategoria and t1.idCategoria=3) 
LEFT JOIN sys.requisitosobligatoriosSugeridos t2 ON t2.idRequisito = t1.idrequisitos and t2.idContrato=3
WHERE t2.idRequisitosObligatorios IS NULL;









select * from contrato;


UPDATE arl set nameArl= "liberty"
        WHERE id='6';


-- 1612020-
UPDATE  sys.imagenes set fechaActualizacion = 2017-04-20 where idRequisitoSugerido = 1 and idContratista= 1;

-- 4718010-

select * from arl;
select * from activdadeconomica;
select * from certificaciones;
select * from departamento; 
select * from contratista;
select * from contratante;
select * from contrato;

select * from usuarios;
select * from categoria;
select *  from extras;
select *  from imagenes;
select *  from documentos;
select * from requisitosobligatoriosExtras;
select * from requisitos;
select *  from requisitosobligatoriossugeridos;
select * from requisitosdeejecucionobligatorios;
select * from requisitosextrasdeejecucion;
select * from requisitosextrasobligatoriosejec;


  -- /Users/HSEQ/Documents/Libro2.csv
        
 load data local infile "/Users/User/Documents/Libro2.csv" into table activdadeconomica
 fields terminated by ';'
 lines terminated by '\n';
 
  load data local infile "/Users/HSEQ/Documents/RequisitosSeleccion.csv" into table requisitos
 fields terminated by ';'
 lines terminated by '\n';       
        -- C:/Users/User/Documents/Repository
        
    

-- rs.idRequisitosObligatorios,r.requisisto,r.idrequisitos,i.estado

select distinct rs.idRequisitosObligatorios,r.requisisto,r.idrequisitos,i.estado from (sys.requisitosobligatoriossugeridos as rs inner join sys.requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= 1 and rs.idContratante=2) left join sys.imagenes as i  on rs.idCategoria= 1  and rs.idRequisitosObligatorios=i.idRequisitoSugerido
where i.idContratista is  null or i.idContratista is not null;
 
 select DISTINCT  re.idRequisitosObligatoriosExtras,r.idExtras,r.Extrascol,d.estado from (sys.requisitosobligatoriosextras as re inner join sys.extras as r on  re.idRequisito =r.idExtras and re.idCategoria=1 and re.idContratante=2) left join sys.documentos as d  on re.idCategoria=1 and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido
 where d.idContratista is  null or d.idContratista is not null;
 
 
 select rs.idRequisitosObligatorios,i.idContratista,r.requisisto,r.idrequisitos,i.tipo from (sys.requisitosobligatoriossugeridos as rs inner join sys.requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= 1 and rs.idContratante=2) left join sys.imagenes as i  on  rs.idCategoria= 1 and i.idContratista=1 and rs.idContratante=2 and rs.idRequisitosObligatorios=i.idRequisitoSugerido where i.idContratista is not  null;
 
 select rs.idRequisitosObligatorios,i.idContratista,r.requisisto,r.idrequisitos,i.tipo from (sys.requisitosobligatoriossugeridos as rs inner join sys.requisitos as r on rs.idRequisito =r.idrequisitos and rs.idCategoria= 1 and rs.idContratante=2) left join sys.imagenes as i  on  rs.idCategoria= 1 and i.idContratista=1 and rs.idContratante=2 and rs.idRequisitosObligatorios=i.idRequisitoSugerido where i.idContratista is   null;
 
 
 
 
 
select re.idRequisitosObligatoriosExtras,d.idContratista,r.idExtras,r.Extrascol,d.tipo from (sys.requisitosobligatoriosextras as re inner join sys.extras as r on re.idRequisito =r.idExtras and re.idCategoria=1 and re.idContratante=2) left join sys.documentos as d  on re.idCategoria=1 and d.idContratista=1 and re.idContratante=2 and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido
where d.idContratista is not  null; 

select re.idRequisitosObligatoriosExtras,d.idContratista,r.idExtras,r.Extrascol,d.tipo from (sys.requisitosobligatoriosextras as re inner join sys.extras as r on re.idRequisito =r.idExtras and re.idCategoria=1 and re.idContratante=2) left join sys.documentos as d  on re.idCategoria=1 and d.idContratista=1 and re.idRequisitosObligatoriosExtras=d.idRequisitoSugerido
where d.idContratista is   null ;