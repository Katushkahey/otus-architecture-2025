--liquibase formatted sql

--changeset eivanova:create-table-users

CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(256) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--rollback DROP TABLE users;