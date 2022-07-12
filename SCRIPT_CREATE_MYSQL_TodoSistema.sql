/**=================================================================
 ** SCRIPT PARA CREAR EL ESQUEMA DE LA BASE DE DATOS TODOSISTEMAS
 ** author: Andrés Cortina
 ** email: andrescort_4@hotmail.com
 **=================================================================*/

CREATE SCHEMA todosistema;
USE todosistema;
CREATE TABLE Actividad (
	idactividad int NOT NULL AUTO_INCREMENT,
	nombre varchar(20) NOT NULL,
	fechaCreada TIMESTAMP NOT NULL,
	fechaEjecutada TIMESTAMP,
	estado varchar(10) NOT NULL,
	PRIMARY KEY (idactividad)
);

CREATE TABLE Empleado (
	idempleado int NOT NULL AUTO_INCREMENT,
	nombre varchar(40) NOT NULL,
	PRIMARY KEY (idempleado)
);

CREATE TABLE ActividadEmpleado (
	idactividad int NOT NULL UNIQUE,
	idempleado int NOT NULL,
    PRIMARY KEY(idactividad,idempleado)
);

ALTER TABLE ActividadEmpleado ADD CONSTRAINT ActividadEmpleado_idactividad FOREIGN KEY (idactividad) REFERENCES Actividad(idactividad);
ALTER TABLE ActividadEmpleado ADD CONSTRAINT ActividadEmpleado_idempleado  FOREIGN KEY (idempleado)  REFERENCES Empleado(idempleado);

/**=================================================================
 ** SCRIPT PARA POBLAR LA BASE DE DATOS CON INFORMACIÓN PARA PRUEBAS
 **=================================================================*/
 
 INSERT INTO todosistema.actividad
(
nombre,
fechaCreada,
fechaEjecutada,
estado)
VALUES
("REVISAR CORREOS",now(),'2022-07-10 08:05:42',"REALIZADA");

INSERT INTO todosistema.actividad
(
nombre,
fechaCreada,
fechaEjecutada,
estado)
VALUES
("PLANEACION SPRING",now(),null,"PENDIENTE");

INSERT INTO todosistema.actividad
(
nombre,
fechaCreada,
fechaEjecutada,
estado)
VALUES
("REALIZAR INVENTARIO",now(),'2022-06-11 13:03:42',"REALIZADA");

INSERT INTO todosistema.actividad
(
nombre,
fechaCreada,
fechaEjecutada,
estado)
VALUES
("REALIZAR BALANCE",now(),null,"PENDIENTE");

INSERT INTO todosistema.actividad
(
nombre,
fechaCreada,
fechaEjecutada,
estado)
VALUES
("REALIZAR PRUEBA",now(),'2022-07-01 10:10:42',"REALIZADA");

/*EMPLEADOS*/
INSERT INTO todosistema.empleado(nombre) VALUES ("ANDRÉS");
INSERT INTO todosistema.empleado(nombre) VALUES ("PABLO");
INSERT INTO todosistema.empleado(nombre) VALUES ("RICARDO");
INSERT INTO todosistema.empleado(nombre) VALUES ("MARÍA");
INSERT INTO todosistema.empleado(nombre) VALUES ("MÓNICA");

/*ACTIVIDADES ASIGNADAS A EMPLEADOS*/
INSERT INTO todosistema.actividadempleado(idactividad,idempleado) VALUES (1,1);
INSERT INTO todosistema.actividadempleado(idactividad,idempleado) VALUES (2,4);
INSERT INTO todosistema.actividadempleado(idactividad,idempleado) VALUES (3,2);
INSERT INTO todosistema.actividadempleado(idactividad,idempleado) VALUES (4,3);
INSERT INTO todosistema.actividadempleado(idactividad,idempleado) VALUES (5,1);



