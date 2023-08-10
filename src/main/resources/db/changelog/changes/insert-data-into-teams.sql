--liquibase formatted sql
--changeset sql:insert-players-data splitStatements:true endDelimiter:;

INSERT INTO teams (name, country, balance, commission)
VALUES ('Team A', 'USA', 100000.00, 5),
       ('Team B', 'England', 85000.50, 7),
       ('Team C', 'Germany', 120000.75, 3);

--rollback
