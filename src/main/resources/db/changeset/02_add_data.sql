--liquibase formatted sql

--changeset micbed:2

INSERT INTO
    userTable (id, firstName, lastName)
VALUES
    ('1', 'Michal', 'Bedziak')