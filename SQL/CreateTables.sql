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
  `idContratante` INT(11) NOT NULL,
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
  CONSTRAINT `contra_AcTI` FOREIGN KEY (`codigoCIIU`) REFERENCES `activdadeconomica` (`codigoCIIU`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `contratista` (
  `idContratista` INT(11) NOT NULL,
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
  `idContrato` INT(11) NOT NULL,
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
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `finalista` (
  `idFinalista` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFinalista`),
  KEY `Finalista_Contratista_idx` (`idContratista`),
  CONSTRAINT `Finalista_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION
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



CREATE TABLE `requisitosdeejecuionsugeridosestaticosejecucionactividades` (
  `idrequisitosdeejecuionsugeridosestaticosEjecucionActividades` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionsugeridosestaticosEjecucionActividades`),
  KEY `ecucionEstatica_Categoria_idx` (`idCategoria`),
  CONSTRAINT `ecucionEstatica_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosejecucionactividades` (
  `idrequisitosdeejecuionextrasestaticosEjecucionActividades` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionextrasestaticosEjecucionActividades`),
  KEY `ecucionEstaticaExtra_Categoria_idx` (`idCategoria`),
  CONSTRAINT `ecucionEstaticaExtra_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades` (
  `idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades`),
  KEY `FinalizacionActEstatica_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `FinalizacionActEstatica_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requisitosdeejecuionextrasestaticosfinalizaciondeactivdades` (
  `idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades`),
  KEY `FinalizacionActEstaticaExtra_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `FinalizacionActEstaticaExtra_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
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


CREATE TABLE `requisitosdeejecuiondefsugeridosestaticosejecucionactividades` (
  `idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades`),
  KEY `requi_idContratante_idx` (`idContratante`),
  KEY `requi_idCategoria_idx` (`idCategoria`),
  KEY `requi_idRequisito_idx` (`idRequisito`),
  CONSTRAINT `idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idRequisito` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionsugeridosestaticosejecucionactividades` (`idrequisitosdeejecuionsugeridosestaticosEjecucionActividades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `requisitosdeejecuionextrasdefestaticosejecucionactividades` (
  `idrequisitosdeejecuionextrasestaticosejecucionactividades` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idrequisitosdeejecuionextrasestaticosejecucionactividades`),
  KEY `R-idContratante_idx` (`idContratante`),
  KEY `R-idCategoria_idx` (`idCategoria`),
  KEY `R-idRequisito_idx` (`idRequisito`),
  CONSTRAINT `R-idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `R-idContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `R-idRequisito` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionextrasestaticosejecucionactividades` (`idrequisitosdeejecuionextrasestaticosEjecucionActividades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `ejecuionsugeridosestaticosdeffinalizaciondeactivdades` (
  `defFinalizaactiv` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`defFinalizaactiv`),
  KEY `REQ---IDCONTRATANTE_idx` (`idContratante`),
  KEY `REQ---IDCATEGORIA_idx` (`idCategoria`),
  KEY `REQ---IDREQUISITO_idx` (`idRequisito`),
  CONSTRAINT `REQ---IDCATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `REQ---IDCONTRATANTE` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `REQ---IDREQUISITO` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades` (`idrequisitosdeejecuionsugeridosestaticosFinalizacionDeActivdades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `ejecuionextrassestaticosdeffinalizaciondeactivdades` (
  `idejecuionextrassestaticosdeffinalizaciondeactivdades` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`idejecuionextrassestaticosdeffinalizaciondeactivdades`),
  KEY `Reqi----IdContratante_idx` (`idContratante`),
  KEY `Reqi----IdCategoria_idx` (`idCategoria`),
  KEY `reqi----IdRequisito_idx` (`idRequisito`),
  CONSTRAINT `Reqi----IdCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Reqi----IdContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reqi----IdRequisito` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionextrasestaticosfinalizaciondeactivdades` (`idrequisitosdeejecuionextrasestaticosFinalizacionDeActivdades`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

CREATE TABLE `documentosestaticosejecsug` (
  `iddocumentosestaticosEjecSug` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaActualiza` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`iddocumentosestaticosEjecSug`),
  KEY `RequisitoEjecSug_DocEjecSug_idx` (`idRequisito`),
  KEY `DocEjecSug_idFinalista_idx` (`idFinalista`),
  CONSTRAINT `DocEjecSug_idFinalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RequisitoEjecSug_DocEjecSug` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuiondefsugeridosestaticosejecucionactividades` (`idrequisitosdeejecuiondefsugeridosestaticosejecucionactividades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `documentosestaticosejecext` (
  `iddocumentosestaticosejecsug` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`iddocumentosestaticosejecsug`),
  KEY `Requisito_DocEsEjecExt_idx` (`idRequisito`),
  KEY `DocEsEjecExt_idFinalista_idx` (`idFinalista`),
  CONSTRAINT `DocEsEjecExt_idFinalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Requisito_DocEsEjecExt` FOREIGN KEY (`idRequisito`) REFERENCES `requisitosdeejecuionextrasdefestaticosejecucionactividades` (`idrequisitosdeejecuionextrasestaticosejecucionactividades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `documentosestaticosfinalisug` (
  `iddocumentosestaticosFinaliSug` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`iddocumentosestaticosFinaliSug`),
  KEY `Requisito_DocFinalizSug_idx` (`idRequisito`),
  KEY `DocFinalizsug_idFianalist_idx` (`idFinalista`),
  CONSTRAINT `DocFinalizsug_idFianalist` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Requisito_DocFinalizSug` FOREIGN KEY (`idRequisito`) REFERENCES `ejecuionsugeridosestaticosdeffinalizaciondeactivdades` (`defFinalizaactiv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `documentosestaticosfinaliext` (
  `iddocumentosestaticosfinaliExt` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `fechaModificacion` DATE NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`iddocumentosestaticosfinaliExt`),
  KEY `DocFinExt_Requisito_idx` (`idRequisito`),
  KEY `DocFinExt_idFinalista_idx` (`idFinalista`),
  CONSTRAINT `DocFinExt_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `ejecuionextrassestaticosdeffinalizaciondeactivdades` (`idejecuionextrassestaticosdeffinalizaciondeactivdades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DocFinExt_idFinalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `requidinapresug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DinamicoPrevio_Categoria_idx` (`idCategoria`),
  CONSTRAINT `DinamicoPrevio_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinapreex` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dinamicoPrevioExtra_Categoria_idx` (`idCategoria`),
  CONSTRAINT `dinamicoPrevioExtra_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinaejecsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DinamicoEjecSug_Categoria_idx` (`idCategoria`),
  CONSTRAINT `DinamicoEjecSug_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinaejecext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DinamicoEjecExtra_idx` (`idCategoria`),
  CONSTRAINT `DinamicoEjecExtra` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinafinalsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DinamicoFinalSuge_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `DinamicoFinalSuge_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `requidinafinalext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `requisito` VARCHAR(500) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinafinalext_Categoria_idx` (`idCategoria`),
  CONSTRAINT `requidinafinalext_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `requidinadefpresug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinaDefPresug_Contratante_idx` (`idContratante`),
  KEY `requidinaDefpresug_Categoria_idx` (`idCategoria`),
  KEY `requidinaDefpresug_Requisito_idx` (`idRequisito`),
  CONSTRAINT `requidinaDefPresug_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinaDefpresug_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinaDefpresug_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinapresug` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinadefpreext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinadefpreext_idContratante_idx` (`idContratante`),
  KEY `requidinadefpreext_Categoria_idx` (`idCategoria`),
  KEY `requidinadefpreext_Requisito_idx` (`idRequisito`),
  CONSTRAINT `requidinadefpreext_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefpreext_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinapreex` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefpreext_idContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinadefejecsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinadefejecsug_idContratante_idx` (`idContratante`),
  KEY `requidinadefejecsug_idCategoria_idx` (`idCategoria`),
  KEY `requidinadefejecsug_idRequisito_idx` (`idRequisito`),
  CONSTRAINT `requidinadefejecsug_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefejecsug_idContratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefejecsug_idRequisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinaejecsug` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinadefejecext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinadefejecext_Contratante_idx` (`idContratante`),
  KEY `requidinadefejecext_Categoria_idx` (`idCategoria`),
  KEY `requidinadefejecext_requsito_idx` (`idRequisito`),
  CONSTRAINT `requidinadefejecext_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefejecext_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadefejecext_requsito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinaejecext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinadeffinalsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinadeffinalSug_Contratante_idx` (`idContratante`),
  KEY `requidinadeffinalSug_Categoria_idx` (`idCategoria`),
  KEY `requidinadeffinalSug_Requisito_idx` (`idRequisito`),
  CONSTRAINT `requidinadeffinalSug_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadeffinalSug_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadeffinalSug_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinafinalsug` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `requidinadeffinalext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratante` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idRequisito` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `requidinadeffinalext_Contratante_idx` (`idContratante`),
  KEY `requidinadeffinalext_Categoria_idx` (`idCategoria`),
  KEY `requidinadeffinalext_Requisito_idx` (`idRequisito`),
  CONSTRAINT `requidinadeffinalext_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadeffinalext_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `requidinadeffinalext_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinafinalext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `actprevsuger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ActPrevSuger_Requisito_idx` (`idRequisito`),
  KEY `ActPrevSuger_Finalista_idx` (`idFinalista`),
  CONSTRAINT `ActPrevSuger_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ActPrevSuger_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadefpresug` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `actprevext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `actprevext_Requisito_idx` (`idRequisito`),
  KEY `actprevext_finalista_idx` (`idFinalista`),
  CONSTRAINT `actprevext_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadefpreext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actprevext_finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `actejecsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `actejecsug_Requisito_idx` (`idRequisito`),
  KEY `actejecsug_Finalista_idx` (`idFinalista`),
  CONSTRAINT `actejecsug_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actejecsug_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadefejecext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `actejecext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `actejecext_Requisito_idx` (`idRequisito`),
  KEY `actejecext_Finalista_idx` (`idFinalista`),
  CONSTRAINT `actejecext_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actejecext_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadefejecext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `actfinsug` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `actfinsug_Requisito_idx` (`idRequisito`),
  KEY `actfinsug_Finalista_idx` (`idFinalista`),
  CONSTRAINT `actfinsug_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actfinsug_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadeffinalsug` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `actfinext` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRequisito` INT(11) NOT NULL,
  `idFinalista` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaDeEjecucion` DATE NOT NULL,
  `fechaEjecutada` DATE DEFAULT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `contenido` VARCHAR(500) DEFAULT NULL,
  `tipo` VARCHAR(45) DEFAULT NULL,
  `estado` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `actfinExt_Requisito_idx` (`idRequisito`),
  KEY `actfinExt_Finalista_idx` (`idFinalista`),
  CONSTRAINT `actfinExt_Finalista` FOREIGN KEY (`idFinalista`) REFERENCES `finalista` (`idFinalista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actfinExt_Requisito` FOREIGN KEY (`idRequisito`) REFERENCES `requidinadefejecext` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;







-- create Admins ---


INSERT INTO administrador VALUES (1,"admin 1","efren123");
INSERT INTO usuarios VALUES (1,NULL,NULL,NULL,"activo","administrador",1);
