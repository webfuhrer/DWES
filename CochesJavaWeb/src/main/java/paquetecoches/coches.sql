-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 14-02-2023 a las 13:35:05
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coches`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_marcas`
--

CREATE TABLE `t_marcas` (
  `id` int(11) NOT NULL,
  `marca` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `t_marcas`
--

INSERT INTO `t_marcas` (`id`, `marca`) VALUES
(1, 'Ford'),
(2, 'Renault'),
(3, 'Audi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_modelos`
--

CREATE TABLE `t_modelos` (
  `id_marca` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `modelo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `t_modelos`
--

INSERT INTO `t_modelos` (`id_marca`, `id`, `modelo`) VALUES
(1, 1, 'Focus'),
(1, 2, 'Orion'),
(2, 3, 'Scenic'),
(2, 4, 'Kangoo'),
(3, 5, 'A3'),
(3, 6, 'A5');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `t_marcas`
--
ALTER TABLE `t_marcas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `t_modelos`
--
ALTER TABLE `t_modelos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `t_marcas`
--
ALTER TABLE `t_marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `t_modelos`
--
ALTER TABLE `t_modelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
