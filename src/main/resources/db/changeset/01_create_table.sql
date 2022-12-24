--liquibase formatted sql

--changeset micbed:1

CREATE TABLE userTable (id INT PRIMARY KEY, firstName VARCHAR(256), lastName VARCHAR(256));
