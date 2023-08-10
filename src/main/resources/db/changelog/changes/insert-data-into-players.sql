--liquibase formatted sql
--changeset sql:insert-players-data splitStatements:true endDelimiter:;

INSERT INTO players (first_name, last_name, date_of_birth, date_of_start_career, team_id)
VALUES ('John', 'Doe', '1990-05-15', '2010-01-01', 1),
       ('Jane', 'Smith', '1995-08-22', '2012-04-10', 2),
       ('Michael', 'Johnson', '1988-12-03', '2009-07-20', 3),
       ('Emily', 'Brown', '1993-06-18', '2014-03-05', 1),
       ('Robert', 'Williams', '1992-04-25', '2013-09-12', 2),
       ('Sophia', 'Jones', '1989-09-07', '2011-11-30', 3),
       ('William', 'Miller', '1994-03-12', '2015-06-22', 1),
       ('Olivia', 'Taylor', '1991-11-09', '2012-12-18', 2),
       ('David', 'Anderson', '1997-02-28', '2016-08-05', 3),
       ('Ava', 'Martin', '1996-07-14', '2015-01-30', 1);

--rollback
