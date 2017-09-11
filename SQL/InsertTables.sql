INSERT INTO arl VALUES (1,"Sura"); 
INSERT INTO arl VALUES (2,"Bolivar");
INSERT INTO arl VALUES (3,"Equidad");
INSERT INTO arl VALUES(4,"Aurora");
INSERT INTO arl VALUES (5,"Colpatria");
INSERT INTO arl VALUES (6,"Positiva");
INSERT INTO arl VALUES (7,"Liberty");
INSERT INTO arl VALUES (8,"Mapfre");
INSERT INTO arl VALUES (9,"Bolivar");
INSERT INTO arl VALUES (10,"Alfa");




INSERT INTO ciudad VALUES (1, "Bogotá");
INSERT INTO ciudad VALUES(2,"Rioacha");
INSERT INTO ciudad VALUES(3,"Santa Marta");
INSERT INTO ciudad VALUES(4,"San Jose del Guaviare");
INSERT INTO ciudad VALUES (5,"Tunja");
INSERT INTO ciudad VALUES(6,"Cali");
INSERT INTO ciudad VALUES(7,"Leticia");
INSERT INTO ciudad VALUES (8,"Villavicencio");
INSERT INTO ciudad VALUES (9,"Medellín");
INSERT INTO ciudad VALUES(10,"Cartagena");
INSERT INTO ciudad VALUES(11,"Cauca");
INSERT INTO ciudad VALUES (12,"Manizales");
INSERT INTO ciudad VALUES (13,"Florencia");
INSERT INTO ciudad VALUES (14,"Yopal");
INSERT INTO ciudad VALUES (15,"Valledupar");

INSERT INTO ciudad VALUES (16,"Quibdo"); 
INSERT INTO ciudad VALUES (17,"Monteria"); 
INSERT INTO ciudad VALUES (18,"Inirida");
INSERT INTO ciudad VALUES (19,"Neiva"); 
INSERT INTO ciudad VALUES (20,"Pasto"); 
INSERT INTO ciudad VALUES (21,"Cucuta"); 
INSERT INTO ciudad VALUES (22,"Mocoa");
INSERT INTO ciudad VALUES (23,"Armenia");
INSERT INTO ciudad VALUES (24,"Pereira");
INSERT INTO ciudad VALUES (25,"San Andrés");
INSERT INTO ciudad VALUES (26,"Bucaramanga");
INSERT INTO ciudad VALUES (27,"Sincelejo");
INSERT INTO ciudad VALUES (28,"Ibague");
INSERT INTO ciudad VALUES (29,"Mitu");
INSERT INTO ciudad VALUES (30,"Puerto Carreño");
INSERT INTO ciudad VALUES (31,"Cauca");

DELETE FROM contratante WHERE idContratante=1;
 
INSERT INTO departamento VALUES (1,"Bogotá D.C",1);
INSERT INTO departamento VALUES(2,"La Guajira",2);
INSERT INTO departamento VALUES(3,"Magdalena",3);
INSERT INTO departamento VALUES(4,"Guaviare",4);
INSERT INTO departamento VALUES(5,"Boyaca",5);
INSERT INTO departamento VALUES(6,"Valle del Cauca",5);
INSERT INTO departamento VALUES(7,"Amazonas",7);
INSERT INTO departamento VALUES(8,"Meta",8);
INSERT INTO departamento VALUES (9,"Antioquia",9);
INSERT INTO departamento VALUES (11,"Cuaca",11);
INSERT INTO departamento VALUES (12,"Caldas",12);
INSERT INTO departamento VALUES (13,"Caqueta",13);
INSERT INTO departamento VALUES (14,"Casanare",14);
INSERT INTO departamento VALUES (15,"Cesar",15);
INSERT INTO departamento VALUES (16,"Choco",16);
INSERT INTO departamento VALUES (17,"Cordoba",17);
INSERT INTO departamento VALUES (18,"Guanía",18);
INSERT INTO departamento VALUES (19,"Huila",19);
INSERT INTO departamento VALUES (20,"Nariño",20);
INSERT INTO departamento VALUES (21,"Norte de Santander",21);
INSERT INTO departamento VALUES (22,"Putumayo",22);
INSERT INTO departamento VALUES (23,"Quindio",23);
INSERT INTO departamento VALUES (24,"Risaralda",24);
INSERT INTO departamento VALUES (25,"San Andrés",25);
INSERT INTO departamento VALUES (26,"Santander",26);
INSERT INTO departamento VALUES (27,"Sucre",27);
INSERT INTO departamento VALUES (28,"Tolima",28);
INSERT INTO departamento VALUES (29,"Vaupes",29);
INSERT INTO departamento VALUES (30,"Vichada",30);
INSERT INTO departamento VALUES (31,"Popayan",31);






INSERT INTO categoria VALUES (1,"CATEGORIA 1");
INSERT INTO categoria VALUES (2,"CATEGORIA 2");
INSERT INTO categoria VALUES (3,"CATEGORIA A");
INSERT INTO categoria VALUES (4,"CATEGORIA B");



INSERT INTO extras VALUES (1,"LAVAR ROPA",1);

INSERT INTO extras VALUES (2,"SECAR ROPA",1);

INSERT INTO extras VALUES (3,"ELEGIR HERRAMIENTA",2);

INSERT INTO extras VALUES(6,"LAVAR CEPILLO",2);

INSERT INTO extras VALUES (4,"TERMINAR MATRICES",3);

INSERT INTO extras VALUES (5,"TOMAR DECISIONES",4);


 LOAD DATA LOCAL INFILE "/Users/HSEQ/Documents/ActividadesEconomicas.csv" INTO TABLE activdadeconomica
 FIELDS TERMINATED BY ';'
 LINES TERMINATED BY '\n';
 
 
 LOAD DATA LOCAL INFILE "/Users/User/Documents/ActividadesEconomicas.csv" INTO TABLE activdadeconomica
 FIELDS TERMINATED BY ';'
 LINES TERMINATED BY '\n'; 
 
 
  LOAD DATA LOCAL INFILE "/Users/HSEQ/Documents/requisitosSeleccion.csv" INTO TABLE requisitos
 FIELDS TERMINATED BY ';'
 LINES TERMINATED BY '\n'; 
 LOAD DATA LOCAL INFILE "/Users/User/Documents/requisitosSeleccion.csv" INTO TABLE requisitos
 FIELDS TERMINATED BY ';'
 LINES TERMINATED BY '\n'; 
 
 
 LOAD DATA LOCAL INFILE "/Users/HSEQ/Documents/ejecucionEstaticaPrevia.csv" INTO TABLE requisitosdeejecuionsugeridosestaticosprevio
 FIELDS TERMINATED BY ';'
 LINES TERMINATED BY '\n'; 
 
 

 
 INSERT INTO requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 1",1);
 INSERT INTO requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 2",2);
 INSERT INTO requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 3",3);
 INSERT INTO requisitosdeejecuionextrasestaticosprevio(requisito,idCategoria) VALUES ("REQUISITO PREVIO ESTATICO EXTRA 4",4);
