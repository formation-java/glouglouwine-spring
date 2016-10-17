CREATE TABLE bottle (
  id             IDENTITY PRIMARY KEY,
  owner          VARCHAR(255) NOT NULL,
  grape_type     VARCHAR(255) NOT NULL,
  domain_name    VARCHAR(255) NOT NULL,
  year           INT NOT NULL,
  quantity       DOUBLE       NOT NULL,
  opening_date   TIMESTAMP    NOT NULL,
  finishing_date TIMESTAMP
);