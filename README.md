# ENLACE POSTMAN

https://documenter.getpostman.com/view/29777158/2s9YJgTLWM

# Creación de la Base de Datos

DROP DATABASE IF EXISTS db_superhero;
CREATE DATABASE db_superhero;
USE db_superhero;

# Creación de la Tabla 'heros'

CREATE TABLE heros (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR(15) NOT NULL
);

# Creación de la Tabla 'powers'

CREATE TABLE powers (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR(15) NOT NULL
);

# Creación de la Tabla 'heros_powers' (Relación Many-to-Many)

CREATE TABLE heros_powers (
id_hero INT NOT NULL,
id_power INT NOT NULL,
power_level INT NOT NULL,
PRIMARY KEY (id_hero, id_power),
FOREIGN KEY (id_power) REFERENCES powers (id) ON DELETE CASCADE,
FOREIGN KEY (id_hero) REFERENCES heros (id) ON DELETE CASCADE
);
