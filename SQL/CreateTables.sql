CREATE TABLE `arl` (
  `id` INT(11) NOT NULL,
  `nameArl` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `ciudad` (
  `id_ciudad` INT(11) NOT NULL,
  `nombre_ciu` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `departamento` (
  `idDepartamento` INT(11) NOT NULL,
  `nombreDepa` VARCHAR(45) NOT NULL,
  `idCiu` INT(11) NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  KEY `fk_departamento_ciudad_idx` (`idCiu`),
  CONSTRAINT `fk_departamento_ciudad` FOREIGN KEY (`idCiu`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `activdadeconomica` (
  `codigoCIIU` INT(11) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `nivelDeRiesgo` INT(11) NOT NULL,
  PRIMARY KEY (`codigoCIIU`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `administrador` (
  `idadministrador` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadministrador`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `contratante` (
  `idContratante` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpresa` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `departamento` INT(11) NOT NULL,
  `fecha_Creacion` DATE NOT NULL,
  `fecha_Actualizacion` DATE NOT NULL,
  `codigoCIIU` INT(11) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `representanteLegal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idContratante`),
  KEY `contra_AcTI_idx` (`codigoCIIU`),
  CONSTRAINT `contra_AcTI` FOREIGN KEY (`codigoCIIU`) REFERENCES `activdadeconomica` (`codigoCIIU`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `servicioacontratar` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(500) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Serv_Contra` (`idContratante`),
  CONSTRAINT `Serv_Contra` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `contratista` (
  `idContratista` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpresa` VARCHAR(45) NOT NULL,
  `nit` VARCHAR(45) NOT NULL,
  `codigoCIIU` INT(11) NOT NULL,
  `nombreGerente` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `arl` INT(11) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `duracion` VARCHAR(45) NOT NULL,
  `departamento` INT(11) NOT NULL,
  `fecha_Creacion` DATE NOT NULL,
  `fecha_modificacion` DATE NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `personaContacto` VARCHAR(45) NOT NULL,
  `cargoPer` VARCHAR(45) NOT NULL,
  `telefonoCon` VARCHAR(45) NOT NULL,
  `emailContacto` VARCHAR(45) NOT NULL,
  `idservicioAContratar` INT(11) DEFAULT NULL,
  PRIMARY KEY (`idContratista`),
  KEY `fk_Contratista_Departamento_idx` (`departamento`),
  KEY `fk_Contratista_Arl_idx` (`arl`),
  KEY `fk_Contratista_Actividad_idx` (`codigoCIIU`),
  KEY `FK_Contratista_Contratante_idx` (`idContratante`),
  KEY `fk_servicioAContratar` (`idservicioAContratar`),
  CONSTRAINT `fk_Contratista_Actividad` FOREIGN KEY (`codigoCIIU`) REFERENCES `activdadeconomica` (`codigoCIIU`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratista_Arl` FOREIGN KEY (`arl`) REFERENCES `arl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratista_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratista_Departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_servicioAContratar` FOREIGN KEY (`idservicioAContratar`) REFERENCES `servicioacontratar` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `finalista` (
  `idFinalista` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFinalista`),
  KEY `Finalista_Contratista_idx` (`idContratista`),
  CONSTRAINT `Finalista_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `categoria` (
  `idCategoria` INT(11) NOT NULL,
  `Categoriatipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `usuarios` (
  `idUsuarios` INT(11) NOT NULL,
  `idContratante` INT(11) DEFAULT NULL,
  `idContratista` INT(11) DEFAULT NULL,
  `idCategoria` INT(11) DEFAULT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `idAdministrador` INT(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`),
  KEY `fk_usuario_Contratante_idx` (`idContratante`),
  KEY `fk_usuario_Contratista_idx` (`idContratista`),
  KEY `fk_usuario_Categoria_idx` (`idCategoria`),
  KEY `fk_usuario_Administrador_idx` (`idAdministrador`),
  CONSTRAINT `fk_usuario_Administrador` FOREIGN KEY (`idAdministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `contrato` (
  `idContrato` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreContrato` VARCHAR(45) NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `tipoContrato` VARCHAR(45) NOT NULL,
  `rut` VARCHAR(100) NOT NULL,
  `camaraDeComercio` VARCHAR(100) NOT NULL,
  `cc` VARCHAR(100) NOT NULL,
  `fechaInicioActivdades` DATE NOT NULL,
  `idFinalista` INT(11) DEFAULT NULL,
  `tipo1` VARCHAR(45) NOT NULL,
  `tipo2` VARCHAR(45) NOT NULL,
  `tipo3` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idContrato`),
  UNIQUE KEY `FinalistaUnico` (`idFinalista`),
  KEY `Contrato_Contratante_idx` (`idContratante`),
  CONSTRAINT `Contrato_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Contrato_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`)
) ENGINE=INNODB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


CREATE TABLE `requisitos` (
  `idrequisitos` INT(11) NOT NULL,
  `requisisto` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitos`),
  KEY `fk_requisito_categoria_idx` (`idCategoria`),
  CONSTRAINT `fk_requisito_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `extras` (
  `idExtras` INT(11) NOT NULL,
  `Extrascol` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idExtras`),
  KEY `Extra_Categorioa_idx` (`idCategoria`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionsugeridosestaticosprevio` (
  `idRequisitosDeEjecuionSugeridosEstaticosPrevio` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idRequisitosDeEjecuionSugeridosEstaticosPrevio`),
  KEY `RESEP_CATEGORIA_idx` (`idCategoria`),
  CONSTRAINT `RESEP_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosprevio` (
  `idRequisitosDeEjecuionSugeridosextrasPrevio` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idRequisitosDeEjecuionSugeridosextrasPrevio`),
  KEY `REEEP_CATEGORIA_idx` (`idCategoria`),
  CONSTRAINT `REEEP_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `requisitosobligatoriossugeridos` (
  `idRequisitosObligatorios` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idRequisitosObligatorios`),
  KEY `RequisitoObligatori_Categorial_idx` (`idCategoria`),
  KEY `RequisitoObligatorio_Requisito_idx` (`idRequisito`),
  KEY `RequisitoObligatorio_Contratante_idx` (`idContratante`),
  CONSTRAINT `RequisitoObligatori_Categorial` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoObligatorio_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoObligatorio_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requisitos` (`idrequisitos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosobligatoriosextras` (
  `idRequisitosObligatoriosExtras` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idRequisitosObligatoriosExtras`),
  KEY `RequisitoExtra_Categoria_idx` (`idCategoria`),
  KEY `RequisitoExtra_Extra_idx` (`idRequisito`),
  KEY `RequsitoExtra_Contratante_idx` (`idContratante`),
  CONSTRAINT `RequisitoExtra_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoExtra_Extra` FOREIGN KEY (`idRequisito`) REFERENCES `extras` (`idExtras`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequsitoExtra_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuiondefsugeridosestaticosprevio` (
  `idrequisitosdeejecuiondefsugeridosestaticosprevio` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequsito` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuiondefsugeridosestaticosprevio`),
  KEY `Requi_idContratante_idx` (`idContratante`),
  KEY `Requi_idCategoria_idx` (`idCategoria`),
  KEY `Requi_idRequisito_idx` (`idRequsito`),
  CONSTRAINT `Requi_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Requi_idContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Requi_idRequisito` FOREIGN KEY (`idRequsito`) REFERENCES `requisitosdeejecuionsugeridosestaticosprevio` (`idRequisitosDeEjecuionSugeridosEstaticosPrevio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuiondefextrasestaticosprevio` (
  `idrequisitosdeejecuiondefextrasestaticosprevio` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuiondefextrasestaticosprevio`),
  KEY `REQUI_CONTRATANTE_idx` (`idContratante`),
  KEY `REQUI_CATEGORIA_idx` (`idCategoria`),
  KEY `REQUI_REQUISITOS_idx` (`idRequisito`),
  CONSTRAINT `REQUI_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `REQUI_CONTRATANTE` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `REQUI_REQUISITOS` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionextrasestaticosprevio` (`idRequisitosDeEjecuionSugeridosextrasPrevio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;




CREATE TABLE `fechalimite` (
  `idfechalimite` INT(11) NOT NULL,
  `fechaLimite` DATE NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idfechalimite`),
  KEY `FechaLimite_Categoria_idx` (`idCategoria`),
  KEY `FechaLimite_Contratante_idx` (`idContratante`),
  CONSTRAINT `FechaLimite_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FechaLimite_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `imagenes` (
  `idImagenes` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisitoSugerido` INT(11) NOT NULL,
  `contenido` VARCHAR(145) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaActualizacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idImagenes`,`idRequisitoSugerido`),
  KEY `contenido_requisito_idx` (`idRequisitoSugerido`),
  KEY `Imagen_contratista_idx` (`idContratista`),
  CONSTRAINT `Imagen_contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contenido_requisito` FOREIGN KEY (`idRequisitoSugerido`) REFERENCES `requisitosobligatoriossugeridos` (`idRequisitosObligatorios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `documentos` (
  `idDocumentos` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisitoSugerido` INT(11) NOT NULL,
  `contenido` VARCHAR(145) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaActualizacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDocumentos`,`idRequisitoSugerido`),
  KEY `documento_requisito_idx` (`idRequisitoSugerido`),
  KEY `doc_idContratista_idx` (`idContratista`),
  CONSTRAINT `doc_idContratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `documento_requisito` FOREIGN KEY (`idRequisitoSugerido`) REFERENCES `requisitosobligatoriosextras` (`idRequisitosObligatoriosExtras`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;




CREATE TABLE `documentosestaticospreviosobli` (
  `idDocumentosEstaticosObli` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaActualizacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDocumentosEstaticosObli`),
  KEY `RequisitoPrevioS_DocumentoPrevioSu_idx` (`idRequisito`),
  KEY `Documendo_Finalista_idx` (`idFinalista`),
  CONSTRAINT `Documendo_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoPrevioS_DocumentoPrevioSu` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuiondefsugeridosestaticosprevio` (`idrequisitosdeejecuiondefsugeridosestaticosprevio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `documentosestaticospreviosextras` (
  `iddocumentosestaticospreviosExtras` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`iddocumentosestaticospreviosExtras`),
  KEY `RequisitosExtras_DocPrevExtra_idx` (`idRequisito`),
  KEY `DocPrevEx_idFinalista_idx` (`idFinalista`),
  CONSTRAINT `DocPrevEx_idFinalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitosExtras_DocPrevExtra` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuiondefextrasestaticosprevio` (`idrequisitosdeejecuiondefextrasestaticosprevio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


SELECT * FROM requidinapresug;



-- create Admins ---


INSERT INTO administrador VALUES (1,"admin 1","efren123");
INSERT INTO usuarios VALUES (1,NULL,NULL,NULL,"activo","administrador",1);
