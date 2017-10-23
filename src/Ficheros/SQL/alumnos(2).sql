-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2017 a las 20:53:22
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
CREATE DATABASE IF NOT EXISTS `alumnos` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `alumnos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `dni` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nacionalidad` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(255) NOT NULL,
  `id_curso` int(11) NOT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE KEY `dni` (`dni`),
  KEY `id_curso` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`cod`, `nombre`, `apellido`, `dni`, `nacionalidad`, `telefono`, `id_curso`) VALUES
(1, 'TAYSIR', 'ALSHAREEF', '50473603B', 'ESPAÑOLA', 622256070, 3),
(2, 'ESTHER', 'GÓMEZ', '56489L', 'ESPAÑOLA', 67865456, 3),
(3, 'EDUARDO', 'LAFOZ', '645849G', 'ESPAÑOLA', 65456765, 3),
(4, 'ROBERTO', 'JIMENEZ', '6489548F', 'ESPAÑOLA', 65654656, 3),
(5, 'FGHJHGF', 'DFGHFD', '9999999', 'ESPAÑOLA', 56765456, 3),
(6, 'EUGENIA', 'PINERO', '333335L', 'ESPAÑOLA', 567654565, 3),
(7, 'ALBERTO', 'JUEE', '11111A', 'ESPAÑOLA', 456765, 3),
(8, 'FRANCISCO', 'OIE', '8765456765', 'OTRO', 3454, 3),
(9, 'YUPI', 'DFD', '6545654H', 'ESPAÑOLA', 567654565, 3),
(10, 'VALERIA', 'RODRIGUEZ', '56754G', 'ESPAÑOLA', 565454, 3),
(11, 'AYMAN', 'ALSHAREEF', '775645K', 'ESPAÑOL', 65456765, 3),
(12, 'PAPADOPOULUS', 'MCMENU', '456543', 'OTRO', 456765, 3),
(13, 'FFFFFF', 'FFFFF', '44444444444', 'ESPAÑOLA', 222222222, 3),
(14, 'PACO', 'FGGFGFGFG', '5654545654', 'ESPAÑOLA', 3456545, 3),
(15, 'JOSUEE', 'JUANMAJOSUEEE', '5676543D', 'ESPAÑOLA', 4567654, 3),
(16, 'IIIIIIIIIIIIIIIII', 'IIIIIIIIIIIIIIII', 'FFFFFFFFFFFFFF4', 'ESPAÑOLA', 23455, 3),
(17, 'IIIIIIIIIIIIIIIII', 'IIIIIIIIIIIIIIII', 'DFGFDS', 'ESPAÑOLA', 23455, 3),
(18, 'MARIAAAAAA', 'DFGFDS', '3456543', 'ESPAÑOLA', 456545, 3),
(19, 'ALUMNO1', 'AAAA', '33333FFDJ', 'ESPAÑOLA', 45654, 8),
(25, 'JAIMEZ', 'LORE', '457HGT', 'ESPAÑOLA', 45654, 10),
(94, 'AURELIO', 'LORE', '67654', 'ESPAÑOLA', 45654, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCurso` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fechaInicial` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fechaFinal` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `titulacion` enum('GRADO','CICLO FORMATIVO SUPERIOR','CICLO FORMATIVO MEDIO','POST GRADO') COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nombreCurso` (`nombreCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`ID`, `nombreCurso`, `fechaInicial`, `fechaFinal`, `titulacion`) VALUES
(3, 'AJEI', '12-05-2017', '12-05-2017', 'CICLO FORMATIVO SUPERIOR'),
(4, 'ASIR', '12-05-2017', '12-05-2017', 'CICLO FORMATIVO SUPERIOR'),
(8, 'INGENIERÍA DE SOFTWARE', '12-05-2017', '12-05-2017', 'GRADO'),
(10, 'IG.CLOUD COMPUTING', '20-10-2017', '19-10-2017', 'GRADO');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
