INSERT INTO faculty(id, name) VALUES (1, 'MM');
INSERT INTO faculty(id, name) VALUES (2, 'FSF');
INSERT INTO faculty(id, name) VALUES (3, 'IPF');

INSERT INTO student(id, facId, name, year) VALUES (1, 1, 'Enrique', 2);
INSERT INTO student(id, facId, name, year) VALUES (2, 1, 'Allison', 3);
INSERT INTO student(id, facId, name, year) VALUES (3, 2, 'Sylvia', 1);
INSERT INTO student(id, facId, name, year) VALUES (4, 2, 'Will', 4);
INSERT INTO student(id, facId, name, year) VALUES (5, 1, 'Ace', 5);

SELECT * FROM student;