-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2026 a las 02:02:03
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
-- Base de datos: `db_notificaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `id` bigint(20) NOT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  `mensaje` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `usuario_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notificacion`
--

INSERT INTO `notificacion` (`id`, `fecha`, `mensaje`, `tipo`, `usuario_id`) VALUES
(1, '2026-05-15', 'Tu reserva fue creada correctamente', 'Reserva', 2),
(2, '2026-05-15', 'Tu pago fue aprobado exitosamente', 'Pago', 3),
(3, '2026-05-16', 'Nuevo evento disponible en Movistar Arena', 'Evento', 4),
(4, '2026-05-16', 'Tu entrada fue confirmada', 'Reserva', 5),
(5, '2026-05-17', 'El evento Urban Santiago fue actualizado', 'Evento', 6),
(6, '2026-05-17', 'Pago recibido correctamente', 'Pago', 7),
(7, '2026-05-18', 'Tu sesión backstage fue confirmada', 'Reserva', 8),
(8, '2026-05-18', 'Nuevo festival agregado al sistema', 'Evento', 9),
(9, '2026-05-19', 'La reserva fue cancelada correctamente', 'Reserva', 10),
(10, '2026-05-19', 'Recordatorio de evento para mañana', 'Evento', 11),
(11, '2026-07-20', 'Se ha creado o actualizado el evento: Festival Urbano', 'Evento', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
