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
    id_alumno integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    fecha_nacimiento date NOT NULL,
    direccion character varying(100) NOT NULL,
    telefono character varying(20) NOT NULL
);


ALTER TABLE public.alumnos OWNER TO postgres;

--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alumnos_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumnos_id_alumno_seq OWNER TO postgres;

--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_id_alumno_seq OWNED BY public.alumnos.id_alumno;


--
-- Name: asignaturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignaturas (
    id_asignatura integer NOT NULL,
    nombre_asignatura character varying(50) NOT NULL
);


ALTER TABLE public.asignaturas OWNER TO postgres;

--
-- Name: asignaturas_id_asignatura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asignaturas_id_asignatura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asignaturas_id_asignatura_seq OWNER TO postgres;

--
-- Name: asignaturas_id_asignatura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asignaturas_id_asignatura_seq OWNED BY public.asignaturas.id_asignatura;


--
-- Name: cursos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cursos (
    id_curso integer NOT NULL,
    nombre_curso character varying(50) NOT NULL,
    ano integer NOT NULL
);


ALTER TABLE public.cursos OWNER TO postgres;

--
-- Name: cursos_id_curso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cursos_id_curso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cursos_id_curso_seq OWNER TO postgres;

--
-- Name: cursos_id_curso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cursos_id_curso_seq OWNED BY public.cursos.id_curso;


--
-- Name: matriculas_asignaturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas_asignaturas (
    id_matricula_asignatura integer NOT NULL,
    id_alumno integer NOT NULL,
    id_asignatura integer NOT NULL,
    id_profesor integer NOT NULL,
    id_matricula_curso integer NOT NULL
);


ALTER TABLE public.matriculas_asignaturas OWNER TO postgres;

--
-- Name: matriculas_asignaturas_id_matricula_asignatura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matriculas_asignaturas_id_matricula_asignatura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.matriculas_asignaturas_id_matricula_asignatura_seq OWNER TO postgres;

--
-- Name: matriculas_asignaturas_id_matricula_asignatura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matriculas_asignaturas_id_matricula_asignatura_seq OWNED BY public.matriculas_asignaturas.id_matricula_asignatura;


--
-- Name: matriculas_cursos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas_cursos (
    id_matricula_curso integer NOT NULL,
    id_alumno integer NOT NULL,
    id_curso integer NOT NULL,
    nombre character varying(50),
    nombre_curso character varying(50),
    apellido character varying(50)
);


ALTER TABLE public.matriculas_cursos OWNER TO postgres;

--
-- Name: matriculas_cursos_id_matricula_curso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matriculas_cursos_id_matricula_curso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.matriculas_cursos_id_matricula_curso_seq OWNER TO postgres;

--
-- Name: matriculas_cursos_id_matricula_curso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matriculas_cursos_id_matricula_curso_seq OWNED BY public.matriculas_cursos.id_matricula_curso;


--
-- Name: notas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notas (
    id_nota integer NOT NULL,
    id_alumno integer NOT NULL,
    id_asignatura integer NOT NULL,
    id_profesor integer NOT NULL,
    id_curso integer NOT NULL,
    nota integer NOT NULL
);


ALTER TABLE public.notas OWNER TO postgres;

--
-- Name: notas_id_nota_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notas_id_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notas_id_nota_seq OWNER TO postgres;

--
-- Name: notas_id_nota_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notas_id_nota_seq OWNED BY public.notas.id_nota;


--
-- Name: profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesores (
    id_profesor integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(20) NOT NULL
);


ALTER TABLE public.profesores OWNER TO postgres;

--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesores_id_profesor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesores_id_profesor_seq OWNER TO postgres;

--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesores_id_profesor_seq OWNED BY public.profesores.id_profesor;


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
-- Name: alumnos id_alumno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos ALTER COLUMN id_alumno SET DEFAULT nextval('public.alumnos_id_alumno_seq'::regclass);


--
-- Name: asignaturas id_asignatura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignaturas ALTER COLUMN id_asignatura SET DEFAULT nextval('public.asignaturas_id_asignatura_seq'::regclass);


