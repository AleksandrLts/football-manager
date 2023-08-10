--liquibase formatted sql
--changeset sql:create
--liquibase formatted sql
--changeset sql:create-teams_players_table

CREATE TABLE teams_players
(
    players_id bigint NOT NULL,
    team_id    bigint NOT NULL,
    primary key (team_id, players_id)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb3;

--rollback DROP TABLE teams_players;
