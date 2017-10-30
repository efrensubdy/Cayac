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

CREATE TABLE `planDeTrabajo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mes` VARCHAR(20) NOT NULL,
  `actividad` VARCHAR(100) NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `evidencia` VARCHAR(500) DEFAULT NULL,
  `idContratista` INT(11) NOT NULL,
  `fechaDeRegistro` DATE NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Actividad_Contratista` (`idContratista`),
  CONSTRAINT `Actividad_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `inboxContratante` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mensaje` VARCHAR(500) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mail_Contratante` (`idContratante`),
  CONSTRAINT `mail_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `inboxContratista` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mensaje` VARCHAR(500) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `idContratista` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mail__Contratante` (`idContratante`),
  KEY `mail__Contratista` (`idContratista`),
  CONSTRAINT `mail__Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `mail__Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `Aprobacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contratante_aprobacion` (`idContratante`),
  KEY `contratista_aprobacion` (`idContratista`),
  CONSTRAINT `contratante_aprobacion` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `contratista_aprobacion` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `aprobarplandetrabajo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mes` VARCHAR(50) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Contratista` (`idContratista`),
  KEY `fk_Contratante` (`idContratante`),
  CONSTRAINT `fk_Contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `fk_Contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE `seguridadsocial` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mes` VARCHAR(50) NOT NULL,
  `fechaDeSubida` DATE NOT NULL,
  `seguridadSocial` VARCHAR(500) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `personal` VARCHAR(500) NOT NULL,
  `cambios` VARCHAR(500) NOT NULL,
  `tipo1` VARCHAR(50) NOT NULL,
  `tipo2` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contratista` (`idContratista`),
  KEY `contratante` (`idContratante`),
  CONSTRAINT `contratante` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `Indicadores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreContra` VARCHAR(100) NOT NULL,
  `periodo` VARCHAR(100) NOT NULL,
  `responsable` VARCHAR(100) NOT NULL,
  `departamento` VARCHAR(100) NOT NULL,
  `actividad` VARCHAR(100) NOT NULL,
  `severidad` FLOAT NOT NULL,
  `frecuencia` FLOAT NOT NULL,
  `mortalidad` FLOAT NOT NULL,
  `prevalencia` FLOAT NOT NULL,
  `incidencia` FLOAT NOT NULL,
  `ausentismo` FLOAT NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `año` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Contratista_Indicador` (`idContratista`),
  KEY `Contratante_Indicador` (`idContratante`),
  CONSTRAINT `Contratante_Indicador` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `Contratista_Indicador` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `aprobarindicadores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `mes` VARCHAR(100) NOT NULL,
  `year` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista_a` (`idContratista`),
  KEY `idContratante_b` (`idContratante`),
  CONSTRAINT `idContratante_b` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `idContratista_a` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `accidentes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(800) NOT NULL,
  `primerApellido` VARCHAR(100) NOT NULL,
  `segundoApellido` VARCHAR(100) NOT NULL,
  `primerNombre` VARCHAR(100) NOT NULL,
  `segundoNombre` VARCHAR(100) NOT NULL,
  `identificacion` VARCHAR(30) NOT NULL,
  `numero` INT(20) NOT NULL,
  `nacimiento` DATE NOT NULL,
  `sexo` VARCHAR(100) NOT NULL,
  `departamento` VARCHAR(100) NOT NULL,
  `muni` VARCHAR(100) NOT NULL,
  `zonas` VARCHAR(100) NOT NULL,
  `cargo` VARCHAR(100) NOT NULL,
  `ingreso` DATE NOT NULL,
  `accidente` DATE NOT NULL,
  `hora` VARCHAR(50) NOT NULL,
  `diaSe` VARCHAR(50) NOT NULL,
  `jornada` VARCHAR(50) NOT NULL,
  `sino` VARCHAR(50) NOT NULL,
  `tipoA` VARCHAR(200) NOT NULL,
  `lugari` VARCHAR(200) NOT NULL,
  `depa` VARCHAR(100) NOT NULL,
  `mun` VARCHAR(100) NOT NULL,
  `zon` VARCHAR(100) NOT NULL,
  `si2` VARCHAR(50) NOT NULL,
  `tipoB` VARCHAR(200) NOT NULL,
  `lesion` VARCHAR(200) NOT NULL,
  `mecanismo` VARCHAR(200) NOT NULL,
  `parte` VARCHAR(200) NOT NULL,
  `agente` VARCHAR(200) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista_Accidente` (`idContratista`),
  KEY `idContratante_Accidente` (`idContratante`),
  CONSTRAINT `idContratante_Accidente` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `idContratista_Accidente` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `estandaresMinimos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `recursos` FLOAT NOT NULL,
  `capacitacion` FLOAT NOT NULL,
  `politica` FLOAT NOT NULL,
  `objetivos` FLOAT NOT NULL,
  `evaInicial` FLOAT NOT NULL,
  `planAnual` FLOAT NOT NULL,
  `documen` FLOAT NOT NULL,
  `cuentas` FLOAT NOT NULL,
  `normatividad` FLOAT NOT NULL,
  `mecanismos` FLOAT NOT NULL,
  `adquisiones` FLOAT NOT NULL,
  `contrataciones` FLOAT NOT NULL,
  `cambios` FLOAT NOT NULL,
  `condiciones` FLOAT NOT NULL,
  `registro` FLOAT NOT NULL,
  `vigilancia` FLOAT NOT NULL,
  `peligros` FLOAT NOT NULL,
  `prevencion` FLOAT NOT NULL,
  `planPrevencion` FLOAT NOT NULL,
  `gestion` FLOAT NOT NULL,
  `accionesPreven` FLOAT NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `fechaDeRegistro` DATE NOT NULL,
  KEY `id` (`id`),
  KEY `idContratista_Estandares` (`idContratista`),
  KEY `idContratante_Estandares` (`idContratante`),
  CONSTRAINT `idContratante_Estandares` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `idContratista_Estandares` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `auditoria` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `auditoria` VARCHAR(500) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idContratante` INT(11) NOT NULL,
  `mes` VARCHAR(500) NOT NULL,
  `year` INT(20) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista_Auditoria` (`idContratista`),
  KEY `idContratante_Auditoria` (`idContratante`),
  CONSTRAINT `idContratante_Auditoria` FOREIGN KEY (`idContratante`) REFERENCES `contratante` (`idContratante`),
  CONSTRAINT `idContratista_Auditoria` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE `noConformidad` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `noConformidad` VARCHAR(1000) NOT NULL,
  `idAuditoria` INT(11) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `mes` VARCHAR(50) NOT NULL,
  `year` INT(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista` (`idContratista`),
  KEY `idAuditoria` (`idAuditoria`),
  CONSTRAINT `idAuditoria` FOREIGN KEY (`idAuditoria`) REFERENCES `auditoria` (`id`),
  CONSTRAINT `idContratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `causa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `causa` VARCHAR(1000) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `idNoConformidad` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista_contratista` (`idContratista`),
  KEY `idContratista_noConformidad` (`idNoConformidad`),
  CONSTRAINT `idContratista_contratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`),
  CONSTRAINT `idContratista_noConformidad` FOREIGN KEY (`idNoConformidad`) REFERENCES `noConformidad` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `accion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idContratista` INT(11) NOT NULL,
  `idCausa` INT(11) NOT NULL,
  `nombre` VARCHAR(500) NOT NULL,
  `registro` VARCHAR(500) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContratista_Accion` (`idContratista`),
  KEY `idCausa_Causa` (`idCausa`),
  CONSTRAINT `idCausa_Causa` FOREIGN KEY (`idCausa`) REFERENCES `causa` (`id`),
  CONSTRAINT `idContratista_Accion` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `cierreDeNoConfor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idNoConformidad` INT(11) NOT NULL,
  `idContratista` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cierre_NoConformidad` (`idNoConformidad`),
  KEY `cierre_idContratista` (`idContratista`),
  CONSTRAINT `cierre_NoConformidad` FOREIGN KEY (`idNoConformidad`) REFERENCES `noConformidad` (`id`),
  CONSTRAINT `cierre_idContratista` FOREIGN KEY (`idContratista`) REFERENCES `contratista` (`idContratista`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;




-- create Admins ---


INSERT INTO administrador VALUES (1,"admin 1","efren123");
INSERT INTO usuarios VALUES (1,NULL,NULL,NULL,"activo","administrador",1);
