-- # DROP DATABASE db_demo;
-- # CREATE DATABASE db_demo;
-- # used to be MySQL, now PostgreSQL
-- USE db_demo;

INSERT INTO region (name)
VALUES ('Europe'),
       ('Asia'),
       ('Africa'),
       ('North America'),
       ('South America'),
       ('Oceania');

INSERT INTO country (name, region_id, rate)
VALUES ('Russia', 1, 45.6),
       ('USA', 4, 120.3),
       ('China', 2, 75.8),
       ('India', 2, 90.2),
       ('Japan', 2, 150.7),
       ('Germany', 1, 110.5),
       ('France', 1, 80.9),
       ('United Kingdom', 1, 130.4),
       ('Italy', 1, 105.1),
       ('South Korea', 2, 70.6);