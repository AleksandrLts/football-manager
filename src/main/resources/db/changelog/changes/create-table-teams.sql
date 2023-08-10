--liquibase formatted sql
--changeset sql:create-teams_table

CREATE TABLE teams
(
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `name`      varchar(255)    DEFAULT NULL,
    `country`    varchar(255)   DEFAULT NULL,
    `balance`    decimal(38, 2) DEFAULT NULL,
    `commission` decimal(38, 2) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb3;

--rollback DROP TABLE teams;
