--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: alumnos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumnos (
    dni numeric(8,0) NOT NULL,
    nombre_alumno character varying(15) NOT NULL,
    apellido_alumno character varying(30) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion character varying(50) NOT NULL,
    telefono numeric(9,0)
);


ALTER TABLE public.alumnos OWNER TO postgres;

--
-- Name: clases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clases (
    nombre_clase character varying(15) NOT NULL
);


ALTER TABLE public.clases OWNER TO postgres;

--
-- Name: informacion_general; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.informacion_general (
    identificador_general integer NOT NULL,
    nombre_clase character varying(15),
    nombre_alumno character varying(15),
    apellido_alumno character varying(30),
    dni numeric(8,0),
    nombre_materia character varying(35),
    examen_1 integer,
    examen_2 integer,
    examen_3 integer,
    media integer,
    nombre_profesor character varying(15),
    id_profesor numeric(3,0)
);


ALTER TABLE public.informacion_general OWNER TO postgres;

--
-- Name: informacion_general_identificador_general_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.informacion_general_identificador_general_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.informacion_general_identificador_general_seq OWNER TO postgres;

--
-- Name: informacion_general_identificador_general_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.informacion_general_identificador_general_seq OWNED BY public.informacion_general.identificador_general;


--
-- Name: materias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materias (
    nombre_materia character varying(35) NOT NULL
);


ALTER TABLE public.materias OWNER TO postgres;

--
-- Name: profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesores (
    id_profesor numeric(3,0) NOT NULL,
    nombre_profesor character varying(15) NOT NULL,
    apellido_profesor character varying(30) NOT NULL,
    email character varying(30),
    movil numeric(9,0),
    "contraseña" numeric(6,0),
    estado boolean
);


ALTER TABLE public.profesores OWNER TO postgres;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    nombre_usuario character varying(20) NOT NULL,
    "contraseña" character(6) NOT NULL,
    estado boolean NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_usuario_seq OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuarios.id_usuario;


--
-- Name: informacion_general identificador_general; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general ALTER COLUMN identificador_general SET DEFAULT nextval('public.informacion_general_identificador_general_seq'::regclass);


--
-- Name: usuarios id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (dni, nombre_alumno, apellido_alumno, fecha_nacimiento, direccion, telefono) FROM stdin;
12345678	Juan	Pérez	2010-05-20	Calle 123	986123456
23456789	María	López	2010-06-15	Avenida 456	986234567
34567890	Carlos	García	2010-07-10	Carrera 789	986345678
45678901	Laura	Martínez	2010-08-25	Callejón 321	986456789
56789012	Pedro	González	2010-09-30	Camino 654	986567890
67890123	Ana	Rodríguez	2010-10-05	Autopista 987	986678901
78901234	Luis	Sánchez	2011-01-12	Paseo 789	986789012
89012345	Marta	Fernández	2011-02-18	Plaza 159	986890123
90123456	David	Ramírez	2011-03-20	Ronda 357	986901234
10234567	Elena	Torres	2011-04-22	Boulevard 246	986012345
11111111	Prueba	Prueba	2000-01-01	Calle Principal 123	987654321
\.


--
-- Data for Name: clases; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clases (nombre_clase) FROM stdin;
1ESO
2ESO
3ESO
4ESO
\.


