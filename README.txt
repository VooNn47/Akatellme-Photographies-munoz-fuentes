# AKATELLME PHOTOGRAPHIES

## Información del proyecto

AKATELLME PHOTOGRAPHIES es un sistema desarrollado para apoyar la gestión de un fotógrafo profesional, permitiendo organizar reservas, eventos, usuarios y otros servicios de forma más rápida y eficiente.

El proyecto está orientado a la administración de:

* Fotografía urbana.
* Videos musicales.
* Detrás de escena.
* Cobertura de conciertos y eventos.

Ha trabajado con artistas como:

* Jairo Vera
* Lleflight
* Gino Mella
* Cris MJ
* Jere Klein

---

## Integrantes

* Ian Muñoz
* Mathias Fuentes

---

## Arquitectura del sistema

El proyecto está basado en una arquitectura de microservicios, donde cada servicio posee su propia base de datos y funciona de manera independiente.

### Microservicios implementados

* Servicio de usuarios.
* Servicio de reservas.
* Servicio de pagos.
* Servicio de eventos.
* Servicio de notificaciones.
* Servicio de contacto.
* Servicio de reseñas.
* Servicio de disponibilidad.
* Servicio de autenticación.
* Servicio de fotografías.
* API Gateway.

---

## Funcionalidades del sistema

* Gestión de usuarios.
* Gestión de reservas.
* Gestión de eventos.
* Gestión de pagos.
* Gestión de reseñas.
* Gestión de solicitudes de contacto.
* Administración de disponibilidades.
* Sistema de autenticación mediante JWT.
* Sistema de notificaciones.
* Comunicación entre microservicios mediante WebClient.
* Documentación automática con Swagger.
* Validación de datos.
* Operaciones CRUD completas en cada servicio.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT
* Spring Cloud Gateway
* WebClient
* Swagger OpenAPI
* MySQL
* Maven
* Postman
* Git
* GitHub

---

## Estructura del proyecto

Cada microservicio cuenta con:

* Base de datos propia.
* Controller.
* Service.
* Repository.
* Entity.
* Configuraciones independientes.
* Documentación Swagger.

La comunicación entre servicios se realiza mediante WebClient y todas las solicitudes externas pasan por el API Gateway.

---

## Documentación de API

La documentación de los servicios se encuentra disponible mediante Swagger:

```http
http://localhost:8080/swagger-ui.html
```

---

## Puertos utilizados

| Servicio       | Puerto |
| -------------- | ------ |
| API Gateway    | 8080   |
| Usuarios       | 8082   |
| Reservas       | 8083   |
| Pagos          | 8084   |
| Eventos        | 8085   |
| Notificaciones | 8086   |
| Reseñas        | 8088   |
| Contacto       | 8089   |
| Disponibilidad | 8090   |

---

## Pasos para ejecutar el proyecto

1. Iniciar XAMPP y activar Apache y MySQL.

2. Crear las bases de datos correspondientes a cada microservicio.

3. Ejecutar todos los microservicios.

4. Ejecutar el API Gateway.

5. Acceder a Swagger:

```http
http://localhost:8080/swagger-ui.html
```

6. Realizar pruebas mediante Swagger o Postman.

---

## Comunicación entre microservicios

La comunicación entre servicios se implementa mediante WebClient.

Ejemplos:

* Reserva → Usuario.
* Reserva → Fotografía.
* Evento → Notificación.

---

## Control de versiones

Para el desarrollo del proyecto se utilizó Git y GitHub, trabajando mediante ramas para facilitar el trabajo colaborativo y el control de cambios.

---

## Autor

Proyecto desarrollado por estudiantes de Ingeniería en Informática como parte del proceso de aprendizaje de arquitectura de microservicios con Spring Boot.
