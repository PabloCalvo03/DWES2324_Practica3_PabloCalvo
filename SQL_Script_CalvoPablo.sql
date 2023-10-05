-- Borramos la base de datos si ya existe
DROP DATABASE IF EXISTS productosdb;

-- Crear la base de datos productosdb si no existe
CREATE DATABASE IF NOT EXISTS productosdb;

-- Usar la base de datos productosdb
USE productosdb;

-- Crear la tabla productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    peso FLOAT,
    stock INT
);

-- Insertamos algunos valores
INSERT INTO productos (nombre, descripcion, peso, stock) VALUES ('Razer BlackWidow', 'Teclado mecánico para juegos con retroiluminación RGB, interruptores Razer Green, teclas programables y reposamuñecas ergonómico.', 1.2, 50);
INSERT INTO productos (nombre, descripcion, peso, stock) VALUES ('Corsair K95 RGB Platinum', 'Teclado mecánico para juegos con retroiluminación RGB, interruptores Cherry MX Speed, teclas programables y controles multimedia dedicados.', 1.3, 40);
INSERT INTO productos (nombre, descripcion, peso, stock) VALUES ('Logitech G Pro X', 'Teclado mecánico para juegos personalizable con interruptores intercambiables, retroiluminación RGB, y diseño compacto.', 1.0, 30);
INSERT INTO productos (nombre, descripcion, peso, stock) VALUES ('SteelSeries Apex Pro', 'Teclado mecánico para juegos con interruptores SteelSeries OmniPoint ajustables, retroiluminación RGB, y reposamuñecas magnético.', 1.4, 35);
INSERT INTO productos (nombre, descripcion, peso, stock) VALUES ('HyperX Alloy FPS Pro', 'Teclado mecánico compacto para juegos con interruptores Cherry MX, teclas rojas para FPS, y cable desmontable.', 1.1, 60);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (userName, password) VALUES ('admin', 'admin');