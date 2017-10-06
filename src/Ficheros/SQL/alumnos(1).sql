-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2017 a las 19:42:34
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alumnos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `cod` int(11) NOT NULL,
  `dni` varchar(64) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(64) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(64) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(64) NOT NULL,
  `nacionalidad` varchar(64) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`cod`, `dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES
(34, '56489L', 'ESTHER', 'GÓMEZ', 67865456, 'ESPAÑOLA'),
(35, '645849G', 'EDUARDO', 'LAFOZ', 65456765, 'ESPAÑOLA'),
(36, '6489548F', 'ROBERTO', 'JIMENEZ', 65654656, 'ESPAÑOLA'),
(37, '9999999', 'FGHJHGF', 'DFGHFD', 56765456, 'ESPAÑOLA'),
(38, '333335L', 'EUGENIA', 'PINERO', 567654565, 'ESPAÑOLA'),
(39, '11111A', 'ALBERTO', 'JUEE', 456765, 'ESPAÑOLA'),
(40, '456787654D', 'JUANMAJOSUE', 'SDFGHGF', 45676543, 'ESPAÑOLA'),
(57, '87654', 'GUILLERMO', 'TUVILLEISON', 45654, 'OTRO'),
(58, '8765456765', 'FRANCISCO', 'OIE', 3454, 'OTRO'),
(59, '6545654H', 'YUPI', 'DFD', 567654565, 'ESPAÑOLA'),
(62, '56754G', 'VALERIA', 'RODRIGUEZ', 565454, 'ESPAÑOLA'),
(63, '775645K', 'AYMAN', 'ALSHAREEF', 65456765, 'ESPAÑOL'),
(72, 'SANCHEZ', '655576U', 'ALEXIS', 456543, 'ESPAÑOLA'),
(73, 'PAPA', '345654', 'PARGUE', 45654, 'ESPAÑOLA'),
(74, 'HAZAS', '45654L', 'MARTA', 45654, 'ESPAÑOLA'),
(75, 'GONZALEZ', '234565J', 'RAUL', 567654, 'ESPAÑOL'),
(76, '456543', 'PAPADOPOULUS', 'MCMENU', 456765, 'OTRO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`cod`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