--
-- Name: cursos id_curso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cursos ALTER COLUMN id_curso SET DEFAULT nextval('public.cursos_id_curso_seq'::regclass);


--
-- Name: matriculas_asignaturas id_matricula_asignatura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas ALTER COLUMN id_matricula_asignatura SET DEFAULT nextval('public.matriculas_asignaturas_id_matricula_asignatura_seq'::regclass);


--
-- Name: matriculas_cursos id_matricula_curso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos ALTER COLUMN id_matricula_curso SET DEFAULT nextval('public.matriculas_cursos_id_matricula_curso_seq'::regclass);


--
-- Name: notas id_nota; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas ALTER COLUMN id_nota SET DEFAULT nextval('public.notas_id_nota_seq'::regclass);


--
-- Name: profesores id_profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores ALTER COLUMN id_profesor SET DEFAULT nextval('public.profesores_id_profesor_seq'::regclass);


--
-- Name: usuarios id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (id_alumno, nombre, apellido, fecha_nacimiento, direccion, telefono) FROM stdin;
1	Juan	Pérez	2011-05-17	Calle 123	123456789
2	María	Gómez	2011-07-20	Avenida 456	987654321
3	Pedro	López	2011-03-10	Calle Principal	456789123
4	Laura	Martínez	2011-09-05	Avenida Central	321654987
5	Carlos	Rodríguez	2011-11-14	Calle Secundaria	789123456
6	Ana	Hernández	2011-01-02	Avenida 789	654987321
7	Luis	Torres	2011-08-08	Calle Norte	321789654
8	Sofía	Vargas	2011-06-30	Avenida Sur	987321654
9	Diego	Silva	2011-04-25	Calle Este	789654321
10	Valentina	Rojas	2011-10-19	Avenida Oeste	654321789
11	Gabriel	García	2011-02-15	Calle 1	321456987
12	Isabella	Luna	2011-12-25	Avenida 2	987123654
13	Andrés	Navarro	2011-07-01	Calle 3	456789321
14	Camila	Sánchez	2011-05-28	Avenida 4	321654789
15	Alejandro	Romero	2011-09-10	Calle 5	789321456
16	Andrea	López	2008-10-01	Calle 123	123456789
17	David	García	2008-12-15	Avenida 456	987654321
18	Paula	Fernández	2008-06-20	Calle Principal	456789123
19	Miguel	Hernández	2008-09-30	Avenida Central	321654987
20	Lucía	Martínez	2008-05-10	Calle Secundaria	789123456
21	Javier	Vargas	2008-07-18	Avenida 789	654987321
22	Valeria	Torres	2008-04-05	Calle Norte	321789654
23	Diego	Sánchez	2008-08-27	Avenida Sur	987321654
24	Sara	Rodríguez	2008-02-12	Calle Este	789654321
25	Manuel	Gómez	2008-11-25	Avenida Oeste	654321789
26	Carla	Luna	2008-01-08	Calle 1	321456987
27	Hugo	Silva	2008-03-30	Avenida 2	987123654
28	Isabel	Rojas	2008-09-18	Calle 3	456789321
29	Pablo	Navarro	2008-07-21	Avenida 4	321654789
30	Victoria	Pérez	2008-05-06	Calle 5	789321456
31	Juan	García	1998-05-10	Calle Principal 123	1234567890
32	María	López	1999-02-15	Avenida Central 456	0987654321
33	Pedro	Martínez	2000-09-20	Plaza Mayor 789	9876543210
34	Ana	Rodríguez	1997-12-05	Calle Secundaria 234	5678901234
35	Carlos	Hernández	1996-08-01	Avenida Principal 567	0123456789
36	Laura	González	1995-07-18	Plaza Central 890	4567890123
37	José	Pérez	1998-03-25	Calle Mayor 345	9012345678
38	Sofía	Ramírez	1999-10-30	Avenida Secundaria 678	3456789012
39	Andrés	Silva	2000-06-12	Plaza Principal 901	7890123456
40	Isabella	Vargas	1997-09-07	Calle Central 456	2345678901
41	Gabriel	Fernández	1996-11-23	Avenida Mayor 789	6789012345
42	Valentina	Lara	1995-04-14	Plaza Secundaria 012	0123456789
43	Ricardo	Ortega	1998-01-03	Calle Principal 567	4567890123
44	Fernanda	Gómez	1999-08-28	Avenida Central 890	8901234567
45	Javier	Torres	2000-12-15	Plaza Mayor 123	1234567890
46	Camila	Mendoza	1997-05-22	Calle Secundaria 234	0987654321
47	Daniel	Castro	1996-02-08	Avenida Principal 456	9876543210
\.


