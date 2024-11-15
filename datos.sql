CREATE DATABASE db_pruebas;

CREATE TABLE public.roles
(
    "idRol" serial NOT NULL,
    nombre character varying(50),
    estado boolean DEFAULT 'true',
    PRIMARY KEY ("idRol")
);

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

CREATE TABLE public.usuarios
(
    "idUser" serial NOT NULL,
    "idRol" integer,
    nombre character varying(100),
    correo character varying(150),
    clave character varying(250),
    estado boolean DEFAULT 'true',
    PRIMARY KEY ("idUser"),
    CONSTRAINT fk_roles FOREIGN KEY ("idRol")
        REFERENCES public.roles ("idRol") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;