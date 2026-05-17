-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2026 a las 06:06:02
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
-- Base de datos: `db_reservas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotografo`
--

CREATE TABLE `fotografo` (
  `id` bigint(20) NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fotografo`
--

INSERT INTO `fotografo` (`id`, `especialidad`, `nombre`) VALUES
(1, 'Eventos', 'Carlos Soto'),
(2, 'Matrimonios', 'Maria Torres'),
(3, 'Retratos', 'Javier Lopez'),
(4, 'Exterior', 'Daniela Rojas'),
(5, 'Empresas', 'Ignacio Perez'),
(6, 'Infantil', 'Fernanda Silva'),
(7, 'Moda', 'Sebastian Diaz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  `fotografo_id` bigint(20) DEFAULT NULL,
  `tipo_sesion_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `estado`, `fecha`, `hora`, `usuario_id`, `fotografo_id`, `tipo_sesion_id`) VALUES
(1, 'PENDIENTE', '2026-05-20', '15:00:00.000000', 4, 1, 1),
(2, 'PENDIENTE', '2026-04-20', '12:00:00.000000', 4, 1, 1),
(3, 'PENDIENTE', '2026-05-20', '18:00:00.000000', 4, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sesion`
--

CREATE TABLE `tipo_sesion` (
  `id` bigint(20) NOT NULL,
  `duracion` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_sesion`
--

INSERT INTO `tipo_sesion` (`id`, `duracion`, `nombre`, `precio`) VALUES
(1, 2, 'Sesion Premium', 50000),
(2, 2, 'Premium', 50000),
(3, 3, 'Exterior', 70000),
(4, 1, 'Interior', 30000),
(5, 2, 'Familiar', 65000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `fotografo`
--
ALTER TABLE `fotografo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfibhgqx1l9hoyknieilpawnn1` (`fotografo_id`),
  ADD KEY `FKpxyw03ww30imbp0b4h3spm94k` (`tipo_sesion_id`);

--
-- Indices de la tabla `tipo_sesion`
--
ALTER TABLE `tipo_sesion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `fotografo`
--
ALTER TABLE `fotografo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_sesion`
--
ALTER TABLE `tipo_sesion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FKfibhgqx1l9hoyknieilpawnn1` FOREIGN KEY (`fotografo_id`) REFERENCES `fotografo` (`id`),
  ADD CONSTRAINT `FKpxyw03ww30imbp0b4h3spm94k` FOREIGN KEY (`tipo_sesion_id`) REFERENCES `tipo_sesion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