--
-- Data for Name: asignaturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignaturas (id_asignatura, nombre_asignatura) FROM stdin;
1	Matemáticas
2	Lengua y Literatura
3	Ciencias Naturales
4	Geografía e Historia
5	Inglés
6	Educación Física
\.


--
-- Data for Name: cursos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cursos (id_curso, nombre_curso, ano) FROM stdin;
1	1ESO	2023
2	2ESO	2023
3	3ESO	2023
\.


--
-- Data for Name: matriculas_asignaturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas_asignaturas (id_matricula_asignatura, id_alumno, id_asignatura, id_profesor, id_matricula_curso) FROM stdin;
\.


--
-- Data for Name: matriculas_cursos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas_cursos (id_matricula_curso, id_alumno, id_curso, nombre, nombre_curso, apellido) FROM stdin;
1	1	1	Juan	1ESO	Pérez
2	2	1	María	1ESO	Gómez
3	3	1	Pedro	1ESO	López
4	4	1	Laura	1ESO	Martínez
5	5	1	Carlos	1ESO	Rodríguez
6	6	1	Ana	1ESO	Hernández
7	7	1	Luis	1ESO	Torres
8	8	1	Sofía	1ESO	Vargas
9	9	1	Diego	1ESO	Silva
10	10	1	Valentina	1ESO	Rojas
11	11	1	Gabriel	1ESO	García
12	12	1	Isabella	1ESO	Luna
13	13	1	Andrés	1ESO	Navarro
14	14	1	Camila	1ESO	Sánchez
15	15	1	Alejandro	1ESO	Romero
16	16	2	Andrea	2ESO	López
17	17	2	David	2ESO	García
18	18	2	Paula	2ESO	Fernández
19	19	2	Miguel	2ESO	Hernández
20	20	2	Lucía	2ESO	Martínez
21	21	2	Javier	2ESO	Vargas
22	22	2	Valeria	2ESO	Torres
23	23	2	Diego	2ESO	Sánchez
24	24	2	Sara	2ESO	Rodríguez
25	25	2	Manuel	2ESO	Gómez
26	26	2	Carla	2ESO	Luna
27	27	2	Hugo	2ESO	Silva
28	28	2	Isabel	2ESO	Rojas
29	29	2	Pablo	2ESO	Navarro
30	30	2	Victoria	2ESO	Pérez
31	31	1	Juan	3ESO	García
32	32	1	María	3ESO	López
33	33	1	Pedro	3ESO	Martínez
34	34	1	Ana	3ESO	Rodríguez
35	35	1	Carlos	3ESO	Hernández
36	36	1	Laura	3ESO	González
37	37	1	José	3ESO	Pérez
38	38	1	Sofía	3ESO	Ramírez
39	39	1	Andrés	3ESO	Silva
40	40	1	Isabella	3ESO	Vargas
41	41	1	Gabriel	3ESO	Fernández
42	42	1	Valentina	3ESO	Lara
43	43	1	Ricardo	3ESO	Ortega
44	44	1	Fernanda	3ESO	Gómez
45	45	1	Javier	3ESO	Torres
46	46	1	Camila	3ESO	Mendoza
\.


--
-- Data for Name: notas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notas (id_nota, id_alumno, id_asignatura, id_profesor, id_curso, nota) FROM stdin;
\.


