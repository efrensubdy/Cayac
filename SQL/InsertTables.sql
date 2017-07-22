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


 load data local infile "/Users/User/Documents/ActividadesEconomicas.csv" into table activdadeconomica
 fields terminated by ';'
 lines terminated by '\n';
 
  load data local infile "/Users/User/Documents/requisitosSeleccion.csv" into table requisitos
 fields terminated by ';'
 lines terminated by '\n'; 
 
 select * from requisitosdeejecuionsugeridosestaticosprevio;
 load data local infile "/Users/User/Documents/ejecucionEstaticaPrevia.csv" into table sys.requisitosdeejecuionsugeridosestaticosprevio
 fields terminated by ';'
 lines terminated by '\n'; 
 
  load data local infile "/Users/User/Documents/ejecucionDuranteContratoEstatico.csv" into table sys.requisitosdeejecuionsugeridosestaticosejecucionactividades
 fields terminated by ';'
 lines terminated by '\n'; 
 
 
  load data local infile "/Users/User/Documents/ejecucionFinalizacionEstatica.csv" into table sys.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades
 fields terminated by ';'
 lines terminated by '\n'; 
 
 -- Aqui quedamos --
 
  load data local infile "/Users/User/Documents/DinamicosPrevios.csv" into table sys.requidinapresug
 fields terminated by ';'
 lines terminated by '\n'; 
 
   load data local infile "/Users/User/Documents/DinamicosEjecucion.csv" into table sys.requidinaejecsug
 fields terminated by ';'
 lines terminated by '\n'; 
 
 select * from requidinaejecsug;
 
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO SUGERIDO 1",1);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosprevio (requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO SUGERIDO 2",2);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosprevio (requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO SUGERIDO 3",3);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosprevio (requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO SUGERIDO 4",4);
 
 
 INSERT INTO SYS.requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 1",1);
 INSERT INTO SYS.requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 2",2);
 INSERT INTO SYS.requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 3",3);
 INSERT INTO SYS.requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 4",4);
 
 
 
 
INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO SUGERIDO 1",1);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO SUGERIDO 2",2);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO SUGERIDO 3",3);
 INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO SUGERIDO 4",4);
 
INSERT INTO SYS.requisitosdeejecuionextrasestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO EXTRA 1",1); 
INSERT INTO SYS.requisitosdeejecuionextrasestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO EXTRA 2",2); 
INSERT INTO SYS.requisitosdeejecuionextrasestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO EXTRA 3",3); 
INSERT INTO SYS.requisitosdeejecuionextrasestaticosejecucionactividades (requisito,idCategoria) VALUES ("REQUISITO EJECUCION ESTATICO EXTRA 4",4); 

INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION SUGERIDO 1",1);
INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION SUGERIDO 2",2);
INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION SUGERIDO 3",3);
INSERT INTO SYS.requisitosdeejecuionsugeridosestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION SUGERIDO 4",4);
 
INSERT INTO SYS.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION EXTRA 1",1);
INSERT INTO SYS.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION EXTRA 2",2);
INSERT INTO SYS.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION EXTRA 3",3);
INSERT INTO SYS.requisitosdeejecuionextrasestaticosfinalizaciondeactivdades (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION EXTRA 4",4);

 
 INSERT INTO SYS.requidinapresug (requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO SUGERIDO 1",1);
 INSERT INTO SYS.requidinapresug (requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO SUGERIDO 2",2);
 INSERT INTO SYS.requidinapresug (requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO SUGERIDO 3",3);
 INSERT INTO SYS.requidinapresug (requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO SUGERIDO 4",4);
 
 INSERT INTO SYS.requidinapreex (requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO EXTRA 1",1);
 INSERT INTO SYS.requidinapreex(requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO EXTRA 2",2);
 INSERT INTO SYS.requidinapreex(requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO EXTRA 3",3);
 INSERT INTO SYS.requidinapreex(requisito,idCategoria) VALUES ("REQUISITO PREVIO DINAMICO EXTRA 4",4);
 
INSERT INTO SYS.requidinaejecsug (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO SUGERIDO 1",1);
 INSERT INTO SYS.requidinaejecsug (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO SUGERIDO 2",2);
 INSERT INTO SYS.requidinaejecsug (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO SUGERIDO 3",3);
 INSERT INTO SYS.requidinaejecsug (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO SUGERIDO 4",4);
 
 INSERT INTO SYS.requidinaejecext (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO EXTRA 1",1); 
INSERT INTO SYS.requidinaejecext (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO EXTRA 2",2); 
INSERT INTO SYS.requidinaejecext (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO EXTRA 3",3); 
INSERT INTO SYS.requidinaejecext (requisito,idCategoria) VALUES ("REQUISITO EJECUCION DINAMICO EXTRA 4",4); 

INSERT INTO SYS.requidinafinalsug (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO 1",1);
INSERT INTO SYS.requidinafinalsug (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO 2",2);
INSERT INTO SYS.requidinafinalsug (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO 3",3);
INSERT INTO SYS.requidinafinalsug (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO 4",4);
 
INSERT INTO SYS.requidinafinalext (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO EXTRA 1",1);
INSERT INTO SYS.requidinafinalext (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO EXTRA 2",2);
INSERT INTO SYS.requidinafinalext (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO EXTRA 3",3);
INSERT INTO SYS.requidinafinalext (requisito,idCategoria) VALUES ("REQUISITO FINALIZACION DINAMICO EXTRA 4",4);
