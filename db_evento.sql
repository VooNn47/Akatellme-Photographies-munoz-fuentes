-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2026 a las 02:02:12
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
-- Base de datos: `db_evento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventoi`
--

CREATE TABLE `eventoi` (
  `id` bigint(20) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `lugar` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `usuario_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `eventoi`
--

INSERT INTO `eventoi` (`id`, `fecha`, `lugar`, `nombre`, `usuario_id`) VALUES
(1, '2026-06-20', 'Movistar Arena', 'Urban Santiago', 2),
(2, '2026-07-10', 'Teatro Caupolican', 'Trap Night', 3),
(3, '2026-08-05', 'Estadio Nacional', 'Festival Reggaeton Chile', 4),
(4, '2026-06-30', 'Club Chocolate', 'Backstage VIP', 5),
(5, '2026-12-15', 'Arena Monticello', 'Summer Music Fest', 6),
(6, '2026-09-02', 'Gran Arena Monticello', 'Concierto Urbano', 7),
(7, '2026-10-11', 'Hipodromo Chile', 'Flow Fest Chile', 8),
(8, '2026-06-01', 'Santiago Centro', 'Videoclip Session', 9),
(9, '2026-11-08', 'Espacio Riesco', 'DJ Night Session', 10),
(10, '2026-12-20', 'Movistar Arena', 'Festival Trap Stars', 11),
(11, '2026-07-20', 'Movistar Arena', 'Festival Urbano', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventoi`
--
ALTER TABLE `eventoi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventoi`
--
ALTER TABLE `eventoi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
