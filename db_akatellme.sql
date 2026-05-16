-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2026 a las 02:02:23
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_akatellme`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sesion`
--

CREATE TABLE `tipo_sesion` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_sesion`
--

INSERT INTO `tipo_sesion` (`id`, `nombre`) VALUES
(1, 'Videoclip'),
(2, 'Videoclip'),
(3, 'Backstage'),
(4, 'Concierto'),
(5, 'Festival');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `nombre`) VALUES
(1, 'Artista'),
(2, 'Artista'),
(3, 'Artista'),
(4, 'DJ'),
(5, 'Organizador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `run` varchar(12) NOT NULL,
  `tipo_usuario_id` bigint(20) NOT NULL,
  `tipo_sesion_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `correo`, `nombres`, `run`, `tipo_usuario_id`, `tipo_sesion_id`) VALUES
(1, 'cantautoara', 'olasoylola@gmail.com', 'lolaloita', '12.232.425-2', 1, 1),
(2, 'Muñoz', 'marcianeke@gmail.com', 'Marcianeke', '11.111.111-1', 1, 3),
(3, 'Cornejo', 'pailita@gmail.com', 'Pailita', '22.222.222-2', 1, 4),
(4, 'Westcoast', 'polima@gmail.com', 'Polima', '33.333.333-3', 1, 1),
(5, 'MJ', 'crismj@gmail.com', 'Cris', '44.444.444-4', 1, 3),
(6, 'Retamales', 'standly@gmail.com', 'Standly', '55.555.555-5', 1, 2),
(7, 'Nicole', 'nickichile@gmail.com', 'Nicki', '66.666.666-6', 1, 4),
(8, 'Savagge', 'kingsavagge@gmail.com', 'King', '77.777.777-7', 2, 3),
(9, '23', 'jordan23@gmail.com', 'Jordan', '88.888.888-8', 1, 1),
(10, 'Mella', 'ginomella@gmail.com', 'Gino', '99.999.999-9', 2, 2),
(11, 'Sosa', 'juliannososa@gmail.com', 'Julianno', '10.101.010-1', 1, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tipo_sesion`
--
ALTER TABLE `tipo_sesion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe581tp719p3d7o5u2w9sre10b` (`tipo_usuario_id`),
  ADD KEY `FK23wx5gmegnh9shb9c1xd8v13e` (`tipo_sesion_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tipo_sesion`
--
ALTER TABLE `tipo_sesion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK23wx5gmegnh9shb9c1xd8v13e` FOREIGN KEY (`tipo_sesion_id`) REFERENCES `tipo_sesion` (`id`),
  ADD CONSTRAINT `FKe581tp719p3d7o5u2w9sre10b` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
