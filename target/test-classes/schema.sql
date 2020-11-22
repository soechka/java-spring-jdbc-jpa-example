DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS faculty;

CREATE TABLE faculty(
    id serial PRIMARY KEY,
    name varchar UNIQUE NOT NULL
);

CREATE TABLE student(
    id serial PRIMARY KEY,
    facId int,
    name varchar UNIQUE NOT NULL,
    year int NOT NULL CHECK (year > 0 AND year < 6)
);