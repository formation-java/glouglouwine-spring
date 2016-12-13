CREATE TABLE bottle (
  id           IDENTITY PRIMARY KEY,
  owner        VARCHAR(255) NOT NULL,
  domain       VARCHAR(255) NOT NULL,
  opening_date TIMESTAMP    NOT NULL,
);