--
-- Data for Name: informacion_general; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.informacion_general (identificador_general, nombre_clase, nombre_alumno, apellido_alumno, dni, nombre_materia, examen_1, examen_2, examen_3, media, nombre_profesor, id_profesor) FROM stdin;
25	1ESO	Pedro	González	56789012	Inglés	\N	\N	\N	\N	Maria	111
26	1ESO	Ana	Rodríguez	67890123	Inglés	\N	\N	\N	\N	Maria	111
27	1ESO	Luis	Sánchez	78901234	Inglés	\N	\N	\N	\N	Maria	111
28	1ESO	Marta	Fernández	89012345	Inglés	\N	\N	\N	\N	Maria	111
29	1ESO	David	Ramírez	90123456	Inglés	\N	\N	\N	\N	Maria	111
30	1ESO	Elena	Torres	10234567	Inglés	\N	\N	\N	\N	Maria	111
2	1ESO	María	López	23456789	Matemáticas	\N	\N	\N	\N	Maria	111
1	1ESO	Juan	Pérez	12345678	Matemáticas	\N	\N	\N	\N	Maria	111
3	1ESO	Carlos	García	34567890	Matemáticas	\N	\N	\N	\N	Maria	111
4	1ESO	Laura	Martínez	45678901	Matemáticas	\N	\N	\N	\N	Maria	111
6	1ESO	Ana	Rodríguez	67890123	Matemáticas	\N	\N	\N	\N	Maria	111
7	1ESO	Luis	Sánchez	78901234	Matemáticas	\N	\N	\N	\N	Maria	111
8	1ESO	Marta	Fernández	89012345	Matemáticas	\N	\N	\N	\N	Maria	111
9	1ESO	David	Ramírez	90123456	Matemáticas	\N	\N	\N	\N	Maria	111
10	1ESO	Elena	Torres	10234567	Matemáticas	\N	\N	\N	\N	Maria	111
11	1ESO	Juan	Pérez	12345678	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
12	1ESO	María	López	23456789	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
13	1ESO	Carlos	García	34567890	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
14	1ESO	Laura	Martínez	45678901	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
15	1ESO	Pedro	González	56789012	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
16	1ESO	Ana	Rodríguez	67890123	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
17	1ESO	Luis	Sánchez	78901234	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
18	1ESO	Marta	Fernández	89012345	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
19	1ESO	David	Ramírez	90123456	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
20	1ESO	Elena	Torres	10234567	Lengua y Literatura	\N	\N	\N	\N	Noelia	222
5	1ESO	Pedro	González	56789012	Matemáticas	\N	\N	\N	\N	Maria	111
21	1ESO	María	López	23456789	Inglés	\N	\N	\N	\N	Maria	111
22	1ESO	Juan	Pérez	12345678	Inglés	\N	\N	\N	\N	Maria	111
23	1ESO	Carlos	García	34567890	Inglés	\N	\N	\N	\N	Maria	111
24	1ESO	Laura	Martínez	45678901	Inglés	\N	\N	\N	\N	Maria	111
\.


--
-- Data for Name: materias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materias (nombre_materia) FROM stdin;
Matemáticas
Lengua y Literatura
Ciencias Naturales
Geografía e Historia
Inglés
Educación Física
\.


--
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesores (id_profesor, nombre_profesor, apellido_profesor, email, movil, "contraseña", estado) FROM stdin;
111	Maria	Rodriguez	mariarodriguez@ejemplo.com	\N	123456	t
222	Noelia	Alonso	noeliaalonso@ejemplo.com	\N	123456	t
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_usuario, nombre_usuario, "contraseña", estado) FROM stdin;
1	Adrian	123456	t
2	Maria	123456	t
\.


--
-- Name: informacion_general_identificador_general_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.informacion_general_identificador_general_seq', 42, true);


--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 2, true);


--
-- Name: alumnos alumnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (dni);


--
-- Name: clases clases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clases
    ADD CONSTRAINT clases_pkey PRIMARY KEY (nombre_clase);


--
-- Name: informacion_general informacion_general_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general
    ADD CONSTRAINT informacion_general_pkey PRIMARY KEY (identificador_general);


--
-- Name: materias materias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materias
    ADD CONSTRAINT materias_pkey PRIMARY KEY (nombre_materia);


--
-- Name: profesores profesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT profesores_pkey PRIMARY KEY (id_profesor);


--
-- Name: usuarios usuarios_nombre_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_nombre_usuario_key UNIQUE (nombre_usuario);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- Name: informacion_general fk_dni; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general
    ADD CONSTRAINT fk_dni FOREIGN KEY (dni) REFERENCES public.alumnos(dni);


--
-- Name: informacion_general fk_id_profesor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general
    ADD CONSTRAINT fk_id_profesor FOREIGN KEY (id_profesor) REFERENCES public.profesores(id_profesor);


--
-- Name: informacion_general fk_nombre_clase; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general
    ADD CONSTRAINT fk_nombre_clase FOREIGN KEY (nombre_clase) REFERENCES public.clases(nombre_clase);


--
-- Name: informacion_general fk_nombre_materia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.informacion_general
    ADD CONSTRAINT fk_nombre_materia FOREIGN KEY (nombre_materia) REFERENCES public.materias(nombre_materia);


--
-- PostgreSQL database dump complete
--

