	
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
CREATE TABLE TIPO(
	id_Tipo SERIAL,
	s_Tipo character varying(32) NOT NULL,
	CONSTRAINT "tipo_pk" PRIMARY KEY (id_Tipo)
);
CREATE TABLE AREA(
	id_Area SERIAL,
	s_Area character varying(32) NOT NULL,
	CONSTRAINT "area_pk" PRIMARY KEY (id_Area)
);
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

