CREATE USER employees_user WITH PASSWORD 'password';

CREATE DATABASE employees_db;

GRANT ALL PRIVILEGES ON DATABASE employees_db TO employees_user;

\connect employees_db;

CREATE TYPE gender_type AS ENUM ('FEMALE', 'MALE');

CREATE TABLE IF NOT EXISTS employees(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) not null,
    second_name VARCHAR(20),
    first_last_name VARCHAR(20) not null,
    second_last_name VARCHAR(20) not null,
    age NUMERIC(2) not null,
    gender GENDER_TYPE not null,
    birth_date DATE not null,
    job VARCHAR(50) not null
);

GRANT INSERT ON employees TO employees_user;
GRANT SELECT ON employees TO employees_user;
GRANT DELETE ON employees TO employees_user;
GRANT UPDATE ON employees TO employees_user;
GRANT USAGE, SELECT ON SEQUENCE employees_id_seq TO employees_user;

INSERT INTO employees (first_name, second_name, first_last_name, second_last_name, age, gender, birth_date, job)
VALUES ('Laura', 'Sofía', 'Fernández', 'Gómez', 29, 'FEMALE', TO_DATE('18-03-1994', 'DD-MM-YYYY'), 'Contadora');

INSERT INTO employees (first_name, second_name, first_last_name, second_last_name, age, gender, birth_date, job)
VALUES ('Miguel', 'Ángel', 'Sánchez', 'Díaz', 52, 'MALE', TO_DATE('05-06-1971', 'DD-MM-YYYY'), 'Abogado');

INSERT INTO employees (first_name, second_name, first_last_name, second_last_name, age, gender, birth_date, job)
VALUES ('Isabella', '', 'Ramírez', 'Pérez', 35, 'FEMALE', TO_DATE('20-12-1988', 'DD-MM-YYYY'), 'Profesora');

INSERT INTO employees (first_name, second_name, first_last_name, second_last_name, age, gender, birth_date, job)
VALUES ('Javier', 'Alejandro', 'Morales', 'López', 41, 'MALE', TO_DATE('02-09-1982', 'DD-MM-YYYY'), 'Médico');

INSERT INTO employees (first_name, second_name, first_last_name, second_last_name, age, gender, birth_date, job)
VALUES ('Valeria', 'Carmen', 'Ortega', 'Ruiz', 26, 'FEMALE', TO_DATE('14-01-1997', 'DD-MM-YYYY'), 'Enfermera');

