# Proyecto Mateo

## Arquitectura

Basada en la arquitectura de la asignatura ([atilanof/proyectoISW](https://github.com/atilanof/proyectoISW)):
cliente Swing (`ui`) → `client` → sockets → `server` → `controler` → `dao` → PostgreSQL.

## Configuración

1. Copia `src/main/resources/properties.example.xml` como `src/main/resources/properties.xml`.
2. Pon en él los datos de tu base de datos. `properties.xml` no se sube a GitHub (está en `.gitignore`).

## Ejecutar

- Tests: `mvn test`
- Generar los jar: `mvn package` → `target/server_isw.jar` y `target/client_isw.jar`
- Arrancar primero el servidor (`java -jar target/server_isw.jar`) y después el cliente (`java -jar target/client_isw.jar`).
