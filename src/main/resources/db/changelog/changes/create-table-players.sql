--liquibase formatted sql
--changeset sql:create-players_table splitStatements:true endDelimiter:;

CREATE TABLE players
(
    `id`                   bigint NOT NULL AUTO_INCREMENT,
    `first_name`           varchar(255) DEFAULT NULL,
    `last_name`            varchar(255) DEFAULT NULL,
    `date_of_birth`        date         DEFAULT NULL,
    `date_of_start_career` date         DEFAULT NULL,
    `team_id`              bigint       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb3;

--rollback DROP TABLE players;
