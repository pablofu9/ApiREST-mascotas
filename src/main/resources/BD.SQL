DROP DATABASE IF EXISTS mascotas;
CREATE DATABASE mascotas;
Use mascotas;

CREATE TABLE dueno(
                      id_dueno int unsigned auto_increment primary key,
                      nombre_dueno varchar(16) not null,
                      apellido_dueno varchar(30) not null);

INSERT INTO dueno(nombre_dueno, apellido_dueno) VALUES ('Juan','Fernandez'), ('Pedro','Lopez'),('Maria','Castro');


CREATE TABLE perro(
                      id_perro int unsigned auto_increment primary key,
                      id_dueno int unsigned,
                      nombre_perro varchar(30),
                      raza varchar(30),
                      FOREIGN KEY (id_dueno)
                          REFERENCES dueno(id_dueno)
                          ON DELETE CASCADE
);
INSERT INTO perro (id_dueno,nombre_perro,raza) VALUES
                                                   (1,"Pancho","Cruce"),
                                                   (2,"Gala","Pastor Aleman"),
                                                   (3,"Luna","Cocker"),
                                                   (2,"Trufa","Perro de aguas");