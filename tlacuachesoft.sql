	
CREATE TABLE ALUMNO(
	id_Alumno SERIAL,
	n_numeroCuenta integer NOT NULL,
	s_nombre character varying(32) NOT NULL,
	s_appaterno character varying(32) NOT NULL,
	s_apmaterno character varying(32) NOT NULL,
	s_contrasenha character varying(32) NOT NULL,
	s_correo character varying(32) NOT NULL,
	CONSTRAINT "alumno_pk" PRIMARY KEY (id_Alumno),
	CONSTRAINT "alumno_uNumeroCuenta" UNIQUE (n_numeroCuenta),
	CONSTRAINT "alumno_uCorreo" UNIQUE (s_correo)
);

CREATE TABLE PROFESOR(
	id_Profesor SERIAL,
	s_RFC character varying(32) NOT NULL,
	s_nombre character varying(32) NOT NULL,
	s_appaterno character varying(32) NOT NULL,
	s_apmaterno character varying(32) NOT NULL,
	s_contrasenha character varying(32) NOT NULL,
	s_correo character varying(32) NOT NULL,
	CONSTRAINT "profesor_pk" PRIMARY KEY (id_Profesor),
	CONSTRAINT "profesor_uRFC" UNIQUE (s_RFC),
	CONSTRAINT "profesor_uCorreo" UNIQUE (s_correo)
);

---consulta de profesor
select * from profesor;
--- insertar de profesor
--- empiezan en el 
insert into profesor (id_Profesor, s_RFC,s_nombre,s_appaterno,s_apmaterno,s_contrasenha,s_correo)values
 (1,'AER681A814','rodrigo','rivera','paz','12345','rodrigo@ciencias');
insert into profesor (id_Profesor, s_RFC,s_nombre,s_appaterno,s_apmaterno,s_contrasenha,s_correo)values
 (2,'AERdwadwa','rodrigo','rivera','paz','12345','valeria@ciencias');

insert into profesor (id_Profesor,s_RFC,s_nombre,s_appaterno,s_apmaterno,s_contrasenha,s_correo)values
 (3,'AE5dwadwa','rodrigo','rivera','paz','12345','santiga@ciencias');



CREATE TABLE TIPO(
	id_Tipo SERIAL,
	s_Tipo character varying(32) NOT NULL,
	CONSTRAINT "tipo_pk" PRIMARY KEY (id_Tipo)
);

--- consulta de tipo
select * from Tipo;
-- insserssiones
-- empiezan en el 1
insert into tipo (id_Tipo,s_Tipo)values(1,'Actividad al Apoyo Docencia');
insert into tipo (id_Tipo,s_Tipo)values(2,'Actividad al Apoyo Divulgacion');
insert into tipo (id_Tipo,s_Tipo)values(3,'Actividad al Apoyo Investigacion');


CREATE TABLE AREA(
	id_Area SERIAL,
	s_Area character varying(32) NOT NULL,
	CONSTRAINT "area_pk" PRIMARY KEY (id_Area)
);

--- consultad ede area
select * from area;
--insertar de area nunca va a cambiar  
--- empieza desde el 3
insert into area (id_Area,s_Area)values (1,'Computo Cientifico');
insert into area (id_Area,s_Area)values (2,'Redes Computadora');
insert into area (id_Area,s_Area)values (3,'Ingenieria Software Base Datos');
insert into area (id_Area,s_Area)values (4,'Inteligencia Artificial');
insert into area (id_Area,s_Area)values (5,'Imagenes Ambientes Virtuales');
insert into area (id_Area,s_Area)values (6,'Teoria Computacion');




CREATE TABLE ACTIVIDAD(
	id_Actividad SERIAL,
	id_Profesor integer NOT NULL,
	id_Tipo integer NOT NULL,
	id_Area integer NOT NULL,
	i_CupoDisponible integer NOT NULL,
	i_CupoMaximo integer NOT NULL,
	s_Nombre character varying(32) NOT NULL,
	s_Descripciom character varying(128) NOT NULL,
	f_fechaModificacion date NOT NULL,
	f_fechaDescripion date NOT NULL,
	CONSTRAINT "actividad_pk" PRIMARY KEY (id_Actividad),
	CONSTRAINT "actividad_fk_Profesor" FOREIGN KEY (id_Profesor)
		REFERENCES PROFESOR (id_Profesor) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "actividad_fk_Tipo" FOREIGN KEY (id_Tipo)
		REFERENCES TIPO (id_Tipo) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "actividad_fk_Area" FOREIGN KEY (id_Area)
		REFERENCES AREA (id_Area) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

--- consulta
select * from actividad; 
---- insertar
insert into ACTIVIDAD(id_Profesor, id_Tipo,id_Area, i_CupoDisponible , i_CupoMaximo,s_Nombre,s_Descripciom,f_fechaModificacion, f_fechaDescripion)values 
			(1,2,5,0,6,'Analiss de algorimos','nesesitamos a gente interesada en ','2016/06/28','2016/07/15');

			
CREATE TABLE SOLICITUD(
	id_Solicitud SERIAL,
	id_Actividad integer NOT NULL,
	id_Profesor integer NOT NULL,
	id_Alumno integer NOT NULL,
	f_fechaEnvio date NOT NULL,
	b_Aceptada integer NOT NULL,
	CONSTRAINT "solicitud_pk" PRIMARY KEY (id_Solicitud),
	CONSTRAINT "solicitud_fk_Actividad" FOREIGN KEY (id_Actividad)
		REFERENCES ACTIVIDAD (id_Actividad) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "solicitud_fk_Profesor" FOREIGN KEY (id_Profesor)
		REFERENCES PROFESOR (id_Profesor) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "solicitud_fk_Alumno" FOREIGN KEY (id_Alumno)
		REFERENCES ALUMNO (id_Alumno) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE ACTIVIDAD_ALUMNO(
	id_Actividad_Alumno SERIAL,
	id_Actividad integer NOT NULL,
	id_Alumno integer NOT NULL,
	f_fechaInicio date NOT NULL,
	f_fechaFin date NOT NULL,
	b_Terminada integer NOT NULL,
	CONSTRAINT "actividad_alumno_pk" PRIMARY KEY (id_Actividad_Alumno),
	CONSTRAINT "actividad_alumno_fk_Actividad" FOREIGN KEY (id_Actividad)
		REFERENCES ACTIVIDAD (id_Actividad) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT "actividad_alumno_fk_Alumno" FOREIGN KEY (id_Alumno)
		REFERENCES ALUMNO (id_Alumno) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