--
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesores (id_profesor, nombre, apellido, email, telefono) FROM stdin;
1	Adrian	Gómez	adrian@example.com	123456789
2	Maria	López	maria@example.com	987654321
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_usuario, nombre_usuario, "contraseña", estado) FROM stdin;
1	Adrian	123456	t
2	Maria	123456	t
\.


--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_alumno_seq', 1, false);


--
-- Name: asignaturas_id_asignatura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asignaturas_id_asignatura_seq', 1, false);


--
-- Name: cursos_id_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cursos_id_curso_seq', 1, false);


--
-- Name: matriculas_asignaturas_id_matricula_asignatura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matriculas_asignaturas_id_matricula_asignatura_seq', 1, false);


--
-- Name: matriculas_cursos_id_matricula_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matriculas_cursos_id_matricula_curso_seq', 1, false);


--
-- Name: notas_id_nota_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notas_id_nota_seq', 1, false);


--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesores_id_profesor_seq', 1, false);


--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 2, true);


--
-- Name: alumnos alumnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id_alumno);


--
-- Name: asignaturas asignaturas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignaturas
    ADD CONSTRAINT asignaturas_pkey PRIMARY KEY (id_asignatura);


--
-- Name: cursos cursos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cursos
    ADD CONSTRAINT cursos_pkey PRIMARY KEY (id_curso);


--
-- Name: matriculas_asignaturas matriculas_asignaturas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas
    ADD CONSTRAINT matriculas_asignaturas_pkey PRIMARY KEY (id_matricula_asignatura);


--
-- Name: matriculas_cursos matriculas_cursos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos
    ADD CONSTRAINT matriculas_cursos_pkey PRIMARY KEY (id_matricula_curso);


--
-- Name: notas notas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas
    ADD CONSTRAINT notas_pkey PRIMARY KEY (id_nota);


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
-- Name: matriculas_cursos fk_alumno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos
    ADD CONSTRAINT fk_alumno FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id_alumno);


--
-- Name: matriculas_asignaturas fk_id_alumno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas
    ADD CONSTRAINT fk_id_alumno FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id_alumno);


--
-- Name: matriculas_asignaturas fk_id_asignatura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas
    ADD CONSTRAINT fk_id_asignatura FOREIGN KEY (id_asignatura) REFERENCES public.asignaturas(id_asignatura);


--
-- Name: matriculas_asignaturas fk_id_matricula_curso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas
    ADD CONSTRAINT fk_id_matricula_curso FOREIGN KEY (id_matricula_curso) REFERENCES public.matriculas_cursos(id_matricula_curso);


--
-- Name: matriculas_asignaturas fk_id_profesor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_asignaturas
    ADD CONSTRAINT fk_id_profesor FOREIGN KEY (id_profesor) REFERENCES public.profesores(id_profesor);


--
-- Name: matriculas_cursos fk_matriculas_cursos_alumnos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos
    ADD CONSTRAINT fk_matriculas_cursos_alumnos FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id_alumno);


--
-- Name: matriculas_cursos matriculas_cursos_id_alumno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos
    ADD CONSTRAINT matriculas_cursos_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id_alumno);


--
-- Name: matriculas_cursos matriculas_cursos_id_curso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_cursos
    ADD CONSTRAINT matriculas_cursos_id_curso_fkey FOREIGN KEY (id_curso) REFERENCES public.cursos(id_curso);


--
-- Name: notas notas_id_alumno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas
    ADD CONSTRAINT notas_id_alumno_fkey FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id_alumno);


--
-- Name: notas notas_id_asignatura_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas
    ADD CONSTRAINT notas_id_asignatura_fkey FOREIGN KEY (id_asignatura) REFERENCES public.asignaturas(id_asignatura);


--
-- Name: notas notas_id_curso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas
    ADD CONSTRAINT notas_id_curso_fkey FOREIGN KEY (id_curso) REFERENCES public.cursos(id_curso);


--
-- Name: notas notas_id_profesor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notas
    ADD CONSTRAINT notas_id_profesor_fkey FOREIGN KEY (id_profesor) REFERENCES public.profesores(id_profesor);


--
-- PostgreSQL database dump complete
--

