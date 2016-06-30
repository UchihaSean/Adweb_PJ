DROP DATABASE IF EXISTS adweb;

CREATE DATABASE adweb CHARACTER SET UTF8;

CREATE TABLE adweb.user(
  uid INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  password VARCHAR(20),
  portrait VARCHAR(10)
)CHARACTER SET UTF8;

CREATE TABLE adweb.view(
  vid INT PRIMARY KEY AUTO_INCREMENT,
  category INT,
  name VARCHAR(20),
  longitude FLOAT,
  latitude FLOAT,
  detail VARCHAR(100),
  picture VARCHAR(10)
)CHARACTER SET UTF8;

CREATE TABLE adweb.action(
  uid INT,
  vid INT,
  aid INT
)CHARACTER SET UTF8;

CREATE TABLE adweb.flag(
  fid INT,
  vid INT,
  longitude FLOAT,
  latitude FLOAT,
  addtion VARCHAR(100)
)CHARACTER SET UTF8;

CREATE TABLE adweb.comment(
  cid INT PRIMARY KEY AUTO_INCREMENT,
  vid INT,
  uid INT,
  grade INT,
  detail VARCHAR(100)
)CHARACTER SET UTF8;

CREATE TABLE adweb.resource(
  cid INT,
  url VARCHAR(10),
  type INT,
  addtion VARCHAR(100)
)CHARACTER SET UTF8;